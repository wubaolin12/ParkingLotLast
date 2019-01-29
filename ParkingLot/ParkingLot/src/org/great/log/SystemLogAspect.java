package org.great.log;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 日志切面
 * @author Administrator
 *
 */
@Aspect
@Component
public class SystemLogAspect {

	//�е�
	@Pointcut("execution(* org.great.log..*.*(..))")
	public void Controll(){
		
		
	}
	
	//��ǿǰ��֪ͨ
	@Before("controll()")
	  public void beforeMethod(JoinPoint joinPoint){
		
		System.out.println("Ŀ�귽����Ϊ:" + joinPoint.getSignature().getName());
        System.out.println("Ŀ�귽��������ļ�����:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("Ŀ�귽�������������:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("Ŀ�귽����������:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //��ȡ����Ŀ�귽���Ĳ���
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("��" + (i+1) + "������Ϊ:" + args[i]);
        }
        System.out.println("������Ķ���:" + joinPoint.getTarget());
        System.out.println("��������Լ�:" + joinPoint.getThis());
	}
	
	//������ǿ
	@After("controll()")
	public void after(JoinPoint joinPoint){
		
		 /* HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();  */
        //��ȡsession�е��û�  
       // User user = (User) session.getAttribute("user");  
        //�����IP  
        //String ip = request.getRemoteAddr();
		
		User user = new User();
		user.setId(1);
		user.setName("�״�ү");
		 String ip = "127.0.0.1";
		 try {
		 
		 String targetName = joinPoint.getTarget().getClass().getName();
		 String methodName = joinPoint.getSignature().getName();
		 Object[] arguments = joinPoint.getArgs();
		 System.out.println(targetName+"~~~"+methodName+"~~~~"+arguments);
		 Class targetclass = Class.forName(targetName);
		 Method[] methods = targetclass.getMethods();
		 String operationType = "";
         String operationName = "";
         
         for(Method method:methods){
        	 if(method.getName().equals(methodName)){
        		 Class[] clazzs = method.getParameterTypes();
        		 
        		 if(clazzs.length==arguments.length){
        			 
        			 operationType=method.getAnnotation(Log.class).operationType();
        			 operationName=method.getAnnotation(Log.class).operationName();
        			 break;
        		 }
        	 }
        	 System.out.println("����="+operationType+"����="+operationName);
         }
         //*========����̨���=========*//  
         System.out.println("=====controller����֪ͨ��ʼ=====");  
         System.out.println("���󷽷�:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
         System.out.println("��������:" + operationName);  
         System.out.println("������:" + user.getName());  
         System.out.println("����IP:" + ip);  
         //*========���ݿ���־=========*//  
         SystemLog log = new SystemLog();  
         log.setId(UUID.randomUUID().toString());
         log.setDescription(operationName);  
         log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
         log.setLogType((long)0);  
         log.setRequestIp(ip);  
         log.setExceptioncode( null);  
         log.setExceptionDetail( null);  
         log.setParams( null);  
         log.setCreateBy(user.getName());  
         log.setCreateDate(new Date());  
         //�������ݿ�  
//         systemLogService.insert(log);  
         System.out.println("=====controller����֪ͨ����=====");  
		
		 } catch (ClassNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	}
}
