package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.biz.BaseBiz;
import org.great.biz.MenuBiz;
import org.great.biz.RoleBiz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 菜单管理handle
 * @author yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/menumanage")
public class MenuHandler extends BaseUtil{
	
	
	@Resource
	private BaseBiz bbiz;
	@Resource
	private MenuBiz mbiz;
	@Resource
	private RoleBiz rbiz;
	
	private String result;
	@Value("tb_menu")
	private String tb_name;
	
	/**
	 * 跳转修改菜单页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */
	@RequestMapping("/toUpdateMenu.action")
	public String toUpdateMenu(HttpServletRequest request) 
	{
		
		String id=request.getParameter("menu_id");
		System.out.println("-----MenuHandler,toUpdateMenu++ID="+id);
		
		Menu menu=mbiz.getMenuObject(id);
		request.setAttribute("menuObject", menu);			
		
		result="update-menu";
		return result;
		
	}
	
	/**
	 * 跳转增加菜单页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */	
	@RequestMapping("/toInsertMenu.action")
	public String toInsertMenu(HttpServletRequest request) 
	{
		
		String id=request.getParameter("menu_id");
		System.out.println("-----MenuHandler,toInsertMenu");
		
		List<Role> rlist=rbiz.findAll();
		request.setAttribute("rlist", rlist);
		
		result="add-menu";
		return result;
		
	}
	
	
	/**
	 * 获取菜单列表
	 * @param request
	 * @param resp
	 * @return
	 * @author ASUSyf
	 */
	@RequestMapping("/menuList.action")
	public String menuList(HttpServletRequest request, HttpServletResponse resp) 
	{
		System.out.println("-----MenuHandler,ulist");
		
		List<Menu> mlist=mbiz.getMenuList();
		
		request.setAttribute("mlist", mlist);
		
		result="menu-list";
		return result;
		
	}
	
	/**
	 * 查询菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@RequestMapping("/seachmenuList.action")
	public String seachmenuList(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----MenuHandler,seachmenuList");
		
		map.put("menu_id", map.get("seachword"));
		map.put("menu_name", map.get("seachword"));
		map.put("menu_link", map.get("seachword"));
		map.remove("seachword");
		
		List<Menu> mlist=mbiz.seachMenu(map);
		
		request.setAttribute("mlist", mlist);
		
		result="menu-list";
		return result;
		
	}
	
	/**
	 * 增加菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_yf
	 */
	@RequestMapping("/insertMenu.action")
	public String insertMenu(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----MenuHandler,insertMenu");
		
		Map rmap=new HashMap<>();
		rmap.put("role_id", map.get("role_id"));
		map.remove("role_id");
		
		Map kmap=new HashMap<>();
		kmap.put("id", null);
		
		int num =bbiz.insertData(tb_name, map,kmap);
		
		rmap.put("menu_id",kmap.get("id"));
		System.out.println("--------MEnu getMenuID"+kmap);
		int num2=bbiz.insertData("role_menu", rmap,null);	
		
		
		if(num>0&&num2>0) {
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
	@RequestMapping("/updateMenu.action")
	public String updateMenu(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		String id=request.getParameter("menu_id");
		System.out.println("-----MenuHandler,updateMenu"+id);
		
		int num=bbiz.updateData(tb_name, map, "menu_id", id);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	/**
	 * 删除菜单
	 * @param request
	 * @return
	 * @author ASUS_yf
	 */
	@RequestMapping("/delMenu.action")
	public String delMenu(HttpServletRequest request) 
	{
		System.out.println("-----MenuHandler,delMenu");
		String id=request.getParameter("menu_id");
		Map map=new HashMap<>();
		map.put("menu_id", id);
		
		int num=bbiz.delData(tb_name, map);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
}
