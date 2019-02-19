package org.great.handler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.util.BaseUtil;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 退出系统 孔大爷
 */
@Controller
@Scope("prototype")
@RequestMapping("/Exit")
public class ExitHandler {
//	@Resource
//	JedisClient jedisClient;

	@Resource
	BaseUtil baseUtil;

	@RequestMapping("exit.action")
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 获取服务器路径
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";

		// 清除当前用户相关的session对象
		request.getSession().invalidate();
		
		//清除redis
		RedisSession session = baseUtil.getSession(response, request);
		session.removeSession("User");

		// 重定向回登录界面
		response.sendRedirect(path + "login/login.action");

	}
}
