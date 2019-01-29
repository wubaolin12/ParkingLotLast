package org.great.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.great.bean.Menu;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 访问地址不存在时，跳转到这个页面
 * @author 吴宝林
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/web")
public class WebHandler {
	
	/**
	 * 	跳转404页面
	 */
	@RequestMapping("/404.action")
	public String errorJsp(HttpServletRequest request) {
		
		return "error";
	}

	/**
	 * 	跳转欢迎页面
	 */
	@RequestMapping("/welcome.action")
	public String welcomeJsp(HttpServletRequest request) {
		
		return "welcome";
	}
}
