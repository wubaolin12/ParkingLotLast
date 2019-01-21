package org.great.mapper;

import org.great.bean.Car;
import org.springframework.stereotype.Repository;

/**
 *	 车辆表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface CarMapper {


	//通过车牌找到车辆信息
	public Car FindByCarNumber(String number);
	
	//车辆入场时增加临时车辆
	public int AddCarMsg(String number);
}
