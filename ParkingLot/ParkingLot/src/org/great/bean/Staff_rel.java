package org.great.bean;

import java.io.Serializable;

public class Staff_rel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_id;
	private int role_id;
	private Role role;
	public Staff_rel(int u_id, int role_id) {
		super();
		this.u_id = u_id;
		this.role_id = role_id;
	}
	public Staff_rel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
	@Override
	public String toString() {
		return "Staff_rel [u_id=" + u_id + ", role_id=" + role_id + "]";
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
