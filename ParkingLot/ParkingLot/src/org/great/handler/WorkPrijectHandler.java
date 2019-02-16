package org.great.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Car;
import org.great.bean.Combo;
import org.great.bean.Cust;
import org.great.bean.Menu;
import org.great.bean.Sche;
import org.great.bean.User;
import org.great.bean.vo.AnyX;
import org.great.biz.BaseBiz;
import org.great.biz.ScheBiz;
import org.great.biz.UserBiz;
import org.great.util.BaseUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;



@Controller
@Scope("prototype")
@RequestMapping("/workPrijectHandler")
public class WorkPrijectHandler {

	@Resource
	private UserBiz userBiz;
	@Resource
	private ScheBiz scheBiz;
	@Resource
	private BaseBiz bbiz;
	
	private String result;
	
	@Value("tb_sche")
	private String tb_name;

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
		mav.setViewName("system/Work-main");
		
		List<Sche> ScheList = new ArrayList<>();
		JSONArray jlist=JSONArray.fromObject(ScheList);

		request.setAttribute("Jlist", jlist);
		
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
		System.out.println("---------getUserID=" + getUserID);
		System.out.println("+++---------getUserID=" + request.getParameter("getUserID"));
		String sid = getUserID.split("~")[0];
		int id = Integer.parseInt(sid);
		List<Sche> ScheList = scheBiz.getScheByUserID(id);
		System.out.println("ScheList=" + ScheList);
		request.setAttribute("ScheList", ScheList);
		request.setAttribute("GETUSERID", getUserID);
		List<User> UserList = userBiz.getUserListAllX();
		System.out.println("UserList=" + UserList);
		request.setAttribute("UserList", UserList);
		ModelAndView mav = new ModelAndView();
		
		JSONArray jlist=JSONArray.fromObject(ScheList);

		request.setAttribute("Jlist", jlist);
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

	
	/**
	 * 增加排班
	 * @param response
	 * @param request
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/AddWorkTestAjax.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String WorkTestAjax(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("---------AddWorkTestAjax"+map.toString());
		
		
		int num=bbiz.insertData(tb_name, map, null);
		
		result="sss";
	
		return result;

		
	}
	
	/**
	 * 修改排班
	 * @param response
	 * @param request
	 * @param map
	 * @param sche
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateWorkAjax.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String updateWorkAjax(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,String> map,Sche sche) 
	{
		System.out.println("---------updateWorkAjax"+map.toString());
		
		Sche csche=scheBiz.checkWork(sche);
		System.out.println("++++++------updateWorkAjax"+csche);
		int num=bbiz.updateData(tb_name, map, "s_id",""+ csche.getS_id());
		
		result="sss";
	
		return result;

		
	}
	
	/**
	 * 检察排班是否存在
	 * @param response
	 * @param request
	 * @param map
	 * @param sche
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/CheckWorkAjax.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String CheckWorkAjax(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,String> map,Sche sche) 
	{
		System.out.println("---------CheckWorkAjax"+sche.toString());
		
		Sche csche=scheBiz.checkWork(sche);
		
		if(csche!=null) {
			
			result="该日期已有排班";
			System.out.println("---------CheckWorkAjax该日期已有排班");
		}else {
			int num=bbiz.insertData(tb_name, map, null);
			result="添加排班成功";
			
		}
		
	
		return result;

		
	}
}
