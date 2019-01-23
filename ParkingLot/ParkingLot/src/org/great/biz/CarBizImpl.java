package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Car;
import org.great.bean.Cust;
import org.great.mapper.CarMapper;
import org.springframework.stereotype.Service;

/**
 * 车辆表Impl实现类
 * 
 * @author 健哥
 *
 */
@Service("carBiz")
public class CarBizImpl implements CarBiz {

	@Resource
	private CarMapper carMapper;
	@Resource
	private Car car;
	private boolean flag;// 标记

	// 通过车牌找到车的信息
	@Override
	public Car FindByCarNumber(String number) {

		return carMapper.FindByCarNumber(number);
	}

	// 增加临时车的信息
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

	@Override
	public List<Car> findCustCarX(Cust cust) {
		// TODO Auto-generated method stub
		return carMapper.findCustCarX(cust);
	}

	@Override
	public boolean AddCarCX(Car car) {
		// TODO Auto-generated method stub
		return carMapper.AddCarCX(car);
	}

	@Override
	public boolean chagerPmIDByCarNumberX(Car car) {
		// TODO Auto-generated method stub
		return carMapper.chagerPmIDByCarNumberX(car);
	}

	@Override
	public Car FindVipByCarNumberX(String number) {
		// TODO Auto-generated method stub
		return carMapper.FindVipByCarNumberX(number);
	}

	@Override
	public Car findCustCarNumberByPhoneX(String Number) {
		// TODO Auto-generated method stub
		return carMapper.findCustCarNumberByPhoneX(Number);
	}

	@Override
	public Car findCustCarNumberByCarIDX(int cid) {
		// TODO Auto-generated method stub
		return carMapper.findCustCarNumberByCarIDX(cid);
	}
}
