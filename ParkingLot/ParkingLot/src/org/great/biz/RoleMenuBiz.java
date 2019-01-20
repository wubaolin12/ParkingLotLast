package org.great.biz;

import org.great.bean.RoleMenu;

/**
 * 	角色菜单关系表biz接口
 * @author 吴宝林
 *
 */
public interface RoleMenuBiz {

	/**
	 * 删除权限菜单
	 * @param rm
	 * @return
	 * @author 吴宝林
	 */
	public boolean del(RoleMenu rm);

	/**
	 * 添加权限
	 * @param rm
	 * @return
	 * @author 吴宝林
	 */
	public boolean insert(RoleMenu rm);

}
