package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.bean.RoleRel;

/**
 * 角色员工表BIZ	
 * @author 野比欣之助
 *
 */
public interface RoleRelBiz {
	
	public List<Role> seachRole(Map map);
	
	public Role getRoleObject(String id);
	/**
	 * 根据员工ID查找角色
	 * 
	 * @param id
	 * @return
	 */
	public List<RoleRel> FindRoleIDbyUserIDX(int id);
}
