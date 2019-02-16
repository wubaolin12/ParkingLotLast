package org.great.fore_handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Park;
import org.great.biz.ParkBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Scope("prototype")
@RequestMapping("/Face")
public class Face {

	@Resource
	public ParkBiz parkBiz; 
	/**
	 *  登录成功跳转到人脸识别
	 *  孔大帅
	 */
	
	@RequestMapping("/face.do")
	public String JumpFace() {
		
		return "Fore/FaceRegiest";
	}
	
	@RequestMapping("/forefacelogin.do")
	public String JumpFaceLogin() {
		
		return "Fore/FaceLogin";
	}
	@ResponseBody
	@RequestMapping(value="/foremap.do",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Map JumpForeMap() {
		
		//获得已停车的车位ID
		
		List<Park> parklist = parkBiz.FindAllList();
		
		Map map  = new HashMap();
		
		map.put("put", parklist);
		 
		// System.out.println("所有车位信息"+map);
		
		return map;
	}
	
}
