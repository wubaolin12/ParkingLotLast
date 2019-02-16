package org.great.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Car;
import org.great.bean.Cust;

import org.great.biz.CustCarBiz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/**
	 *  白名单修改
	 * 
	 * @return
	 */
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
	/**
	 *  跳转白名单添加界面
	 * 
	 * @return
	 */
	@RequestMapping("/jumpAdd.action")
	public String jumpAdd() {
		return "writeListAdd";
	}
	/**
	 *  白名单添加
	 * 
	 * @return
	 */
	@RequestMapping("/checkCarNum.action")
	public @ResponseBody String checkCarNum(String carNum) {
					
		System.err.println("啦啦啦啦啦啦啦啦dsfsdfdsfdsfsdfsdfsdffd............."+carNum);

		int a  = 1;

		
		Car car = custCarBiz.selectNum(carNum);
		
		
		if(car == null) {
			
			System.out.println("找不到这辆车。。。。。");
			
			a = 0;
			
		}else {
			
			System.out.println("找到这辆车了。。。。。。。");
			
			boolean boo = custCarBiz.addWriteCar(carNum);
			
			if(boo == true) {

			a = 1 ;
			}
						
		}	
		return ""+a;
	}
	
	
	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	@RequestMapping("/queryWriteList.action")
	public String queryWriteList(HttpServletRequest request,String query) {
		System.out.println("进入模糊查询方法啦");
		System.out.println("模糊查询输入的内容。。。。c_num="+query);
		
				List<Cust> writeList = custCarBiz.queryWriteList(query);
				
				HttpSession session = request.getSession();	
				
				session.setAttribute("writeList", writeList);	
				
				System.out.println("writeList="+writeList);
				
		return "writeList";
	}
	

}
