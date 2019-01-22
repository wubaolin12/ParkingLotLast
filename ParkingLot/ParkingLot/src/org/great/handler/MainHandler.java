package org.great.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	后台管理端主界面跳转
 * @author 吴宝林
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
