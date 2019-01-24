package org.great.handler;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Menu;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.great.biz.MenuBiz;
import org.great.biz.UserBiz;
import org.great.util.BaseUtil;
import org.great.util.CaptchaUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 人员登录
 * 
 * @author 孔祥晶
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginHandler {

	@Resource
	public UserBiz userBiz; 
	@Resource
	private MenuBiz menuBiz;
	String result = "usererror";
	
	/**
	 * 	跳转到登录页面
	 */
	@RequestMapping("/login.action")
	public String login() {

		return "login";
	}
	
	/**
	 * 	跳转到欢迎首页
	 */
	@RequestMapping("/welcome.action")
	private String welcome() {
		// TODO Auto-generated method stub
		return "WaitGame";
	}

	/**
	 * 登录验证
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginAjax.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String LoginAjax(HttpServletRequest request, @RequestBody User user) {

		System.out.println("账号=" + user.getU_name() + "密码=" + user.getU_pwd() + "验证码=" + user.getCode());
		HttpSession ss = request.getSession();

		// 转换MD5密码
		user.setU_pwd(BaseUtil.getStrrMD5(user.getU_pwd()));

		String code1 = (String) ss.getAttribute("Code");

		User users = (User) userBiz.findUserByName(user);

		System.out.println("找到的用户=" + users);

		// 判断验证码
		if (!user.getCode().equalsIgnoreCase(code1)) {

			result = "codeerror";
			System.out.println("验证码错误");

		} else {

			if (users != null) {
				
				//角色关系
				RoleRel re = userBiz.FindStaffRole(users.getU_id());

				List<Menu> menuList = menuBiz.findMenu(re.getRole_id());
				ss.setAttribute("menuList", menuList);
				
				ss.setAttribute("User", users);
				result = "success";
				System.out.println("验证成功");

//				UUID.randomUUID();
			} else {
				result = "usererror";
				System.out.println("用户名错误");
			}
		}

		return result;
	}

	/**
	 * 验证码传输
	 * 
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/rand.action", method = RequestMethod.GET)
	@ResponseBody
	public void captcha(HttpServletRequest request, HttpServletResponse response) {

		try {

			CaptchaUtil.outputCaptcha(request, response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
