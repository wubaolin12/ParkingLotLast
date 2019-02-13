package org.great.bean;

/**
 * 预约停车的预约表
 * 
 * @author 野比欣之助
 *
 */
public class Appointment {

	int app_id;
	int cust_id;
	int c_id;
	String app_time;
	/*
	 * 2019-02-13 11:13:55 
	 * 野比欣之助  客户表对象 车辆表对象
	 */
	Cust cust; 
	Car car;
	public Appointment() {
		super();
	}

	public Appointment(int cust_id, int c_id, String app_time) {
		super();
		this.cust_id = cust_id;
		this.c_id = c_id;
		this.app_time = app_time;
	}

	public Appointment(int app_id, int cust_id, int c_id, String app_time) {
		super();
		this.app_id = app_id;
		this.cust_id = cust_id;
		this.c_id = c_id;
		this.app_time = app_time;
	}

	public Appointment(int app_id, int cust_id, int c_id, String app_time, Cust cust, Car car) {
		super();
		this.app_id = app_id;
		this.cust_id = cust_id;
		this.c_id = c_id;
		this.app_time = app_time;
		this.cust = cust;
		this.car = car;
	}

	@Override
	public String toString() {
		return "Appointment [app_id=" + app_id + ", cust_id=" + cust_id + ", c_id=" + c_id + ", app_time=" + app_time
				+ ", cust=" + cust + ", car=" + car + "]";
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getApp_time() {
		return app_time;
	}

	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}

	public Cust getCust() {
		return cust;
	}

	public void setCust(Cust cust) {
		this.cust = cust;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
