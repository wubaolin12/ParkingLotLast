package org.great.bean;

/**
 * 停车时间表（tb_stopcartime）								
 * @author 野比欣之助
 *
 */
public class Stopcartime {
	private int sct_id;// id(主键)
	private int c_id;// 车ID（外键）
	private int pm_id;// 停车状态（外键）
	private String sct_starttime;// 开始时间
	private String sct_overtime;// 结束时间
	private int sct_money;// 金额

	public Stopcartime() {
		super();
	}

	public Stopcartime(int sct_id, int sct_money) {
		super();
		this.sct_id = sct_id;
		this.sct_money = sct_money;
	}

	public Stopcartime(int c_id, int pm_id, String sct_starttime, String sct_overtime, int sct_money) {
		super();
		this.c_id = c_id;
		this.pm_id = pm_id;
		this.sct_starttime = sct_starttime;
		this.sct_overtime = sct_overtime;
		this.sct_money = sct_money;
	}

	public Stopcartime(int sct_id, int c_id, int pm_id, String sct_starttime, String sct_overtime, int sct_money) {
		super();
		this.sct_id = sct_id;
		this.c_id = c_id;
		this.pm_id = pm_id;
		this.sct_starttime = sct_starttime;
		this.sct_overtime = sct_overtime;
		this.sct_money = sct_money;
	}
	
	
	public Stopcartime(int c_id, String sct_starttime) {
		super();
		this.c_id = c_id;
		this.sct_starttime = sct_starttime;
	}


	public Stopcartime(int pm_id, String sct_overtime, int sct_id) {
		super();
		this.pm_id = pm_id;
		this.sct_overtime = sct_overtime;
		this.sct_id = sct_id;
	}

	@Override
	public String toString() {
		return "Stopcartime [sct_id=" + sct_id + ", c_id=" + c_id + ", pm_id=" + pm_id + ", sct_starttime="
				+ sct_starttime + ", sct_overtime=" + sct_overtime + ", sct_money=" + sct_money + "]";
	}

	public int getSct_id() {
		return sct_id;
	}

	public void setSct_id(int sct_id) {
		this.sct_id = sct_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public String getSct_starttime() {
		return sct_starttime;
	}

	public void setSct_starttime(String sct_starttime) {
		this.sct_starttime = sct_starttime;
	}

	public String getSct_overtime() {
		return sct_overtime;
	}

	public void setSct_overtime(String sct_overtime) {
		this.sct_overtime = sct_overtime;
	}

	public int getSct_money() {
		return sct_money;
	}

	public void setSct_money(int sct_money) {
		this.sct_money = sct_money;
	}

}
