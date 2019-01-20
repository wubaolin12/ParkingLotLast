package org.great.handler;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

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
		user.setU_pwd(getStrrMD5(user.getU_pwd()));

		String code1 = (String) ss.getAttribute("Code");

		User users = (User) userBiz.findUserByName(user);

		System.out.println("找到的用户=" + users);

		// 判断验证码
		if (!user.getCode().equalsIgnoreCase(code1)) {

			result = "codeerror";
			System.out.println("验证码错误");

		} else {

			if (users != null) {

				System.out.println("lalalala");
				RoleRel re = userBiz.FindStaffRole(users.getU_id());
//
//				List<Menu> MenuOnelist = userBiz.GetYOneMenu(re.getRole_id());
//
//				List<Menu> MenuTwolist = userBiz.GetYTwoMenu(re.getRole_id());
//
//				ss.setAttribute("MenuOnelist", MenuOnelist);
//				ss.setAttribute("MenuTwolist", MenuTwolist);

				List<Menu> menuList = menuBiz.findMenu(re.getRole_id());
				ss.setAttribute("menuList", menuList);
				
				
				ss.setAttribute("User", users);
				result = "success";
				System.out.println("验证成功");

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

	/**
	 * 	测试MD5
	 * @param 密码
	 * @return MD5
	 * 
	 */
	public static String getStrrMD5(String password) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte strTemp[] = password.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte md[] = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}

			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

}
