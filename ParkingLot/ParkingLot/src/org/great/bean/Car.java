package org.great.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 车辆表
 * 
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
	private String c_pic;// 空字段
	/**VIP表 2019/1/23  野比新之助
	 * 
	 */
	private Vip vip;
	
	/**
	 * 客户表 2019/1/22 10:48:01 野比新之助
	 * 
	 */
	private Cust cust;
	/**
	 * 参数表 2019/1/22 10:48:55 野比新之助
	 * 
	 */
	private Param param;
	// 2019-1-21 刘子健新建
	private String rownum;

	public Car() {
		super();
	}

	public Car(int pm_id, String c_num) {
		super();
		this.pm_id = pm_id;
		this.c_num = c_num;
	}

	public Car(int cust_id, int pm_id, String c_num) {
		super();
		this.cust_id = cust_id;
		this.pm_id = pm_id;
		this.c_num = c_num;
	}

	public Car(int c_id, int cust_id, int pm_id, String c_num, String c_pic, String rownum) {
		super();
		this.c_id = c_id;
		this.cust_id = cust_id;
		this.pm_id = pm_id;
		this.c_num = c_num;
		this.c_pic = c_pic;
		this.rownum = rownum;
	}

	public Car(int c_id, int cust_id, int pm_id, String c_num, String c_pic, Cust cust, Param param, String rownum) {
		super();
		this.c_id = c_id;
		this.cust_id = cust_id;
		this.pm_id = pm_id;
		this.c_num = c_num;
		this.c_pic = c_pic;
		this.cust = cust;
		this.param = param;
		this.rownum = rownum;
	}

	public Car(int c_id, int cust_id, int pm_id, String c_num, String c_pic, Vip vip, Cust cust, Param param,
			String rownum) {
		super();
		this.c_id = c_id;
		this.cust_id = cust_id;
		this.pm_id = pm_id;
		this.c_num = c_num;
		this.c_pic = c_pic;
		this.vip = vip;
		this.cust = cust;
		this.param = param;
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "Car [c_id=" + c_id + ", cust_id=" + cust_id + ", pm_id=" + pm_id + ", c_num=" + c_num + ", c_pic="
				+ c_pic + ", vip=" + vip + ", cust=" + cust + ", param=" + param + ", rownum=" + rownum + "]";
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

	public String getC_pic() {
		return c_pic;
	}

	public void setC_pic(String c_pic) {
		this.c_pic = c_pic;
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

	public Cust getCust() {
		return cust;
	}

	public void setCust(Cust cust) {
		this.cust = cust;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

}
