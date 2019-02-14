package org.great.fore_handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Cust;
import org.great.bean.Menu;
import org.great.bean.User;
import org.great.biz.BaseBiz;
import org.great.biz.CustBiz;
import org.great.util.BaseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前端个人信息显示
 * @author ASUS yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/userinformation")
public class UserInformationHandler {
	
	@Resource
	private BaseBiz bbiz;
	
	@Resource
	public CustBiz cbiz;  
	
	@Value("tb_cust")
	private String tb_name;
	
	private String result;
	/**
	 * 跳转显示用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUserInformation.do")
	public String toUserInformation(HttpServletRequest request) 
	{
/*		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		request.setAttribute("FuserInf", cust);*/
		result="Fore/user-information";
		return result;
		
	}
	
	/**
	 * 跳转修改用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpdateUserInformation.do")
	public String toUpdateUserInformation(HttpServletRequest request) 
	{
		System.out.println("--------toUpdateUserInformation");
/*		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		request.setAttribute("FuserInf", cust);*/
		result="Fore/user-update";
		return result;
		
	}
	
	/**
	 * 跳转修改用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpdateUserPWD.do")
	public String toUpdateUserPWD(HttpServletRequest request) 
	{
		System.out.println("------------toUpdateUserPWD");
/*		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		request.setAttribute("FuserInf", cust);*/
		result="Fore/user-updatePWD";
		return result;
		
	}
	
	/**
	 * 修改用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpdateUserInformation.do")
	public String tUpdateUserInformation(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("--------UpdateUserInformation");
		System.out.println("--------MAp"+map.toString());

		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		if(cust!=null){
			int num=bbiz.updateData(tb_name, map, "cust_id",""+ cust.getCust_id());

			if(num>0) {
				result="Fore/user-update";

			}
		}else {
			System.out.println("用户过期");
		}
		
		
		
		return result;
		
	}
	
	/**
	 * 验证旧密码
	 * @param response
	 * @param request
	 * @return
	 * @author ASUS yf
	 */
	@ResponseBody
	@RequestMapping(value = "/FuserPWDcheckAjax.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String FuserPWDcheckAjax(HttpServletResponse response,HttpServletRequest request) 
	{
		String oldpwd=request.getParameter("checkpwd");
		System.out.println("--------FuserPWDcheckAjax："+oldpwd);
		
		HttpSession session = request.getSession();
		Cust cust=(Cust)session.getAttribute("ForeUser");
		if(cust!=null) {
			System.out.println("++++---------cust"+cust.toString());
			// 转换MD5密码
			Cust user=new Cust();
			//user.setCust_pwd(BaseUtil.getStrrMD5(oldpwd));
			user.setCust_pwd(oldpwd);
	
			user.setCust_phone(cust.getCust_phone());
			Cust users = (Cust) cbiz.checkUser(user);
			System.out.println("找到的用户=" + users);
	
			//如果用户不存在输入的旧密码不正确
			if (users == null) {
				result = "usererror";
				System.out.println("用户名错误");
			}else {
				result ="旧密码正确";
			}
		
		}
		return result;
		
	}
	
}
