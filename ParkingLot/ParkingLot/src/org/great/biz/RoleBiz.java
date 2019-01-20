package org.great.biz;

import java.util.List;

import org.great.bean.Role;

/**
 * 角色表BIZ	
 * @author 野比欣之助
 *
 */
public interface RoleBiz {

	public List getPRole(int id);
	
	public List<Role> findAll();
}
