package org.great.bean;

/**
 * 车位表(tb_park)							
 * @author 野比欣之助
 *
 */
public class Park {
	private int p_id;// id(主键)
	private int pm_id;// 车位状态ID（外键）
	private int c_id;// 车辆ID（外键）
	private String p_fore;// 车位前缀
	private int p_num;// 车位号码
	private String p_null1;// 空字段
	private String p_null2;// 空字段
	private String p_null3;// 空字段

	public Park() {
		super();
	}

	public Park(int pm_id, int c_id, String p_fore, int p_num, String p_null1, String p_null2, String p_null3) {
		super();
		this.pm_id = pm_id;
		this.c_id = c_id;
		this.p_fore = p_fore;
		this.p_num = p_num;
		this.p_null1 = p_null1;
		this.p_null2 = p_null2;
		this.p_null3 = p_null3;
	}

	public Park(int p_id, int pm_id, int c_id, String p_fore, int p_num, String p_null1, String p_null2,
			String p_null3) {
		super();
		this.p_id = p_id;
		this.pm_id = pm_id;
		this.c_id = c_id;
		this.p_fore = p_fore;
		this.p_num = p_num;
		this.p_null1 = p_null1;
		this.p_null2 = p_null2;
		this.p_null3 = p_null3;
	}

	@Override
	public String toString() {
		return "Park [p_id=" + p_id + ", pm_id=" + pm_id + ", c_id=" + c_id + ", p_fore=" + p_fore + ", p_num=" + p_num
				+ ", p_null1=" + p_null1 + ", p_null2=" + p_null2 + ", p_null3=" + p_null3 + "]";
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getP_fore() {
		return p_fore;
	}

	public void setP_fore(String p_fore) {
		this.p_fore = p_fore;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_null1() {
		return p_null1;
	}

	public void setP_null1(String p_null1) {
		this.p_null1 = p_null1;
	}

	public String getP_null2() {
		return p_null2;
	}

	public void setP_null2(String p_null2) {
		this.p_null2 = p_null2;
	}

	public String getP_null3() {
		return p_null3;
	}

	public void setP_null3(String p_null3) {
		this.p_null3 = p_null3;
	}

}
