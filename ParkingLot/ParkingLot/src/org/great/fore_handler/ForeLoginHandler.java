package org.great.fore_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Cust;
import org.great.biz.CustBiz;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
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
	JedisClient jedisClient;//redis连接类

//	public List<Park>parkList;//所有的车位列表;
//	//public Park updatePark; //查询条件的车位;
//	String result = "usererror";
//	public List<Park>pForeList;//车位区号列表;

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
		System.out.println("用户=====" + cust.getCust_acc());
		System.out.println("密码=====" + cust.getCust_pwd());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		System.out.println("path===" + path);
		if (custBiz.ForeLogin(cust) != null && custBiz.ForeLogin(cust).size() == 1) {

			// 登录成功的用户 保存到session里
			request.getSession().setAttribute("ForeUser", custBiz.ForeLogin(cust).get(0));

			// 生成token
			String token = UUID.randomUUID().toString();
			cust.setCust_pwd(null);// 清空密码
			JSONObject json = JSONObject.fromObject(cust);

			// 把用户信息保存到redis，key=token;value=user
			jedisClient.set("CUST_SESSION:" + token, json.toString());

			// 设置key过期时间
			jedisClient.expire("CUST_SESSION:" + token, 1800);

			// 返回登录成功，token写入到cookie
			CookieUtils.setCookie(request, response, "CUST_TOKEN", token);

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
		if (custBiz.FindByPhoneX(cust.getCust_phone()) != null
				&& custBiz.FindByPhoneX(cust.getCust_phone()).size() > 0) {
			out.println("<script type='text/javascript'>alert('注册失败，该手机号已经被注册');location.href='" + path
					+ "fore/foreReg.do';</script>");
//			url="Fore/foreReg";
		}
		// 再判断用户名是否重复
		else if (custBiz.FindByAcc(cust.getCust_acc()) != null && custBiz.FindByAcc(cust.getCust_acc()).size() > 0) {
			out.println("<script type='text/javascript'>alert('注册失败，该用户名已经被注册');location.href='" + path
					+ "fore/foreReg.do';</script>");
//			url="Fore/foreReg";
		}
		// 注册成功 添加消费者信息
		else {
			custBiz.AddCustX(cust);
			out.println("<script type='text/javascript'>alert('注册成功，即将跳转登录界面');location.href='" + path
					+ "fore/foreLogin.do';</script>");

//			url="Fore/foreLogin";
		}
		//
		out.close();
		return url;
	}

	/**
	 * 退出用户
	 */
	@RequestMapping("/foreExit.do")
	public String foreExit(HttpServletRequest request) {
		request.getSession().invalidate();
		
		//清除redis
		String token = CookieUtils.getCookieValue(request, "CUST_TOKEN");
		jedisClient.del("CUST_SESSION:"+token);
		return "Fore/foreLogin";
	}

}
