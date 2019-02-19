package org.great.bean;

import java.io.Serializable;

/**
 * 排班表(tb_sche)			
 * @author 野比欣之助
 *
 */
public class Sche implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int s_id;// id（主键）
	private int ss_id;// 排班参数ID（外键）
	private int u_id;// 工作人员（外键）
	private String s_date;// 工作日期
	private Schestate sstate;

	public Sche() {
		super();
	}

	public Sche(int ss_id, int u_id, String s_date) {
		super();
		this.ss_id = ss_id;
		this.u_id = u_id;
		this.s_date = s_date;
	}

	public Sche(int s_id, int ss_id, int u_id, String s_date) {
		super();
		this.s_id = s_id;
		this.ss_id = ss_id;
		this.u_id = u_id;
		this.s_date = s_date;
	}



	
	
	@Override
	public String toString() {
		return "Sche [s_id=" + s_id + ", ss_id=" + ss_id + ", u_id=" + u_id + ", s_date=" + s_date + ", sstate="
				+ sstate + "]";
	}

	public Schestate getSstate() {
		return sstate;
	}

	public void setSstate(Schestate sstate) {
		this.sstate = sstate;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getSs_id() {
		return ss_id;
	}

	public void setSs_id(int ss_id) {
		this.ss_id = ss_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

}
