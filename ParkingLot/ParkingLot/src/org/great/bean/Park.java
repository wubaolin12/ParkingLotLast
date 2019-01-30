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
	private String p_state;// 维护状态  ，有“维护”、“开放”
	private String p_mapid;// 地图id
	private String p_imgpath;// 图片地址
	private Car car;
	private Param param;
	private String c_num;
	public Park() {
		super();
	}
	public Park(int pm_id, String p_fore, int p_num, String p_state) {
		super();
		this.pm_id = pm_id;
		this.p_fore = p_fore;
		this.p_num = p_num;
		this.p_state = p_state;
	}
	
	public Park(int p_id, String p_state) {
		super();
		this.p_id = p_id;
		this.p_state = p_state;
	}
	public Park(int p_id, int pm_id, int c_id, String p_fore, int p_num, String p_state, String p_mapid,
			String p_imgpath) {
		super();
		this.p_id = p_id;
		this.pm_id = pm_id;
		this.c_id = c_id;
		this.p_fore = p_fore;
		this.p_num = p_num;
		this.p_state = p_state;
		this.p_mapid = p_mapid;
		this.p_imgpath = p_imgpath;
	}
	
	public Park(int pm_id, String p_fore, int p_num, String p_state, String c_num) {
		super();
		this.pm_id = pm_id;
		this.p_fore = p_fore;
		this.p_num = p_num;
		this.p_state = p_state;
		this.c_num = c_num;
	}
	public Park(int p_id, int pm_id, int c_id, String p_fore, int p_num, String p_state, String p_mapid, String p_imgpath,
			Car car, Param param, String c_num) {
		super();
		this.p_id = p_id;
		this.pm_id = pm_id;
		this.c_id = c_id;
		this.p_fore = p_fore;
		this.p_num = p_num;
		this.p_state = p_state;
		this.p_mapid = p_mapid;
		this.p_imgpath = p_imgpath;
		this.car = car;
		this.param = param;
		this.c_num = c_num;
	}
	
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
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
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	public String getP_mapid() {
		return p_mapid;
	}
	public void setP_mapid(String p_mapid) {
		this.p_mapid = p_mapid;
	}
	public String getP_imgpath() {
		return p_imgpath;
	}
	public void setP_imgpath(String p_imgpath) {
		this.p_imgpath = p_imgpath;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Param getParam() {
		return param;
	}
	public void setParam(Param param) {
		this.param = param;
	}
	@Override
	public String toString() {
		return "Park [p_id=" + p_id + ", pm_id=" + pm_id + ", c_id=" + c_id + ", p_fore=" + p_fore + ", p_num=" + p_num
				+ ", p_state=" + p_state + ", p_mapid=" + p_mapid + ", p_imgpath=" + p_imgpath + ", car=" + car + ", param="
				+ param + ", c_num=" + c_num + "]";
	}
	
	
}
