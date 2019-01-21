package org.great.biz;

import javax.annotation.Resource;

import org.great.bean.Car;
import org.great.mapper.CarMapper;
import org.springframework.stereotype.Service;

/**
 * 车辆表Impl实现类
 * @author 健哥
 *
 */
@Service("carBiz")
public class CarBizImpl implements CarBiz{

	@Resource
	private CarMapper carMapper;
	@Resource
	private Car car;
	private boolean flag;//标记
	
	//通过车牌找到车的信息
	@Override
	public Car FindByCarNumber(String number) {
	
		return carMapper.FindByCarNumber(number);
	}

	//增加临时车的信息
	@Override
	public boolean AddCarMsg(String number) {
		
		int count = carMapper.AddCarMsg(number);
		
		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}
}
