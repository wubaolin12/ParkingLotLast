package org.great.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Menu;
import org.great.bean.User;
import org.great.biz.MenuBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	后台管理端主界面跳转
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/main")
public class MainHandler {

	
	/**
	 * 	跳转到管理端首页
	 */
	@RequestMapping("/main.action")
	public String mainJsp(HttpServletRequest request) {
		
		
		return "main";
	}
}
