package org.great.biz;

import java.util.List;

import org.great.bean.Role;
import org.great.bean.RoleRel;
import org.great.bean.User;

/**
 * 员工表BIZ							
 * @author 野比欣之助
 *
 */
public interface UserBiz {


	public User getUser(User user) ;
	
	//登录验证返回用户
	public Object findUserByName(User user);

	//验证当前用户角色信息
	public RoleRel FindStaffRole(int staffid);

	
	//查找所有角色列表
	public List<Role> GetRole();
}
