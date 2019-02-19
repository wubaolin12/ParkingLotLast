package org.great.fore_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Cust;
import org.great.biz.CustBiz;
import org.great.util.BaseUtil;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

/**
 * 前端客户端管理
 * 
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/fore")
public class ForeLoginHandler {

	@Resource
	public CustBiz custBiz; // 用户dao接口
	
	@Resource
	BaseUtil baseUtil;

	/**
	 * 登录成功跳转
	 */

	@RequestMapping("/success1.do")
	public String success1() {
		return "Fore/foreMain";
	}

	/**
	 * 跳转前端 登录界面
	 */
	@RequestMapping("/foreLogin.do")
	public String foreLogin() {
		return "Fore/foreLogin";
	}

	/**
	 * 跳转前端 注册界面
	 */
	@RequestMapping("/foreReg.do")
	public String foreReg() {
		return "Fore/foreReg";
	}

	/**
	 * 	前端登录 判断成功与否
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/foreLoginSubmit.do")
	public void foreLoginSubmit(HttpServletRequest request, HttpServletResponse response, Cust cust)
			throws IOException {
		System.out.println("手机号=====" + cust.getCust_phone());
		System.out.println("密码=====" + cust.getCust_pwd());
		cust.setCust_pwd(getStrrMD5(cust.getCust_pwd()));;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		System.out.println("path===" + path);
		Cust loginCust=custBiz.ForeLogin(cust) ;
		if (loginCust != null) {

			// 登录成功的用户 保存到session里
//			request.getSession().setAttribute("ForeUser", loginCust);
			RedisSession session = baseUtil.getSession(response, request);

			session.setAttribute("ForeUser", loginCust);

			out.println("<script type='text/javascript'>alert('登录成功'); location.href='" + path
					+ "fore/success1.do';</script>");
		} else {
			out.println("<script type='text/javascript'>alert('账号或密码错误！'); location.href='" + path
					+ "fore/foreLogin.do';</script>");
		}
		out.close();

		return;
	}

	/**
	 * 前端注册 判断成功与否
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/foreRegSubmit.do")
	public String foreRegSubmit(HttpServletRequest request, HttpServletResponse response, Cust cust)
			throws IOException {
		String url = "";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		System.out.println("path===" + path);

		System.out.println("电话=====" + cust.getCust_phone());
		System.out.println("密码=====" + cust.getCust_pwd());
		System.out.println("性别=====" + cust.getCust_sex());
		System.out.println("年龄=====" + cust.getCust_age());
		System.out.println("用户名=====" + cust.getCust_acc());
		// 先判断手机号是否重复
		List <Cust> FindByPhoneXList=custBiz.FindByPhoneX(cust.getCust_phone());
		List <Cust> FindByAccList=custBiz.FindByAcc(cust.getCust_acc());

		if (FindByPhoneXList!= null
				&&FindByPhoneXList.size() > 0) {
			out.println("<script type='text/javascript'>alert('注册失败，该手机号已经被注册');location.href='" + path
					+ "fore/foreReg.do';</script>");
//			url="Fore/foreReg";
		}
		// 再判断用户名是否重复
		else if (FindByAccList!= null && FindByAccList.size() > 0) {
			out.println("<script type='text/javascript'>alert('注册失败，该用户名已经被注册');location.href='" + path
					+ "fore/foreReg.do';</script>");
//			url="Fore/foreReg";
		}
		// 注册成功 添加消费者信息
		else {
			cust.setCust_pwd(getStrrMD5(cust.getCust_pwd()));;
			custBiz.AddCustX(cust);
			out.println("<script type='text/javascript'>alert('注册成功，即将跳转登录界面');location.href='" + path
					+ "fore/foreLogin.do';</script>");

		}
		//
		out.close();
		return url;
	}

	/**
	 * 退出用户
	 */
	@RequestMapping("/foreExit.do")
	public String foreExit(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		
//		jedisClient.del("CUST_SESSION:"+token);
		RedisSession session = baseUtil.getSession(response, request);
		session.removeSession("ForeUser");
		
		return "Fore/foreLogin";
	}

	
	
	//md5
	public static String getStrrMD5(String password) {
		 
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte strTemp[] = password.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte md[] = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}
 
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

}
