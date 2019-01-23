package org.great.bean;
/*
 * 宏琪大哥
 * 车位详细信息类
 */
public class ParkInfo {
	private Park park;
	private Car car;
	private Param param;
	
	public ParkInfo() {
		super();
	}

	public ParkInfo(Park park, Car car, Param param) {
		super();
		this.park = park;
		this.car = car;
		this.param = param;
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
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
		return "ParkInfo [park=" + park + ", car=" + car + ", param=" + param + "]";
	}
	
	
}
