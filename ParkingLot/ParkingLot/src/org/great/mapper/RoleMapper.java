package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Menu;
import org.great.bean.Role;
import org.springframework.stereotype.Repository;

/**
 * 权限表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface RoleMapper {

	/**
	 * 获取全部角色列表
	 * @return
	 * @author 吴宝林
	 */
	public List<Role> findAll();
	
	public List<Role> findElse(String id);
	
	
	/**
	 * 查询角色方法
	 * @param map
	 * @return
	 */
	public List<Role>seachRole(@Param("dataMap")Map map);
	
		
	/**
	 * 获取一个对象
	 * @param id
	 * @return
	 */
	public Role getRoleObject(@Param("role_id")String id);

}
