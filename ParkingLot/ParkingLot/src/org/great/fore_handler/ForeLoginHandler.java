package org.great.fore_handler;

import java.io.IOException;
import java.io.PrintWriter;
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
 * 前端客户端管理
 * 
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/fore")
public class ForeLoginHandler {

	//@Resource
//	public ParkBiz parkBiz; 
	
//	public List<Park>parkList;//所有的车位列表;
//	//public Park updatePark; //查询条件的车位;
//	String result = "usererror";
//	public List<Park>pForeList;//车位区号列表;
		
	
	/**
	 *  跳转前端界面1测试
	 */
	
	@RequestMapping("/success1.do")
	public String success1() {
		System.out.println("1111");
		return "Fore/foreMain";
	}
	/**
	 * 	跳转前端界面2测试
	 */
	
	@RequestMapping("/success2.action")
	public String success2() {
		System.out.println("2222");
		return "Fore/foreMain";
	}
	
}
