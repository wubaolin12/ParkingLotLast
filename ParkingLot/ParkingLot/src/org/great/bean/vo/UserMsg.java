package org.great.bean.vo;

import org.great.bean.Role;
import org.great.bean.User;

import com.mysql.fabric.xmlrpc.base.Param;

/**
 * 员工表，角色表，参数表
 * 
 * @author Administrator
 *
 */
public class UserMsg {
	User user;// 员工表
	Role role;// 角色表
	Param param;// 参数表

	public UserMsg() {
		super();
	}

	public UserMsg(User user, Role role, Param param) {
		super();
		this.user = user;
		this.role = role;
		this.param = param;
	}

	@Override
	public String toString() {
		return "UserMsg [user=" + user + ", role=" + role + ", param=" + param + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

}
