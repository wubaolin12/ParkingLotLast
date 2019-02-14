package org.great.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Cust;
import org.great.bean.User;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * 前台登录拦截
 * @author Administrator
 *
 */
public class ForeInterceptor implements HandlerInterceptor{

	@Resource
	JedisClient jedisClient;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 登录拦截功能实现
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 判断当前访问路径是否是登录，是放行，否则判断是否登录
		if (request.getRequestURI().contains("fore")) {
			return true;
		}

		// 判断是否是已经登录，登录放行，否则跳转到登录界面
		String token = CookieUtils.getCookieValue(request, "CUST_TOKEN");
		String json = jedisClient.get("CUST_SESSION:"+token);
		
		System.out.println("----车主端登录拦截-----token=="+token);
		System.out.println("----车主端登录拦截-----json=="+json);

		if (json != null && json.length()>0) {
			
			//重置过期时间
			jedisClient.expire("CUST_SESSION:"+token, 1800);
			
			JSONObject jsonObject = JSONObject.fromObject(json);
			Cust cust = (Cust) JSONObject.toBean(jsonObject,Cust.class);
			System.out.println(cust.toString());
			
			request.getSession().setAttribute("ForeUser", cust);
			
			return true;
		}

		// 转发到登录
		request.getRequestDispatcher("/WEB-INF/jsp/Fore/foreLogin.jsp").forward(request, response);
		return false;
	}
}
