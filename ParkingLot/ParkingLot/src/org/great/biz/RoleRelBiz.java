package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.Menu;
import org.great.bean.Role;

/**
 * 角色员工表BIZ	
 * @author 野比欣之助
 *
 */
public interface RoleRelBiz {
	
	public List<Role> seachRole(Map map);
	
	public Role getRoleObject(String id);
	
}
