package org.great.handler;

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
 * 车位管理
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
	public List<Park>pForeList;//车位区号列表;
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
			parkList=parkBiz.FindAll(updatePark);
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
	
	

	
	/**
	 * 	无查询条件的所有列表
	 */
	
	@RequestMapping("/parkList.action")
	public String ParkList(HttpServletRequest request) {
		Park p=new Park(0, null, 0, null,null);
		parkList=parkBiz.FindAll(p);
		System.out.println("长度"+parkList.size());
		request.setAttribute("parkList", parkList);
		pForeList=parkBiz.FindGroup();
		System.out.println("区号长度"+pForeList.size());
		request.getSession().setAttribute("pForeList", pForeList);
		
		return "ParkManage";
	}
	/**
	 * 	跳转增加车位界面
	 */
	
	@RequestMapping("/jumpAdd.action")
	public String jumpAdd() {
		return "ParkAdd";
	}
	/**
	 * 	增加车位
	 * @throws IOException 
	 */
	
	@RequestMapping("/addPark.action")
	public String addPark(HttpServletRequest request,HttpServletResponse response,Park addPark) throws IOException {
		System.out.println("添加的车位是"+addPark);
		String url="";
		addPark.setPm_id(9);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path=request.getScheme()+"://"+request.getServerName()+":"+
				request.getServerPort()+request.getContextPath()+"/";
		System.out.println("path==="+path);
		
		if(parkBiz.FindForeAndNum(addPark)!=null&&parkBiz.FindForeAndNum(addPark).size()>0) {
		System.out.println("111");
		// location.href='park/jumpAdd.action';
		out.println("<script type='text/javascript'>alert('增加失败，该车位号已经存在数据库车位表里'); location.href='"+path+"park/jumpAdd.action';</script>");
		url="ParkAdd";
		}else {
			if(parkBiz.FindMapID(addPark.getP_mapid())!=null&&parkBiz.FindMapID(addPark.getP_mapid()).size()>0){
				System.out.println("222");
				out.println("<script type='text/javascript'>alert('增加失败，该地图id已经存在数据库车位表里'); location.href='"+path+"park/jumpAdd.action';</script>");
				url="ParkAdd";
			}else {
				System.out.println("333");
				parkBiz.AddPark(addPark);
				out.println("<script type='text/javascript'>alert('增加成功'); location.href='"+path+"park/parkList.action';</script>");
				url="ParkManage";
			}
		}
		
		out.close();
		return url;
	}
	/**
	 * 	跳转修改车位界面
	 */
	
	@RequestMapping("/jumpUpdate.action")
	public String jumpUpdate(HttpServletRequest request,String p_id) {
		if(p_id!=null) {
		System.out.println("pid="+p_id);
		Park p =parkBiz.FindByID(p_id);
		System.out.println("p="+p);
		request.getSession().setAttribute("updatePark", p);
		}
		return "ParkUpdate";
	}
	
	/**
	 * 	修改车位
	 * @throws IOException 
	 */
	
	@RequestMapping("/updatePark.action")
	public String updatePark(HttpServletRequest request,HttpServletResponse response,Park addPark) throws IOException {
		System.out.println("添加的车位是"+addPark);
		String url="";
		addPark.setPm_id(9);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path=request.getScheme()+"://"+request.getServerName()+":"+
				request.getServerPort()+request.getContextPath()+"/";
		if(parkBiz.FindForeAndNum(addPark)!=null&&parkBiz.FindForeAndNum(addPark).size()>0) {
		System.out.println("111");
		out.println("<script type='text/javascript'>alert('修改失败，该车位号已经存在数据库车位表里'); location.href='"+path+"park/jumpUpdate.action';</script>");
		url="ParkUpdate";
		}else {
			if(parkBiz.FindMapID(addPark.getP_mapid())!=null&&parkBiz.FindMapID(addPark.getP_mapid()).size()>0){
				System.out.println("222");
				out.println("<script type='text/javascript'>alert('修改失败，该地图id已经存在数据库车位表里'); location.href='"+path+"park/jumpUpdate.action';</script>");
				url="ParkUpdate";
			}else {
				System.out.println("333");
				parkBiz.UpdatePark(addPark);
				out.println("<script type='text/javascript'>alert('修改成功'); location.href='"+path+"park/parkList.action';</script>");
				url="ParkManage";
			}
		}
		
		out.close();
		return url;
	}
	
}
