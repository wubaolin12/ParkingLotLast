package org.great.bean;

import org.springframework.stereotype.Component;

/**
 * 角色员工表(staff_rel)		
 * @author 野比欣之助
 *
 */
@Component
public class RoleRel {
	private int sr_id;// id（主键）
	private int u_id;// 员工id（外键）
	private int role_id;// 角色id（外键）
	private User user;// 员工类
	private Role role;// 角色类

	public RoleRel(int u_id, int role_id, User user, Role role) {
		super();
		this.u_id = u_id;
		this.role_id = role_id;
		this.user = user;
		this.role = role;
	}

	public RoleRel(int sr_id, int u_id, int role_id) {
		super();
		this.sr_id = sr_id;
		this.u_id = u_id;
		this.role_id = role_id;
	}

	public RoleRel() {
		super();
	}

	public RoleRel(int role_id) {
		super();
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "RoleRel [sr_id=" + sr_id + ", u_id=" + u_id + ", role_id=" + role_id + "]";
	}

	public RoleRel(int u_id, int role_id) {
		super();
		this.u_id = u_id;
		this.role_id = role_id;
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

	public int getSr_id() {
		return sr_id;
	}

	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}
