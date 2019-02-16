package org.great.bean;

/**
 * 计费规则表(tb_countrules)				
 * @author 野比欣之助
 *
 */
public class Countrules {
	private int cr_id;// id(主键)
	private int pm_id;// 规则类型
	private double cr_starttime;// 开始时间
	private double cr_overtime;// 结束时间
	private int cr_fristmoney;// 起步价
	private int cr_addmoney;// 自增价格
	private int crpm_id;// 规则状态

	public Countrules() {
		super();
	}

	public Countrules(int cr_id, double cr_starttime, double cr_overtime, int cr_fristmoney, int cr_addmoney) {
		super();
		this.cr_id = cr_id;
		this.cr_starttime = cr_starttime;
		this.cr_overtime = cr_overtime;
		this.cr_fristmoney = cr_fristmoney;
		this.cr_addmoney = cr_addmoney;
	}

	public Countrules(int cr_id, int pm_id, double cr_starttime, double cr_overtime, int cr_fristmoney,
			int cr_addmoney) {
		super();
		this.cr_id = cr_id;
		this.pm_id = pm_id;
		this.cr_starttime = cr_starttime;
		this.cr_overtime = cr_overtime;
		this.cr_fristmoney = cr_fristmoney;
		this.cr_addmoney = cr_addmoney;
	}



	public Countrules(int cr_id, int pm_id, double cr_starttime, double cr_overtime, int cr_fristmoney, int cr_addmoney,
			int crpm_id) {
		super();
		this.cr_id = cr_id;
		this.pm_id = pm_id;
		this.cr_starttime = cr_starttime;
		this.cr_overtime = cr_overtime;
		this.cr_fristmoney = cr_fristmoney;
		this.cr_addmoney = cr_addmoney;
		this.crpm_id = crpm_id;
	}



	@Override
	public String toString() {
		return "Countrules [cr_id=" + cr_id + ", pm_id=" + pm_id + ", cr_starttime=" + cr_starttime + ", cr_overtime="
				+ cr_overtime + ", cr_fristmoney=" + cr_fristmoney + ", cr_addmoney=" + cr_addmoney + ", crpm_id="
				+ crpm_id + "]";
	}

	public int getCr_id() {
		return cr_id;
	}

	public void setCr_id(int cr_id) {
		this.cr_id = cr_id;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}


	public int getCr_fristmoney() {
		return cr_fristmoney;
	}

	public void setCr_fristmoney(int cr_fristmoney) {
		this.cr_fristmoney = cr_fristmoney;
	}

	public int getCr_addmoney() {
		return cr_addmoney;
	}

	public void setCr_addmoney(int cr_addmoney) {
		this.cr_addmoney = cr_addmoney;
	}

	public int getCrpm_id() {
		return crpm_id;
	}

	public void setCrpm_id(int crpm_id) {
		this.crpm_id = crpm_id;
	}



	public double getCr_starttime() {
		return cr_starttime;
	}



	public void setCr_starttime(double cr_starttime) {
		this.cr_starttime = cr_starttime;
	}



	public double getCr_overtime() {
		return cr_overtime;
	}



	public void setCr_overtime(double cr_overtime) {
		this.cr_overtime = cr_overtime;
	}

}
