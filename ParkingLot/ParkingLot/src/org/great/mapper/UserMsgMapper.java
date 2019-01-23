package org.great.mapper;

import java.util.List;

import org.great.bean.vo.UserMsg;
import org.springframework.stereotype.Repository;

/**
 * 员工表，角色表，参数表
 * 
 * @author Administrator
 *
 */
@Repository
public interface UserMsgMapper {

	/**
	 * yf获取用户信息
	 * @return
	 */
	public List<UserMsg> findUserMsg(UserMsg user);
}
