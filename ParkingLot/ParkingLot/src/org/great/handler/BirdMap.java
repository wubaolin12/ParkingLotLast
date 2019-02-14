package org.great.handler;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.great.bean.Park;
import org.great.biz.ParkBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 鸟瞰图 孔大爷
 */
@Controller
@Scope("prototype")
@RequestMapping("/BirdMap")
public class BirdMap {
	
	@Resource
	public ParkBiz parkBiz; 

	@RequestMapping("/birdmap.action")
	public String JumpBirdMap(HttpServletRequest request) {
		
		//获得已停车的车位ID
		
		 List<Park> parklist = parkBiz.FindAllCanStopX("开放", 9);
		 
		 System.out.println("所有车位信息"+parklist);
		 
		 request.setAttribute("ParkList",parklist);
		
		return "BirdMap";
	}
}
