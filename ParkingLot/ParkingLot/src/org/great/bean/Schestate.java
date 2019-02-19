package org.great.bean;

import java.io.Serializable;

/**
 * 排班参数表(tb_scheState)			
 * @author 野比欣之助
 *
 */
public class Schestate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int ss_id;// id（主键）
	String ss_name;// 班次名称
	String ss_starttime;// 开始时间
	String ss_overtime;// 结束时间

	public Schestate() {
		super();
	}

	public Schestate(String ss_name, String ss_starttime, String ss_overtime) {
		super();
		this.ss_name = ss_name;
		this.ss_starttime = ss_starttime;
		this.ss_overtime = ss_overtime;
	}

	public Schestate(int ss_id, String ss_name, String ss_starttime, String ss_overtime) {
		super();
		this.ss_id = ss_id;
		this.ss_name = ss_name;
		this.ss_starttime = ss_starttime;
		this.ss_overtime = ss_overtime;
	}

	@Override
	public String toString() {
		return "Schestate [ss_id=" + ss_id + ", ss_name=" + ss_name + ", ss_starttime=" + ss_starttime
				+ ", ss_overtime=" + ss_overtime + "]";
	}

	public int getSs_id() {
		return ss_id;
	}

	public void setSs_id(int ss_id) {
		this.ss_id = ss_id;
	}

	public String getSs_name() {
		return ss_name;
	}

	public void setSs_name(String ss_name) {
		this.ss_name = ss_name;
	}

	public String getSs_starttime() {
		return ss_starttime;
	}

	public void setSs_starttime(String ss_starttime) {
		this.ss_starttime = ss_starttime;
	}

	public String getSs_overtime() {
		return ss_overtime;
	}

	public void setSs_overtime(String ss_overtime) {
		this.ss_overtime = ss_overtime;
	}

}
