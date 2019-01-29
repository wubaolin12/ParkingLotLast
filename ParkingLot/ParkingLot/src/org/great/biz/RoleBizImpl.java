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
@Service("rolebiz")
public class RoleBizImpl implements RoleBiz{

	@Resource
	private RoleMapper rm;
	
	@Override
	public List getPRole(int id) {
		// TODO Auto-generated method stub
		System.out.println("+++++++---RoleBizImpl:getPRole 进入了"+id);
		if(rm!=null) {
			System.out.println("ssss");
		}else {
			System.out.println("null----");
		}
		
		List list=rm.findElse(""+id);
		
		return list;
	}
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		List<Role> roleList = roleMapper.findAll();
		return roleList;
	}

	@Override
	public Role getRoleObject(String id) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleObject(id);
	}

}
