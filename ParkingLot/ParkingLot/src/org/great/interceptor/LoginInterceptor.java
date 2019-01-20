package org.great.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 	登录拦截
 * @author 吴宝林
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * 	登录拦截功能实现
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断当前访问路径是否是登录，是放行，否则判断是否登录
		
		if(request.getRequestURI().contains("login")) {
			return true;
		}
		
		//判断是否是已经登录，登录放行，否则跳转到登录界面
		HttpSession session = request.getSession();
		if(session.getAttribute("User") !=null) {
			return true;
		}
		
		//转发到登录
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
	
}
