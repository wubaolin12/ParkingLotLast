package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Role;
import org.great.bean.RoleRel;
import org.great.mapper.RoleRelMapper;
import org.great.util.BizCup;
import org.springframework.stereotype.Service;

/**
 * 角色员工表Impl实现类(staff_rel)		
 * @author 健哥(佩奇)
 *
 */
@Service("roleRelBiz")
public class RoleRelBizImpl implements RoleRelBiz{

	@Resource
	private RoleRelMapper roleRelMapper;
	
	@Override
	public List<Role> seachRole(Map map) {
		// TODO Auto-generated method stub
		return BizCup.rolemapper.findAll();
	}

	@Override
	public Role getRoleObject(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RoleRel> FindRoleIDbyUserIDX(int id) {
		// TODO Auto-generated method stub
		return roleRelMapper.FindRoleIDbyUserIDX(id);
	}
}
