package org.great.mapper;

import java.util.List;

import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	//通过用户名获得一个用户对象
	
	public User getUser(User user);
	
	// 查找用户ID
	public RoleRel FindbyID(int id);

	// 通过用户账号密码查找用户信息
	public Object findUserByName(User user);

	// 通过ID查找角色信息
	public RoleRel FindStaffRole(int staffid);
	
	//权限管理增加菜单
	public int interObject(Object obj);
	
	//权限管理删除菜单
	public int delmenu(Object obj);

	// 查找已有一级子菜单
	public List<Menu> GetYOneMenu(int ID);

    //查找已有二级子菜单
	public List<Menu> GetYTwoMenu(int ID);
	
	//查找未有一级子菜单
	public List<Menu> GetNOneMenu(int ID);
	
	//查找未有二级子菜单
	public List<Menu> GetNTwoMenu(int ID);
	
	//查找所有角色列表
	public List<Role> GetRole();

}
