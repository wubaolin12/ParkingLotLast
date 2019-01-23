package org.great.bean;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 用户表(tb_cust)
 * 
 * @author 野比欣之助
 *
 */
@Component
public class Cust {

	private int cust_id;// id(主键)
	private int pm_id;// 用户状态
	private String cust_acc;// 昵称(账号即用户名)
	private String cust_pwd;// 密码
	private String cust_sex;// 性别
	private int cust_age;// 年龄
	private String cust_phone;// 电话（唯一性）
	private int cust_money;// 余额
	private String cus_null1;// 空字段
	private String cus_null2;// 空字段
	private String cus_null3;// 空字段
	private Param param;// 参数表
	private Car car;// 车辆表
	// 2019-1-21刘子健添加新字段
	private List<Car> cars;

	public Cust() {
		super();
	}

	public Cust(String cust_pwd, String cust_phone) {
		super();
		this.cust_pwd = cust_pwd;
		this.cust_phone = cust_phone;
	}

	public Cust(int cust_id, int pm_id, String cust_acc, String cust_pwd, String cust_sex, int cust_age,
			String cust_phone, int cust_money, String cus_null1, String cus_null2, String cus_null3, Param param,
			Car car, List<Car> cars) {
		super();
		this.cust_id = cust_id;
		this.pm_id = pm_id;
		this.cust_acc = cust_acc;
		this.cust_pwd = cust_pwd;
		this.cust_sex = cust_sex;
		this.cust_age = cust_age;
		this.cust_phone = cust_phone;
		this.cust_money = cust_money;
		this.cus_null1 = cus_null1;
		this.cus_null2 = cus_null2;
		this.cus_null3 = cus_null3;
		this.param = param;
		this.car = car;
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Cust [cust_id=" + cust_id + ", pm_id=" + pm_id + ", cust_acc=" + cust_acc + ", cust_pwd=" + cust_pwd
				+ ", cust_sex=" + cust_sex + ", cust_age=" + cust_age + ", cust_phone=" + cust_phone + ", cust_money="
				+ cust_money + ", cus_null1=" + cus_null1 + ", cus_null2=" + cus_null2 + ", cus_null3=" + cus_null3
				+ ", param=" + param + ", car=" + car + ", cars=" + cars + "]";
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

	public String getCust_acc() {
		return cust_acc;
	}

	public void setCust_acc(String cust_acc) {
		this.cust_acc = cust_acc;
	}

	public String getCust_pwd() {
		return cust_pwd;
	}

	public void setCust_pwd(String cust_pwd) {
		this.cust_pwd = cust_pwd;
	}

	public String getCust_sex() {
		return cust_sex;
	}

	public void setCust_sex(String cust_sex) {
		this.cust_sex = cust_sex;
	}

	public int getCust_age() {
		return cust_age;
	}

	public void setCust_age(int cust_age) {
		this.cust_age = cust_age;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public int getCust_money() {
		return cust_money;
	}

	public void setCust_money(int cust_money) {
		this.cust_money = cust_money;
	}

	public String getCus_null1() {
		return cus_null1;
	}

	public void setCus_null1(String cus_null1) {
		this.cus_null1 = cus_null1;
	}

	public String getCus_null2() {
		return cus_null2;
	}

	public void setCus_null2(String cus_null2) {
		this.cus_null2 = cus_null2;
	}

	public String getCus_null3() {
		return cus_null3;
	}

	public void setCus_null3(String cus_null3) {
		this.cus_null3 = cus_null3;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
