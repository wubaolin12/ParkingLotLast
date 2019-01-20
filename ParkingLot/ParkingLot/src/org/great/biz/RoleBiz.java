package org.great.biz;

import java.util.List;

import org.great.bean.Role;

/**
 * 角色表BIZ	
 * @author 野比欣之助
 *
 */
public interface RoleBiz {

	/**
	 * 查找全部角色
	 * @return
	 */
	public List<Role> findAll();

}
