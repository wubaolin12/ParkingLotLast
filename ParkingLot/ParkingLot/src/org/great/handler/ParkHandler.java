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
import org.great.bean.Park;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.great.biz.MenuBiz;
import org.great.biz.ParkBiz;
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
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/park")
public class ParkHandler {

	@Resource
	public ParkBiz parkBiz; 
	
	public List<Park>parkList;//所有的车位列表;
	//public Park updatePark; //查询条件的车位;
	String result = "usererror";
	
	/**
	 * 	无查询条件的所有列表
	 */
	
	@RequestMapping("/parkList.action")
	public String ParkList(HttpServletRequest request) {
		Park p=new Park(0, null, 0, null,null);
		parkList=parkBiz.FindAll(p);
		System.out.println("长度"+parkList.size());
		request.setAttribute("parkList", parkList);
		return "ParkManage";
	}

	/**
	 * 有条件的查询
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	//@RequestMapping()(value = "/findPark.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@RequestMapping("/findPark.action")
	public String findPark(HttpServletRequest request, Park updatePark) {
		System.out.println("__有条件____");
		System.out.println(updatePark);
		if(updatePark.getP_state().equals("所有")) {
			updatePark.setP_state(null);
		}
		if(updatePark.getP_fore().equals("所有")) {
			updatePark.setP_fore(null);
		}
		if(updatePark.getC_num().equals("")) {
			parkList=parkBiz.FindAll(updatePark);

		}else {
		
		parkList=parkBiz.FindList(updatePark);
		}
		request.setAttribute("parkList", parkList);
		return "ParkManage";
	}
	
	/**
	 * 更改维护 开放状态
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	//@RequestMapping()(value = "/findPark.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@RequestMapping("/setState.action")
	public String setState(HttpServletRequest request, int p_id,String want) {
		//修改状态
		System.out.println("__有条件____");
		System.out.println("pid="+p_id);
		System.out.println("want="+want);
		Park p=new Park(p_id, want);
		boolean k=parkBiz.setState(p);
		System.out.println("修改维护状态="+k);
		//查询所有列表
		p=new Park(0, null, 0, null,null);
		parkList=parkBiz.FindAll(p);
		System.out.println("长度"+parkList.size());
		request.setAttribute("parkList", parkList);
		
		return "ParkManage";
	}
	
	
	
//
//	/**
//	 * 验证码传输
//	 * 
//	 * @param request
//	 * @param response
//	 */
//
//	@RequestMapping(value = "/rand.action", method = RequestMethod.GET)
//	@ResponseBody
//	public void captcha(HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//
//			CaptchaUtil.outputCaptcha(request, response);
//
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 	测试MD5
//	 * @param 密码
//	 * @return MD5
//	 * 
//	 */
//	public static String getStrrMD5(String password) {
//
//		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
//		try {
//			byte strTemp[] = password.getBytes("UTF-8");
//			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
//			mdTemp.update(strTemp);
//			byte md[] = mdTemp.digest();
//			int j = md.length;
//			char str[] = new char[j * 2];
//			int k = 0;
//			for (int i = 0; i < j; i++) {
//				byte byte0 = md[i];
//				str[k++] = hexDigits[byte0 >>> 4 & 15];
//				str[k++] = hexDigits[byte0 & 15];
//			}
//
//			return new String(str);
//		} catch (Exception e) {
//			return null;
//		}
//	}

}
