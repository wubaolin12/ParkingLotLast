package org.great.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 车辆表
 * @author 野比欣之助
 *
 */
@Component
public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3729636545376416199L;
	private int c_id;// id(主键)
	private int cust_id;// 用户ID（外键）
	private int pm_id;// 车辆角色ID（外键----->参数表ID
	private String c_num;// 车牌号（唯一性）
	private String c_null1;// 空字段
	//2019-1-21  刘子健新建
	private String rownum;
	public Car() {
		super();
	}
	public Car(String c_num) {
		super();
		this.c_num = c_num;
	}
	public Car(int c_id, int cust_id, int pm_id, String c_num, String c_null1, String rownum) {
		super();
		this.c_id = c_id;
		this.cust_id = cust_id;
		this.pm_id = pm_id;
		this.c_num = c_num;
		this.c_null1 = c_null1;
		this.rownum = rownum;
	}
	@Override
	public String toString() {
		return "Car [c_id=" + c_id + ", cust_id=" + cust_id + ", pm_id=" + pm_id + ", c_num=" + c_num + ", c_null1="
				+ c_null1 + ", rownum=" + rownum + "]";
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getPm_id() {
		return pm_id;
	}
	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getC_null1() {
		return c_null1;
	}
	public void setC_null1(String c_null1) {
		this.c_null1 = c_null1;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
