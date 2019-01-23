package org.great.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Cust;

import org.great.biz.CustCarBiz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 白名单管理
 * 
 * @author 健哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/writeList")
public class WriteListHandler {
	
	@Resource
	private CustCarBiz custCarBiz;
	
	/**
	 * 跳转 到白名单管理列表界面
	 * 
	 * @return
	 */
	@RequestMapping("/writeList.action")
	public String writeListQuery(HttpServletRequest request) {
		
		//获得白名单列表
				List<Cust> writeList = custCarBiz.findWriteList();
				HttpSession session = request.getSession();				
				session.setAttribute("writeList", writeList);	
				System.out.println("writeList="+writeList);
		
		
		return "writeList";
	}
	@RequestMapping("/cancleVip.action")	
	public String cancleVip(HttpServletRequest request) {
		
		String carId = request.getParameter("c_id");
		int carIdint = Integer.valueOf(carId);
		
		boolean a  = custCarBiz.cancleVip(carIdint);
		System.out.println("修改车辆白名单参数a= "+a );

	
//		获得白名单列表
		List<Cust> writeList = custCarBiz.findWriteList();
		HttpSession session = request.getSession();				
		session.setAttribute("writeList", writeList);	
		System.out.println("writeList="+writeList);
		
		
		return "writeList";
	}
	@RequestMapping("/jumpAdd.action")
	public String jumpAdd() {
		return "writeListAdd";
	}

}
