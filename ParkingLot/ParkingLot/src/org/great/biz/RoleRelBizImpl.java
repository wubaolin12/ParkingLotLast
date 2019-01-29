package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.Role;
import org.great.util.BizCup;
import org.springframework.stereotype.Service;

/**
 * 角色员工表Impl实现类(staff_rel)		
 * @author 健哥(佩奇)
 *
 */
@Service("roleRelBiz")
public class RoleRelBizImpl implements RoleRelBiz{

	
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

}
