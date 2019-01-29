package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.PageElement;
import org.great.bean.User;
import org.great.biz.BaseBiz;
import org.great.biz.RoleBiz;
import org.great.biz.UserBiz;
import org.great.util.BaseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 人员管理
 * 
 * @author yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/emp")
public class UserHandler extends BaseUtil{

	@Resource
	private BaseBiz bbiz;
	@Resource
	private UserBiz ubiz;
	@Resource
	private RoleBiz rbiz;
	
	@Value("tb_user")
	private String tb_name;
	@Value("error")
	private String result;
	
	private int startNum;
	
	/**
	 * 用户启用
	 */
	@RequestMapping(value="/userOn.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public String userOn(HttpServletRequest request){	
		int id=Integer.valueOf(request.getParameter("u_id"));
		System.out.println("----进行用户启用..."+id);
		Map map=new HashMap<>();
		map.put("pm_id", 3);
		int num=bbiz.updateObject(tb_name, map, "u_id", id);
		if(num>0) {
			System.out.println("-----启用成功");
		}
		return "success";
	}
	/**
	 * 用户禁用
	 * @param user
	 */
	@RequestMapping(value="/userOff.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public String userOff(HttpServletRequest request){	
		int id=Integer.valueOf(request.getParameter("u_id"));
		System.out.println("----进行用户禁用..."+id);
		Map map=new HashMap<>();
		map.put("pm_id", 4);
		int num=bbiz.updateObject(tb_name, map, "u_id", id);
		if(num>0) {
			System.out.println("-----禁用成功");
		}
		return  "success";
	}
	
	

	
	/**
	 * 跳转修改用户页面方法
	 * @return 
	 */
	@RequestMapping("/toUpadatePage.action")
	public String toUpadatePage(HttpServletRequest request,User user) {
		System.out.println("----UserUtil：跳转修改用户页面方法");
		currentpage=Integer.valueOf(request.getParameter("currentpage"));
		HttpSession session = request.getSession();
		
		System.out.println("-----UserUtil：update user="+user.toString());
		user=ubiz.getUser(user);
		session.setAttribute("currentpage", currentpage);
		
		session.setAttribute("updateuser", user);
		return "updateuser";
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param resp
	 * @param map
	 * @return
	 */
	@RequestMapping("/updateUser.action")
	public String updateUser(HttpServletRequest request, HttpServletResponse resp,@RequestParam Map<String,String> map,User user) {
		System.out.println("----------UserUtil：修改用户信息");
		//int id=Integer.valueOf(request.getParameter("u_id"));
		HttpSession session = request.getSession();
		user=(User)session.getAttribute("updateuser");
		System.out.println("----------UserUtil:update "+user.toString());
		
		currentpage=Integer.valueOf((Integer) session.getAttribute("currentpage"));
		System.out.println("----------UserUtil:currentpage "+currentpage);

		Map usmap=(Map)session.getAttribute("userseachmap");
		String pwd=getStrrMD5(map.get("u_pwd"));
		map.put("u_pwd", pwd);
		int num=bbiz.updateObject(tb_name, map, "u_id", user.getU_id());
		if(num>0) {
			
			startNum    =currentpage*rownum-rownum;		
			String listSql=bbiz.creatSQL(tb_name, usmap);		
			List ulist    =ubiz.findList(listSql, startNum, rownum);
			
			
			cordnum  =bbiz.getCordnum(listSql);
			totalpage=getPage(cordnum, rownum);
			session.setAttribute("ulist", ulist);
			PageElement pe=new PageElement(currentpage, totalpage, cordnum);
			session.setAttribute("pageel", pe);
			
			
			
			result="user-list";
		}
		return result;
	}
	
	/**
	 * 重置密码
	 * @param request
	 * @param resp
	 * @param map
	 * @param user
	 * @return
	 */
	@RequestMapping("/resetPwd.action")
	public String resetPwd(HttpServletRequest request) {
		System.out.println("----------UserUtil：重置密码");
		//int id=Integer.valueOf(request.getParameter("u_id"));

		int u_id=Integer.valueOf(request.getParameter("u_id"));
		System.out.println("----------UserUtil:resetPwd "+u_id);
		
		//currentpage=Integer.valueOf((Integer) session.getAttribute("currentpage"));

		//Map usmap=(Map)session.getAttribute("userseachmap");
		
		Map map=new HashMap<>();
		String pwd=getStrrMD5("123456");
		map.put("u_pwd", pwd);
		int num=bbiz.updateObject(tb_name, map, "u_id", u_id);
		if(num>0) {
			
			
			
			result="success";
		}
		return result;
	}

	
	
	
	
	/**
	 * 查询用户
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/seachUser.action")
	public String seachUser(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("----------UserUtil：查询用户");
	
		String searchword=request.getParameter("searchword");
		HttpSession session = request.getSession();
		Map usmap=new HashMap<>();
		usmap.put("u_id", searchword);
		usmap.put("u_name", searchword);
		usmap.put("u_phone", searchword);
			
			startNum    =currentpage*rownum-rownum;		
			String listSql=bbiz.creatSQL(tb_name, usmap);		
			List ulist    =ubiz.findList(listSql, startNum, rownum);
			
			
			cordnum  =bbiz.getCordnum(listSql);
			totalpage=getPage(cordnum, rownum);
			session.setAttribute("ulist", ulist);
			PageElement pe=new PageElement(currentpage, totalpage, cordnum);
			session.setAttribute("pageel", pe);
			result="user-list";
		
		return result;
	}
	/**
	 * 删除用户
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/delUser.action")
	public String delUser(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("----------UserUtil：删除用户");
		//currentpage=Integer.valueOf(request.getParameter("currentpage"));
		int id=Integer.valueOf(request.getParameter("u_id"));
		HttpSession session = request.getSession();
		Map usmap=(Map)session.getAttribute("userseachmap");

		int num2=bbiz.delObject("staff_rel", "u_id", id);
		int num=bbiz.delObject(tb_name, "u_id", id);
		if(num>0&&num2>0) {

			result="success";
		}
		return result;
	}
	
	
	
	
	/**
	 * 刷新页面
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/refreshUlist.action")
	public String refreshUlist(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("----------UserUtil：更新列表");
		String page=request.getParameter("currentpage");
		String uid=request.getParameter("u_id");
		System.out.println("----------UserUtil：更新列表 page"+page+"uid="+uid);
		currentpage=Integer.valueOf(request.getParameter("currentpage"));
		int id=Integer.valueOf(request.getParameter("u_id"));
		HttpSession session = request.getSession();
		Map usmap=(Map)session.getAttribute("userseachmap");

			
			startNum    =currentpage*rownum-rownum;		
			String listSql=bbiz.creatSQL(tb_name, usmap);		
			List ulist    =ubiz.findList(listSql, startNum, rownum);
			
			
			cordnum  =bbiz.getCordnum(listSql);
			totalpage=getPage(cordnum, rownum);
			session.setAttribute("ulist", ulist);
			PageElement pe=new PageElement(currentpage, totalpage, cordnum);
			session.setAttribute("pageel", pe);
			result="user-list";
		
		return result;
	}
	
	
	
	/**
	 * 增加用户方法
	 * @param request
	 * @param resp
	 * @param user
	 * @param map
	 * @return 增加成功跳转到赋予角色界面
	 */
	
	/**
	 * 跳转增加用户页面方法
	 * @return 
	 */
	@RequestMapping("/addEmpPage.action")
	public String empPage(HttpServletRequest request) {
		System.out.println("----UserUtil：跳转增加用户页面方法  ");
		HttpSession session = request.getSession();
		List rlist=rbiz.findAll();
		System.out.println("-------UserUtil：跳转增加用户页面方法 "+rlist.toString());
		session.setAttribute("rlist", rlist);
		
		return "adduser";
	}
	
	@RequestMapping("/addemp.action")
	public String addemp(HttpServletRequest request, HttpServletResponse resp,User user,@RequestParam Map<String,String> map) {
		System.out.println("----UserUtil：增加用户方法"+user.getU_name());
		int num=1;
		
		String pwd="123456";
		pwd=getStrrMD5(pwd);
		map.put("u_pwd", pwd);
		Map staffmap=new HashMap();
		staffmap.put("role_id", map.get("role_id"));
		map.put("role_id", null);
		
		
		num=bbiz.insertObject(tb_name, map);
		user=ubiz.getUser(user);
		staffmap.put("u_id", user.getU_id());
		int num2=bbiz.insertObject("staff_rel", staffmap);
		result="success";
		
		System.out.println("----USER"+user.toString());
//		HttpSession session = request.getSession();
//		session.setAttribute("newuser", user);
		
/*		
		if(num>0) {
			result="giverole";
			List rlist=rbiz.getPRole(user.getU_id());
			session.setAttribute("prlist", rlist);
		}*/
		
		
		return result;
	}
	
	/**
	 * 赋予用户角色
	 * @param request
	 * @param resp
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/giverole.action")
	public String giveRole(HttpServletRequest request, HttpServletResponse resp,User user,@RequestParam Map<String,String> map) {
		System.out.println("----UserUtil：赋予角色"+map.get("role_id"));

		//List ulist=ubiz.findList(tb_name, null, currentpage, rownum);
		int num=bbiz.insertObject("staff_rel", map);
		if(num>0) {
			result="success";
		}
		return result;
	}
	
	/**
	 * 获取用户列表
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/userlist.action")
	public String userList(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("-------UserUtil：用户列表");

		String listSql=bbiz.creatSQL(tb_name, null);
		
		
		List ulist=ubiz.findList(listSql, 0, rownum);
		System.out.println("------UserUtil："+ulist.toString());
		System.out.println();
		
		HttpSession session = request.getSession();
		session.setAttribute("ulist", ulist);
		
		cordnum=bbiz.getCordnum(listSql);
		totalpage=getPage(cordnum, rownum);
		PageElement pe=new PageElement(currentpage, totalpage, cordnum);
		session.setAttribute("pageel", pe);
		result="user-list";
		return result;
	}
	
	/**
	 * 上一页
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/prev.action")
	public String prev(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("----------UserUtil：上一页");
		currentpage=Integer.valueOf(request.getParameter("currentpage"));
		HttpSession session = request.getSession();
		Map usmap=(Map)session.getAttribute("userseachmap");
		
		currentpage-=1;
		startNum    =currentpage*rownum-rownum;
		
		String listSql=bbiz.creatSQL(tb_name, usmap);		
		List ulist    =ubiz.findList(listSql, startNum, rownum);
		System.out.println("------UserUtil："+ulist.toString());		
		
		cordnum  =bbiz.getCordnum(listSql);
		totalpage=getPage(cordnum, rownum);
		session.setAttribute("ulist", ulist);
		PageElement pe=new PageElement(currentpage, totalpage, cordnum);
		session.setAttribute("pageel", pe);
		result="user-list";
		return result;
	}
	
	
	/**
	 * 下一页
	 * @param request
	 * @param resp
	 * @return
	 */
	
	@RequestMapping("/next.action")
	public String next(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("----------UserUtil：下一页");

		currentpage=Integer.valueOf(request.getParameter("currentpage"));
		HttpSession session = request.getSession();
		Map usmap=(Map)session.getAttribute("userseachmap");
		String listSql=bbiz.creatSQL(tb_name, usmap);	
		
		startNum  =currentpage*rownum;
		List ulist=ubiz.findList(listSql, startNum, rownum);
		currentpage+=1;
		
		cordnum  =bbiz.getCordnum(listSql);
		totalpage=getPage(cordnum, rownum);
		session.setAttribute("ulist", ulist);
		PageElement pe=new PageElement(currentpage, totalpage, cordnum);
		session.setAttribute("pageel", pe);
		result="user-list";
		return result;
	}
}
