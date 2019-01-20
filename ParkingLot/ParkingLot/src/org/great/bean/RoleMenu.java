package org.great.bean;

import java.io.Serializable;

/**
 * 角色菜单关系表
 * 
 * @author 吴宝林
 *
 */
public class RoleMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rm_id;
	private int role_id;
	private int menu_id;
	private String mids;

	public RoleMenu(int role_id, int menu_id) {
		super();
		this.role_id = role_id;
		this.menu_id = menu_id;
	}

	public RoleMenu() {
		super();
	}

	public int getRm_id() {
		return rm_id;
	}

	public void setRm_id(int rm_id) {
		this.rm_id = rm_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	@Override
	public String toString() {
		return "RoleMenu [rm_id=" + rm_id + ", role_id=" + role_id + ", menu_id=" + menu_id + ", mids=" + mids + "]";
	}

	public String getMids() {
		return mids;
	}

	public void setMids(String mids) {
		this.mids = mids;
	}

	
}
