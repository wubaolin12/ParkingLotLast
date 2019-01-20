package org.great.mapper;

import org.great.bean.RoleMenu;
import org.springframework.stereotype.Repository;

/**
 * 	角色菜单关系表映射接口
 * @author 吴宝林
 *
 */
@Repository
public interface RoleMenuMapper {

	/**
	 *	 删除相关权限菜单
	 * @param rm
	 * @return
	 * @author 吴宝林
	 */
	public int del(RoleMenu rm);

	/**
	 * 	插入新权限
	 * @param rm
	 * @return
	 */
	public int insert(RoleMenu rm);

}
