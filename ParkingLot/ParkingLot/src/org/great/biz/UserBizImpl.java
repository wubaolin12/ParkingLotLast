package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Role;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.great.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 员工表BizImpl
 * 
 * @author 野比欣之助
 *
 */
@Service("userBiz")
public class UserBizImpl implements UserBiz {

	@Resource
	private UserMapper userMapper;

	private boolean flag;

	@Override
	public Object findUserByName(User user) {

		return userMapper.findUserByName(user);
	}

	@Override
	public RoleRel FindStaffRole(int staffid) {
		// TODO Auto-generated method stub
		return userMapper.FindStaffRole(staffid);

	}


	// 返回所有角色列表
	@Override
	public List<Role> GetRole() {
		// TODO Auto-generated method stub
		return userMapper.GetRole();
	}


	public User getUser(User user) {

		return userMapper.getUser(user);
	}

}
