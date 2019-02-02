package org.great.mapper;

import java.util.List;

import org.great.bean.RoleRel;
import org.springframework.stereotype.Repository;

/**
 * 角色员工表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface RoleRelMapper {
	/**
	 * 根据员工ID查找角色
	 * 
	 * @param id
	 * @return
	 */
	public List<RoleRel> FindRoleIDbyUserIDX(int id);

}
