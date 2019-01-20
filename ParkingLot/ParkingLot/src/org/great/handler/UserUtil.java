package org.great.handler;

import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.User;
import org.great.biz.BaseBiz;
import org.great.biz.RoleBiz;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 人员管理
 * 
 * @author yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/emp")
public class UserUtil {

	@Resource
	private BaseBiz bbiz;
	@Resource
	private UserBiz ubiz;
	@Resource
	private RoleBiz rbiz;
	
	@Value("tb_user")
	private String tb_name;
	@Value("error")
	private String result;
	/**
	 * 跳转增加用户页面方法
	 * @return 
	 */
	@RequestMapping("/addEmpPage.action")
	public String empPage() {
		System.out.println("----UserUtil：跳转增加用户页面方法");
		return "adduser";
	}
	/**
	 * 增加用户方法
	 * @param request
	 * @param resp
	 * @param user
	 * @param map
	 * @return 增加成功跳转到赋予角色界面
	 */
	@RequestMapping("/addemp.action")
	public String addemp(HttpServletRequest request, HttpServletResponse resp,User user,@RequestParam Map<String,String> map) {
		System.out.println("----UserUtil：增加用户方法"+user.getU_name());
		int num=1;
		
		String pwd=getStrrMD5(map.get("u_pwd"));
		map.put("u_pwd", pwd);
		num=bbiz.insertObject(tb_name, map);
		user=ubiz.getUser(user);
		System.out.println("----USER"+user.toString());
		HttpSession session = request.getSession();
		session.setAttribute("newuser", user);
		if(num>0) {
			result="giverole";
			List rlist=rbiz.getPRole(user.getU_id());
			session.setAttribute("prlist", rlist);
		}
		
		return result;
	}
	/**
	 * 赋予用户角色
	 * @param request
	 * @param resp
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/giverole.action")
	public String giveRole(HttpServletRequest request, HttpServletResponse resp,User user,@RequestParam Map<String,String> map) {
		System.out.println("----UserUtil：赋予角色"+map.get("role_id"));

		int num=bbiz.insertObject("staff_rel", map);
		if(num>0) {
			result="success";
		}
		return result;
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
