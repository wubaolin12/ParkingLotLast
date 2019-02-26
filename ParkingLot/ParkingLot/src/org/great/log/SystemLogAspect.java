package org.great.log;

import java.lang.reflect.Method;
import java.net.InetAddress;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.great.bean.Log;
import org.great.bean.User;
import org.great.biz.LogBiz;
import org.great.util.DateTool;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 日志切面
 * 
 * @author 吴宝林
 *
 */
@Aspect
@Component
public class SystemLogAspect {
	
	@Resource
	LogBiz logBiz;

	private static Logger logger = Logger.getLogger("zxtest");

	/**
	 * 切点，这里只拦截handler里面的操作
	 */
	@Pointcut("execution (* org.great.handler..*.*(..))")
	public void controller() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint 切点
	 */
	@Before("controller()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("==========执行controller前置通知===============");

		if (logger.isInfoEnabled()) {
			logger.info("before " + joinPoint);
		}
	}

	/**
	 * 后置通知，记录日志
	 * 
	 * @param joinPoint
	 */
	@After("controller()")
	public void after(JoinPoint joinPoint) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (request.getRequestURI().contains("exit")) {
			return;
		}
		HttpSession session = request.getSession();

		// 获取当前操作人
		User user = (User) session.getAttribute("User");
//		User user = (User) request.getAttribute("User");
		// 获取操作人ip地址
		String ip = getIpAddress(request);

		try {
			
			//操作的类名
			String targetName = joinPoint.getTarget().getClass().getName();
			//操作的方法名
//			String methodName = joinPoint.getSignature().getName();
			String methodName = joinPoint.getSignature().getName();
			
			//获取连接点方法运行时的入参列表
			Object[] arguments = joinPoint.getArgs();
			System.out.println(targetName + "~~~" + methodName + "~~~~" + Arrays.toString(arguments));
			
			//通过类名反射，获取类实例
			Class targetclass = Class.forName(targetName);
			Method[] methods = targetclass.getMethods();
			String operationType = "";
			String operationName = "";

			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();

					if (clazzs.length == arguments.length) {
						OperationLog operationLog = method.getAnnotation(OperationLog.class);
						
						//不需要记录操作记录的直接返回
						if(operationLog==null) {
							System.out.println("---该方法没有记录日志---");
							return;
						}
						
						operationType = operationLog.operationType();
						operationName = operationLog.operationName();
						break;
					}
				}
				System.out.println("操作类型=" + operationType + "操作名=" + operationName);
			}

			// *========日志存储到数据库=========*//
			Log log = new Log();
			log.setLog_event(operationName);
			log.setLog_type(operationType+ "." + 
					(joinPoint.getTarget().getClass().getName() + "." 
							+ joinPoint.getSignature().getName() + "()"));
			log.setLog_ip(ip);
			log.setU_id(user.getU_id());
			log.setLog_date(DateTool.getTime());
			
			// 插入数据库
			logBiz.addLog(log);  
			System.out.println("=====controller记录日志成功=====");

		} catch (Exception e) {
			System.out.println("---------日志操作失败-------------");
			e.printStackTrace();
		}
	}
	
	
	@Around("controller()")
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("==========开始执行controller环绕通知===============");
		long start = System.currentTimeMillis();

		String methodName = joinPoint.getSignature().getName();

		try {
			long end = System.currentTimeMillis();
			if (logger.isInfoEnabled()) {
				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
			}
			System.out.println("==========结束执行controller环绕通知===============");
		} catch (Throwable e) {
			System.out.println("环绕通知中的异常--------------------------------" + methodName + "-------" + e.getMessage());
			long end = System.currentTimeMillis();
			if (logger.isInfoEnabled()) {
				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
						+ e.getMessage());
			}
		}
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}



	/**
	 * 异常通知 用于拦截记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "controller()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
		/*
		 * HttpServletRequest request = ((ServletRequestAttributes)
		 * RequestContextHolder.getRequestAttributes()).getRequest(); HttpSession
		 * session = request.getSession(); //读取session中的用户 User user = (User)
		 * session.getAttribute(WebConstants.CURRENT_USER); //获取请求ip String ip =
		 * request.getRemoteAddr();
		 */
		// 获取用户请求方法的参数并序列化为JSON格式字符串
		System.out.println("异常通知开始------------------------------------------");
		long end = System.currentTimeMillis();
		if (logger.isInfoEnabled()) {
			logger.info("around " + joinPoint + "\tUse time : " + (end) + " ms with exception : "
					+ e.getMessage());
		}
		
	}
	
	/**
	 * 	获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");
	    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	    	System.out.println("X-Real-IP-------"+ip);
	    	ip = request.getHeader("X-Real-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	        System.out.println("Proxy-Client-IP-------"+ip);
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP"+ip);
	        System.out.println("WL-Proxy-Client-IP-------"+ip);
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	        System.out.println("getRemoteAddr-------"+ip);
	    }
	    if (ip.contains(",")) {
	        return ip.split(",")[0];
	    } else {
	        return ip;
	    }
	}
	
}
