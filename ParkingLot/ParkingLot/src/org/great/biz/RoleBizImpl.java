package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Role;
import org.great.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * 角色表Impl实现类(tb_aut)		
 * @author 健哥
 *
 */
@Service("roleBiz")
public class RoleBizImpl implements RoleBiz{

	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		List<Role> roleList = roleMapper.findAll();
		return roleList;
	}

}
