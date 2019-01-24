package org.great.bean;

/**
 * 车辆套餐表(tb_vip)							
 * @author 野比欣之助
 *
 */
public class Vip {

	private int v_id;// id(主键)
	private int co_id;// 套餐表ID（外键）
	private int c_id;// 车辆ID（外键）
	private String v_starttime;// 开始服务时间
	private String v_overtime;// 结束服务时间
	private int pm_id;// 月缴状态

	public Vip() {
		super();
	}

	public Vip(int v_id, String v_overtime) {
		super();
		this.v_id = v_id;
		this.v_overtime = v_overtime;
	}

	public Vip(int co_id, int c_id, String v_starttime, String v_overtime) {
		super();
		this.co_id = co_id;
		this.c_id = c_id;
		this.v_starttime = v_starttime;
		this.v_overtime = v_overtime;
	}

	public Vip(int co_id, int c_id, String v_starttime, String v_overtime, int pm_id) {
		super();
		this.co_id = co_id;
		this.c_id = c_id;
		this.v_starttime = v_starttime;
		this.v_overtime = v_overtime;
		this.pm_id = pm_id;
	}

	public Vip(int v_id, int co_id, int c_id, String v_starttime, String v_overtime) {
		super();
		this.v_id = v_id;
		this.co_id = co_id;
		this.c_id = c_id;
		this.v_starttime = v_starttime;
		this.v_overtime = v_overtime;
	}

	public Vip(int v_id, int co_id, int c_id, String v_starttime, String v_overtime, int pm_id) {
		super();
		this.v_id = v_id;
		this.co_id = co_id;
		this.c_id = c_id;
		this.v_starttime = v_starttime;
		this.v_overtime = v_overtime;
		this.pm_id = pm_id;
	}

	@Override
	public String toString() {
		return "Vip [v_id=" + v_id + ", co_id=" + co_id + ", c_id=" + c_id + ", v_starttime=" + v_starttime
				+ ", v_overtime=" + v_overtime + ", pm_id=" + pm_id + "]";
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getV_starttime() {
		return v_starttime;
	}

	public void setV_starttime(String v_starttime) {
		this.v_starttime = v_starttime;
	}

	public String getV_overtime() {
		return v_overtime;
	}

	public void setV_overtime(String v_overtime) {
		this.v_overtime = v_overtime;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

}
