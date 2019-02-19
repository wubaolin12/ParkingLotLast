package org.great.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Cust;
import org.great.bean.User;
import org.great.util.BaseUtil;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.great.util.RedisSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * 前台登录拦截
 * @author Administrator
 *
 */
public class ForeInterceptor implements HandlerInterceptor{

//	@Resource
//	JedisClient jedisClient;
	
	@Resource
	BaseUtil baseUtil;

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
		//获取redissession，得到key对应 的值
		RedisSession session = baseUtil.getSession(response, request);
		Cust user = (Cust) session.getAttribute("ForeUser", Cust.class);
		if (user != null) {
			System.out.println("用户----" + user.toString());
			
			return true;
		}

		// 转发到登录
		request.getRequestDispatcher("/WEB-INF/jsp/Fore/foreLogin.jsp").forward(request, response);
		return false;
	}
}
