package org.great.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
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

	/**
	 * yf
	 * 用户表分页业务
	 */
	@Override
	public List findList(String sql,int offset,int rownum) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(offset,rownum);
		System.out.println("---UserBizImpl:findList=---");
		
		List list=userMapper.findList(sql,rb);
		return list;
	
	}

	/**
	 * 验证用户名
	 */
	@Override
	public List<User> checkUname(Map map) {
		// TODO Auto-generated method stub
		List<User> list=userMapper.checkUser(map);
		
		return list;
	}

	@Override
	public List<User> getUserListAllX() {
		// TODO Auto-generated method stub
		return userMapper.getUserListAllX();
	}


}
