package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.Menu;
import org.great.bean.Role;
import org.great.bean.RoleRel;
import org.great.bean.Staff_rel;
import org.great.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	//通过用户名获得一个用户对象
	
	public User getUser(User user);
	/**
	 * 查找用户ID
	 * @param id
	 * @return
	 * @author yf
	 */
	// 
	public RoleRel FindbyID(int id);

	/**
	 * 
	 * 分页方法
	 * @return
	 * @author yf
	 */
	public List findList(String sql,RowBounds rb);
	
	
	// 通过用户账号密码查找用户信息
	public Object findUserByName(User user);

	// 通过ID查找角色信息
	public RoleRel FindStaffRole(int staffid);
	
	public Staff_rel Selectstaff_rel(User user);
	
	//查找所有角色列表
	public List<Role> GetRole();
	
	public List<User>findUList(String tb_name);
	
	public List<User>findUList2(@Param("sql")String tb_name);
	
	/**
	 * 查询用户
	 * @param map
	 * @return
	 */
	public List<User>checkUser(@Param("dataMap")Map map);
}
