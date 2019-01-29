package org.great.bean.vo;
/**一个什么都可以放的杂类
 * 
 * @author 野比欣之助
 *
 */
public class AnyX {
	String cust_phone;
	String carnum;
	String adminRole;
	String pm_id;

	public AnyX() {
		super();
	}

	public AnyX(String cust_phone, String carnum, String adminRole) {
		super();
		this.cust_phone = cust_phone;
		this.carnum = carnum;
		this.adminRole = adminRole;
	}

	public AnyX(String cust_phone, String carnum, String adminRole, String pm_id) {
		super();
		this.cust_phone = cust_phone;
		this.carnum = carnum;
		this.adminRole = adminRole;
		this.pm_id = pm_id;
	}

	@Override
	public String toString() {
		return "AnyX [cust_phone=" + cust_phone + ", carnum=" + carnum + ", adminRole=" + adminRole + ", pm_id=" + pm_id
				+ "]";
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	public String getPm_id() {
		return pm_id;
	}

	public void setPm_id(String pm_id) {
		this.pm_id = pm_id;
	}

}
