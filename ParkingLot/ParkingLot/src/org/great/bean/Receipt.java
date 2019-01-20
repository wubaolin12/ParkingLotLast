package org.great.bean;

/**
 * 收支明细表(tb_receipt)							
 * @author 野比欣之助
 *
 */
public class Receipt {
	private int re_id;// id(主键)
	private int u_id;// 执行人ID（外键）
	private int c_id;// 车ID（外键）
	private String re_thing;// 事件
	private int re_money;// 金额
	private String re_null1;// 空字段
	private String re_null2;// 空字段
	private String re_null3;// 空字段

	public Receipt() {
		super();
	}

	public Receipt(int u_id, int c_id, String re_thing, int re_money, String re_null1, String re_null2,
			String re_null3) {
		super();
		this.u_id = u_id;
		this.c_id = c_id;
		this.re_thing = re_thing;
		this.re_money = re_money;
		this.re_null1 = re_null1;
		this.re_null2 = re_null2;
		this.re_null3 = re_null3;
	}

	public Receipt(int re_id, int u_id, int c_id, String re_thing, int re_money, String re_null1, String re_null2,
			String re_null3) {
		super();
		this.re_id = re_id;
		this.u_id = u_id;
		this.c_id = c_id;
		this.re_thing = re_thing;
		this.re_money = re_money;
		this.re_null1 = re_null1;
		this.re_null2 = re_null2;
		this.re_null3 = re_null3;
	}

	@Override
	public String toString() {
		return "Receipt [re_id=" + re_id + ", u_id=" + u_id + ", c_id=" + c_id + ", re_thing=" + re_thing
				+ ", re_money=" + re_money + ", re_null1=" + re_null1 + ", re_null2=" + re_null2 + ", re_null3="
				+ re_null3 + "]";
	}

	public int getRe_id() {
		return re_id;
	}

	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getRe_thing() {
		return re_thing;
	}

	public void setRe_thing(String re_thing) {
		this.re_thing = re_thing;
	}

	public int getRe_money() {
		return re_money;
	}

	public void setRe_money(int re_money) {
		this.re_money = re_money;
	}

	public String getRe_null1() {
		return re_null1;
	}

	public void setRe_null1(String re_null1) {
		this.re_null1 = re_null1;
	}

	public String getRe_null2() {
		return re_null2;
	}

	public void setRe_null2(String re_null2) {
		this.re_null2 = re_null2;
	}

	public String getRe_null3() {
		return re_null3;
	}

	public void setRe_null3(String re_null3) {
		this.re_null3 = re_null3;
	}

}
