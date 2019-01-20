package org.great.mapper;

import java.util.List;

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
	
	public List findElse(String id);

}
