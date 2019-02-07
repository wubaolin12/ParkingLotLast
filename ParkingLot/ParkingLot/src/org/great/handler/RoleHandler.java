package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Combo;
import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.biz.BaseBiz;
import org.great.biz.RoleBiz;
import org.great.log.OperationLog;
import org.great.util.BizCup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
/**
 * 角色管理类型
 * @author ASUS_yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/rolemanage")
public class RoleHandler {
	@Resource
	private RoleBiz rbiz;
	@Resource
	private BaseBiz bbiz;
	@Value("tb_role")
	private String tb_name;
	
	private String result;
	
	/**
	 * 跳转修改菜单页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */
	@RequestMapping("/toUpdateRole.action")
	public String toUpdateMenu(HttpServletRequest request) 
	{
		
		String id=request.getParameter("role_id");
		System.out.println("-----RoleHandler,toUpdaterole++ID="+id);
		
	//	Menu menu=mbiz.getMenuObject(id);
	//	request.setAttribute("menuObject", menu);			
		
		Role role=rbiz.getRoleObject(id);
		request.setAttribute("roleObject", role);
		result="role/update-role";
		return result;
		
	}
	
	/**
	 * 跳转增加菜单页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */	
	@RequestMapping("/toInsertRole.action")
	public String toInsertMenu(HttpServletRequest request) 
	{
		System.out.println("-----MenuHandler,toInsertrole");

		result="add-role";
		return result;
		
	}
	
	
	/**
	 * 获取菜单列表
	 * @param request
	 * @param resp
	 * @return
	 * @author ASUSyf
	 */
	@RequestMapping("/roleList.action")
	public String roleList(HttpServletRequest request, HttpServletResponse resp) 
	{
		System.out.println("-----RoleHandler,rlist");
		
		List<Role> rlist=rbiz.findAll();
		
		request.setAttribute("rlist", rlist);
		
		result="role/role-list";
		return result;
		
	}
	
	/**
	 * 查询菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@RequestMapping("/seachroleList.action")
	public String seachmenuList(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----roleHandler,seachmenuList");
		
		map.put("role_name", map.get("seachword"));
		
		map.remove("seachword");

		result="role/role-list";
		return result;
		
	}
	
	/**
	 * 增加菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_yf
	 */
	@OperationLog(operationType = "系统管理", operationName = "增加角色")	
	@RequestMapping("/insertRole.action")
	public String insertMenu(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----roleHandler,insertMenu");
		

		int num=bbiz.insertData(tb_name, map,null);	
		
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	/**
	 * 更新菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@OperationLog(operationType = "系统管理", operationName = "修改角色")	
	@RequestMapping("/updateRole.action")
	public String updateMenu(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		String id=request.getParameter("role_id");
		System.out.println("-----roleHandler,updaterole"+id);
		
		int num=bbiz.updateData(tb_name, map, "role_id", id);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateRoleAjax.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String updateRoleAjax(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("--------updateRoleAjax");
		System.out.println(map.toString());
		int num=bbiz.updateData(tb_name, map, "role_id", map.get("role_id"));
		
		if(num>0) {
			Role role=rbiz.getRoleObject(map.get("role_id"));	
			JSONObject json = JSONObject.fromObject(role);
			String jstr=json.toString();
			
			result=jstr;
		}
		return result;
		
	}
	
	/**
	 * 删除菜单
	 * @param request
	 * @return
	 * @author ASUS_yf
	 */
	@OperationLog(operationType = "系统管理", operationName = "删除角色")	
	@RequestMapping("/delRole.action")
	public String delMenu(HttpServletRequest request) 
	{
		System.out.println("-----roleHandler,delrole");
		String id=request.getParameter("role_id");
		Map map=new HashMap<>();
		map.put("role_id", id);
		
		int num=bbiz.delData(tb_name, map);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
}
