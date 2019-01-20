package org.great.bean;

import java.io.Serializable;

/**
 * 菜单表
 * @author 野比欣之助
 *
 */
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int menu_id;// id（主键）
	private int menu_pid;// 上一级lid
	private String menu_name;// 菜单名
	private String menu_link;// 菜单URL

	public Menu() {
		super();
	}

	public Menu(int menu_pid, String menu_name, String menu_link) {
		super();
		this.menu_pid = menu_pid;
		this.menu_name = menu_name;
		this.menu_link = menu_link;
	}

	public Menu(int menu_id, int menu_pid, String menu_name, String menu_link) {
		super();
		this.menu_id = menu_id;
		this.menu_pid = menu_pid;
		this.menu_name = menu_name;
		this.menu_link = menu_link;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_pid=" + menu_pid + ", menu_name=" + menu_name + ", menu_link="
				+ menu_link + "]";
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getMenu_pid() {
		return menu_pid;
	}

	public void setMenu_pid(int menu_pid) {
		this.menu_pid = menu_pid;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_link() {
		return menu_link;
	}

	public void setMenu_link(String menu_link) {
		this.menu_link = menu_link;
	}

}
