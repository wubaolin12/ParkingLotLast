package org.great.bean;

import java.io.Serializable;

/**
 * 角色表(tb_role)		
 * @author 野比欣之助
 *
 */
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904450220204729774L;
	private int role_id;// id（主键）
	private String role_name;// 角色名称

	public Role(String role_name) {
		super();
		this.role_name = role_name;
	}

	public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + "]";
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
