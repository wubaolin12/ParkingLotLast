package org.great.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseController {

	/**
	 * 获取session
	 */
	public static RedisSession getSession(HttpServletResponse response, HttpServletRequest request) {

		/**
		 * token如果是空的,就创建一个token,设置到cookie
		 */
		String token = CookieUtils.getCookieValue(request, "PL_TOKEN");
		if(token==null) {
			token = UUID.randomUUID().toString();
			CookieUtils.setCookie(request, response, "PL_TOKEN", token);
		}
		
		//生成一个session

		return null;
	}
}
