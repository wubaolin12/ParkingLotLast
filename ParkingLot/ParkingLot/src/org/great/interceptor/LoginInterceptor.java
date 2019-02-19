package org.great.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.User;
import org.great.util.BaseUtil;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.great.util.RedisSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * 登录拦截
 * 
 * @author 吴宝林
 *
 */

public class LoginInterceptor implements HandlerInterceptor {

//	@Resource
//	JedisClient jedisClient;
	
	@Resource
	BaseUtil baseUtil;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 登录拦截功能实现
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断当前访问路径是否是登录，是放行，否则判断是否登录
		System.out.println("后台管理登录拦截-------------");

		if (request.getRequestURI().contains("login")) {
			return true;
		}
		
		//获取redissession，得到key对应 的值
		RedisSession session = baseUtil.getSession(response, request);
		User user = (User) session.getAttribute("User", User.class);
		if (user != null) {
			System.out.println("用户----" + user.toString());
			
			return true;
		}
//		// 判断是否是已经登录，登录放行，否则跳转到登录界面；token相当于一个sessionID
//		String token = CookieUtils.getCookieValue(request, "PL_TOKEN");
//		String json = jedisClient.get("USER_SESSION:"+token);
//		
//		System.out.println("----登录拦截-----token=="+token);
//		System.out.println("----登录拦截-----json=="+json);
//
//		if (json != null && json.length()>0) {
//			
//			//重置过期时间
//			jedisClient.expire("USER_SESSION:"+token, 1800);
//			
//			JSONObject jsonObject = JSONObject.fromObject(json);
//			User user = (User) JSONObject.toBean(jsonObject,User.class);
//			System.out.println(user.toString());
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("User", user);
////			request.setAttribute("User", user);
//			
//			return true;
//		}

		// 转发到登录
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
