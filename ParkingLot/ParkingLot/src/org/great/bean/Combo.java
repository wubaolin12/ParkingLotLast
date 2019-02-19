package org.great.bean;

import java.io.Serializable;

/**
 * 套餐表
 * @author 野比欣之助
 *
 */
public class Combo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int co_id;// id(主键)
	private String co_standard;// 套餐规格
	private String co_price;// 套餐价格

	public Combo() {
		super();
	}

	public Combo(String co_standard, String co_price) {
		super();
		this.co_standard = co_standard;
		this.co_price = co_price;
	}

	public Combo(int co_id, String co_standard, String co_price) {
		super();
		this.co_id = co_id;
		this.co_standard = co_standard;
		this.co_price = co_price;
	}

	@Override
	public String toString() {
		return "Combo [co_id=" + co_id + ", co_standard=" + co_standard + ", co_price=" + co_price + "]";
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public String getCo_standard() {
		return co_standard;
	}

	public void setCo_standard(String co_standard) {
		this.co_standard = co_standard;
	}

	public String getCo_price() {
		return co_price;
	}

	public void setCo_price(String co_price) {
		this.co_price = co_price;
	}

}
