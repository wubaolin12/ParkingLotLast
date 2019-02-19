package org.great.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 参数表(param)
 * 
 * @author 野比欣之助
 *
 */
@Component
public class Param implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pm_id;// id(主键)
	private String pm_name;// 参数名称
	private String pm_type;// 参数类型

	public Param() {
		super();
	}

	public Param(String pm_name, String pm_type) {
		super();
		this.pm_name = pm_name;
		this.pm_type = pm_type;
	}

	public Param(int pm_id, String pm_name, String pm_type) {
		super();
		this.pm_id = pm_id;
		this.pm_name = pm_name;
		this.pm_type = pm_type;
	}

	@Override
	public String toString() {
		return "Param [pm_id=" + pm_id + ", pm_name=" + pm_name + ", pm_type=" + pm_type + "]";
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public String getPm_name() {
		return pm_name;
	}

	public void setPm_name(String pm_name) {
		this.pm_name = pm_name;
	}

	public String getPm_type() {
		return pm_type;
	}

	public void setPm_type(String pm_type) {
		this.pm_type = pm_type;
	}

}
