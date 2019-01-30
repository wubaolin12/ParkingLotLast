package org.great.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.bean.RoleMenu;
import org.great.biz.MenuBiz;
import org.great.biz.RoleBiz;
import org.great.biz.RoleMenuBiz;
import org.great.log.OperationLog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

/**
 * 动态菜单+权限管理
 * 
 * @author 吴宝林
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/menu")
public class PermissionMenuHandler {

	@Resource
	private MenuBiz menuBiz;
	@Resource
	private RoleBiz roleBiz;
	@Resource
	private RoleMenuBiz roleMenuBiz;

	/**
	 * 跳转到权限管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/grant.action")
	public String grant(HttpServletRequest request) {

		//获取角色名称
		List<Role> roleList = roleBiz.findAll();
		HttpSession session = request.getSession();
		
		session.setAttribute("roleList", roleList);
		
		return "menu_grant";
	}

	/**
	 * 添加权限菜单
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addmenu.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@OperationLog(operationType = "权限操作", operationName = "添加权限菜单")
	public String addMenu(@RequestBody RoleMenu rm,HttpServletRequest request) {
		String ret="请选择要添加的权限！";
		System.out.println("-----"+rm.toString()+"---"+ret+"----");
		
		boolean flag = false;
		
		if (rm.getMids()==null||rm.getMids()=="") {
			return ret;
		}
		int r_id = Integer.valueOf(rm.getRole_id());
		String[] menuids = rm.getMids().split(",");

		// 插入数据
		for (int i = 0; i < menuids.length; i++) {
			int m_id = Integer.valueOf(menuids[i]);
			
			// 如果有子节点就不插入
			rm.setMenu_id(m_id);
			rm.setRole_id(r_id);
			int count = menuBiz.getCount(rm);
			if (count > 0) {
				continue;
			}
			
			flag = roleMenuBiz.insert(rm);
			System.out.println("插入数据菜单--" + m_id + "角色：" + r_id);
			
		}
		if(flag) {
			ret="添加成功";
		}else {
			ret="添加失败";
		}
		return ret;
	}

	/**
	 * 移除权限菜单
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/removemenu.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@OperationLog(operationType = "权限操作", operationName = "添加权限菜单")
	public String removeMenu( @RequestBody RoleMenu rm) {
		String ret="请选择要移除的权限！";
		System.out.println("-----"+rm.toString()+"---"+ret+"----");
		
		boolean flag = false;
		
		if (rm.getMids()==null||rm.getMids()=="") {
			return ret;
		}
		int r_id = Integer.valueOf(rm.getRole_id());
		String[] menuids = rm.getMids().split(",");

		// 插入数据
		for (int i = menuids.length - 1; i >= 0; i--) {
			int m_id = Integer.valueOf(menuids[i]);
			
			// 如果有子节点就不插入
			rm.setMenu_id(m_id);
			rm.setRole_id(r_id);
			int count = menuBiz.getCount(rm);
			if (count > 0) {
				continue;
			}
			
			//没有子节点执行删除操作
			flag = roleMenuBiz.del(rm);
			System.out.println("插入数据菜单--" + m_id + "角色：" + r_id+"--flag="+flag);
			
			if(flag) {
				ret="移除成功";
			}else {
				ret="移除失败";
			}
		}
		return ret;
	}

	/**
	 * 查找已分配权限
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/allot.action")
	public List<Map<String, Object>> allot(@RequestBody Role role) {

		List<Menu> menuList = menuBiz.findMenu(role.getRole_id());

		List<Map<String, Object>> mapList = menuToMap(menuList);

		return mapList;

	}

	/**
	 * 查找未分配权限
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/unallot.action")
	public List<Map<String, Object>> unallot(@RequestBody Role role) {

		List<Menu> menuList = menuBiz.findUnallot(role.getRole_id());

		List<Map<String, Object>> mapList = menuToMap(menuList);

		return mapList;
	}

	/**
	 * 将查询到到menuList转为map
	 * 
	 * @param menuList
	 * @return
	 */
	private List<Map<String, Object>> menuToMap(List<Menu> menuList) {

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		for (Menu menu : menuList) {
			Map<String, Object> node = new HashMap<String, Object>();

			node.put("id", menu.getMenu_id());
			node.put("name", menu.getMenu_name());
			node.put("pId", menu.getMenu_pid());

			if (menu.getMenu_pid() != 0) {
				mapList.add(node);
			} else {
				node.put("open", true);// 节点展开

				for (Menu m : menuList) {
					if (m.getMenu_pid() == menu.getMenu_id()) {

						// 如果有子节点则添加
						mapList.add(node);
						break;
					}
				}
			}
		}
		return mapList;
	}

}
