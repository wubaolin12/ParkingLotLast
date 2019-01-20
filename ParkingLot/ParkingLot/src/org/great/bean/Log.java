package org.great.bean;

/**
 * 日志表(log)			
 * @author 野比欣之助
 *
 */
public class Log {
	private int log_id;// id(主键)
	private int u_id;// 操作人（外键）
	private String log_date;// 操作时间
	private String log_event;// 事件

	public Log() {
		super();
	}

	public Log(int u_id, String log_date, String log_event) {
		super();
		this.u_id = u_id;
		this.log_date = log_date;
		this.log_event = log_event;
	}

	public Log(int log_id, int u_id, String log_date, String log_event) {
		super();
		this.log_id = log_id;
		this.u_id = u_id;
		this.log_date = log_date;
		this.log_event = log_event;
	}

	@Override
	public String toString() {
		return "Log [log_id=" + log_id + ", u_id=" + u_id + ", log_date=" + log_date + ", log_event=" + log_event + "]";
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getLog_date() {
		return log_date;
	}

	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}

	public String getLog_event() {
		return log_event;
	}

	public void setLog_event(String log_event) {
		this.log_event = log_event;
	}

}
