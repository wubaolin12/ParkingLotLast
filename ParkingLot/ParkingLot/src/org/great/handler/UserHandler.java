package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.PageElement;
import org.great.bean.Role;
import org.great.bean.User;
import org.great.bean.vo.UserMsg;
import org.great.biz.BaseBiz;
import org.great.biz.RoleBiz;
import org.great.biz.UserBiz;
import org.great.biz.UserMsgBiz;
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
	@Resource
	private UserMsgBiz umbiz;
	
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
		//int num=bbiz.updateObject(tb_name, map, "u_id", id);
		int num=bbiz.updateData(tb_name, map, "u_id", ""+id);
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
		//int num=bbiz.updateObject(tb_name, map, "u_id", id);
		int num=bbiz.updateData(tb_name, map, "u_id", ""+id);
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
		
		System.out.println("-----UserUtil：update user="+user.toString());
		//user=ubiz.getUser(user);
		UserMsg upateuser=umbiz.getUserObject(""+user.getU_id());

		request.setAttribute("updateuser", upateuser);
		
		List<Role> rlist=rbiz.findAll();
		request.setAttribute("rlist", rlist);
		return "user/update-user";
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
		String id=request.getParameter("u_id");
		Map rolemap=new HashMap<>();
		rolemap.put("role_id", map.get("role_id"));
		map.remove("role_id");
		
		int num=bbiz.updateData("staff_rel", rolemap, "u_id", id);
		
		int num1=bbiz.updateData(tb_name, map, "u_id", id);
		
		if(num>0&&num1>0) {
			result="success";
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
		//int num=bbiz.updateObject(tb_name, map, "u_id", u_id);
		int num=bbiz.updateData(tb_name, map, "u_id",""+u_id);
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
/*		HttpSession session = request.getSession();
		Map usmap=(Map)session.getAttribute("userseachmap");*/
		Map map=new HashMap<>();
		map.put("u_id", id);
		
		int num2=bbiz.delData("staff_rel", map);
		int num=bbiz.delData(tb_name, map);
		
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
		List<Role> rlist=rbiz.findAll();
		request.setAttribute("rlist", rlist);
		
		return "user/add-user";
	}
	
	@RequestMapping("/addemp.action")
	public String addemp(HttpServletRequest request, HttpServletResponse resp,User user,@RequestParam Map<String,String> map) {
		System.out.println("----UserUtil：增加用户方法"+user.getU_name());
		int num=1;
		
		String pwd="123456";
		pwd=getStrrMD5(pwd);
		map.put("u_pwd", pwd);
		Map rolemap=new HashMap();
		
		//用以获取刚插入的数据的主键
		Map idmap=new HashMap();
		idmap.put("id",null);
		
		rolemap.put("role_id", map.get("role_id"));
		map.remove("role_id");
		
		//执行插入后，idmap.get("id")可获取主键
		num=bbiz.insertData(tb_name, map, idmap);

		
		rolemap.put("u_id", idmap.get("id"));
		//int num2=bbiz.insertObject("staff_rel", staffmap);
		int num2=bbiz.insertData("staff_rel", rolemap, null);
		if(num>0&&num2>0){
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

		List<UserMsg>ulist=umbiz.userList(null);
		request.setAttribute("ulist", ulist);
		result="user/user-list";
		return result;
	}

	

}
