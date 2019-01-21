package org.great.biz;

import org.great.bean.Car;

/**
 * 车辆表BIZ
 * @author 野比欣之助
 *
 */
public interface CarBiz {

	
	//通过车牌找到车辆信息
	public Car FindByCarNumber(String number);
	
	//车辆入场时增加临时车辆
	public boolean AddCarMsg(String number);
}
