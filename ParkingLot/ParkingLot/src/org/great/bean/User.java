package org.great.bean;

import org.springframework.stereotype.Component;

/**
 * 员工表(tb_user)								
 * @author 野比欣之助
 *
 */
public class User {
	private int u_id;// id（主键）
	private String u_name;// 账号
	private String u_pwd;// 密码
	private String u_sex;// 性别
	private String u_phone;// 电话
	private int pm_id;// 参数表_员工状态ID（外键）
	private String u_null1;// 空字段
	private String code;// 验证码
	private Param param;
	private Staff_rel sf;
	public User() {
		super();
	}

	public User(String u_name, String u_pwd, String u_sex, String u_phone, int pm_id, String u_null1) {
		super();
		this.u_name = u_name;
		this.u_pwd = u_pwd;
		this.u_sex = u_sex;
		this.u_phone = u_phone;
		this.pm_id = pm_id;
		this.u_null1 = u_null1;
	}

	public User(int u_id, String u_name, String u_pwd, String u_sex, String u_phone, int pm_id, String u_null1) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pwd = u_pwd;
		this.u_sex = u_sex;
		this.u_phone = u_phone;
		this.pm_id = pm_id;
		this.u_null1 = u_null1;
	}

	public User(int u_id, String u_name, String u_pwd, String u_sex, String u_phone, int pm_id, String u_null1,
			String code) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pwd = u_pwd;
		this.u_sex = u_sex;
		this.u_phone = u_phone;
		this.pm_id = pm_id;
		this.u_null1 = u_null1;
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_pwd=" + u_pwd + ", u_sex=" + u_sex + ", u_phone="
				+ u_phone + ", pm_id=" + pm_id + ", u_null1=" + u_null1 + ", code=" + code + "]";
	}

	
	
	public Staff_rel getSf() {
		return sf;
	}

	public void setSf(Staff_rel sf) {
		this.sf = sf;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public String getU_null1() {
		return u_null1;
	}

	public void setU_null1(String u_null1) {
		this.u_null1 = u_null1;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
