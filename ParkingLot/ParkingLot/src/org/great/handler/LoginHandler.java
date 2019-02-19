package org.great.handler;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.User;
import org.great.biz.MenuBiz;
import org.great.biz.UserBiz;
import org.great.util.BaseUtil;
import org.great.util.CaptchaUtil;
import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.great.util.RedisSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * 人员登录
 * 
 * @author 孔祥晶
 *
 */
@Controller
@RequestMapping("/login")
public class LoginHandler {

	@Resource
	public UserBiz userBiz;
	@Resource
	private MenuBiz menuBiz;
	
	@Resource
	BaseUtil baseUtil;

	String result = "usererror";

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping("/login.action")
	public String login() {

		System.out.println("跳转到登录页面--------");
		return "login";
	}

	/**
	 * 跳转到欢迎首页
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
	public String LoginAjax(HttpServletResponse response, HttpServletRequest request, @RequestBody User user) {

		System.out.println("账号=" + user.getU_name() + "密码=" + user.getU_pwd() + "验证码=" + user.getCode());
//		HttpSession session = request.getSession();

		// 判断验证码
//		String code1 = (String) session.getAttribute("Code");
		String code1 = CookieUtils.getCookieValue(request, "Code");
		if (!code1.equalsIgnoreCase(user.getCode())) {
			result = "codeerror";
			System.out.println("验证码错误");
			return result;
		}

		// 转换MD5密码
		user.setU_pwd(BaseUtil.getStrrMD5(user.getU_pwd()));
		User users = (User) userBiz.findUserByName(user);
		System.out.println("找到的用户=" + users);

		// 如果用户不存在，登录失败
		if (users == null) {
			result = "usererror";
			System.out.println("用户名错误");
			return result;
		}

		RedisSession session = baseUtil.getSession(response, request);

		session.setAttribute("User", users);
		session.setAttribute("loginuser", users);
//		session.setAttribute("User", users);
		result = "success";
		System.out.println("验证成功");

//		// 生成token
//		String token = UUID.randomUUID().toString();
//		users.setU_pwd(null);//清空密码
//		JSONObject json = JSONObject.fromObject(users);
//						
//		// 把用户信息保存到redis，key=token;value=user
//		jedisClient.set("USER_SESSION:"+token,json.toString());
//		
//		// 设置key过期时间
//		jedisClient.expire("USER_SESSION:"+token, 1800);
//		
//		// 返回登录成功，token写入到cookie
//		CookieUtils.setCookie(request, response, "PL_TOKEN", token);

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

	@RequestMapping("/head.action")
	public String tohead() {

		System.out.println("跳转到头像页面--------");
		return "Fore/user-updatePWD";
	}

	@RequestMapping("addPicture.action")
	public ModelAndView addPicture(MultipartFile pic) throws IllegalStateException, IOException {
		System.out.println("*---------addPicture");
		if (!pic.isEmpty()) {
			String path = "F:\\项目实战\\image\\";
			String originalFileName = pic.getOriginalFilename();
			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
			// 新的图片
			File newFile = new File(path + newFileName);
			// 将内存中的数据写入磁盘
			pic.transferTo(newFile);
		}
		return null;
	}
}
