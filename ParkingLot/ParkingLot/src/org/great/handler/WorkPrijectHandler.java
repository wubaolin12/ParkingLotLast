package org.great.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.Car;
import org.great.bean.Combo;
import org.great.bean.Sche;
import org.great.bean.User;
import org.great.bean.vo.AnyX;
import org.great.biz.ScheBiz;
import org.great.biz.UserBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("/workPrijectHandler")
public class WorkPrijectHandler {

	@Resource
	private UserBiz userBiz;
	@Resource
	private ScheBiz scheBiz;

	/**
	 * 跳到排班界面并且查询所有员工
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/WorkProjectJSP.action")
	public ModelAndView WorkProjectJSP(HttpServletRequest request) {
		List<User> UserList = userBiz.getUserListAllX();
		System.out.println("UserList=" + UserList);
		request.setAttribute("UserList", UserList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/WorkPriject");
		return mav;
	}

	/**
	 * 查询某一个员工的排班
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/FindWorkProject.action")
	public ModelAndView FindWorkProject(String getUserID, HttpServletRequest request) {
		System.out.println("getUserID=" + getUserID);
		String sid = getUserID.split("~")[0];
		int id = Integer.parseInt(sid);
		List<Sche> ScheList = scheBiz.getScheByUserID(id);
		System.out.println("ScheList=" + ScheList);
		request.setAttribute("ScheList", ScheList);
		request.setAttribute("GETUSERID", getUserID);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/WorkPriject");
		return mav;
	}

	/**
	 * 添加排班
	 * 
	 * @param anyX
	 * @return
	 */
	@RequestMapping(value="/SetWorkProject.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody List<Sche> SetWorkProject(@RequestBody AnyX anyX) {
		System.out.println("--------------------------------------");
		System.out.println("anyX=" + anyX);
		List<Sche> scheList = null;
		return scheList;
	}

}
