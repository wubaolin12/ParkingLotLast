package org.great.biz;

import java.util.List;

import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.bean.RoleMenu;

/**
 * 菜单表BIZ
 * 
 * @author 野比欣之助
 *
 */
public interface MenuBiz {

	/**
	 * 通过角色找对应菜单
	 * @return menulist
	 * @param 角色id、
	 * @author 吴宝林
	 */
	public List<Menu> findMenu(int role_id);

	/**
	 * 查找未分配菜单
	 * @param role_id
	 * @return
	 * @author 吴宝林
	 */
	public List<Menu> findUnallot(int role_id);

	/**
	 * 	获取子节点数量
	 * @param rm
	 * @return
	 */
	public int getCount(RoleMenu rm);

}
