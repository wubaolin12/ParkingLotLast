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

	@Override
	public List<Car> findCustCarVipStateX(String cust_phone, int cpm_id, String pm_type, String pm_name) {
		// TODO Auto-generated method stub
		return carMapper.findCustCarVipStateX(cust_phone, cpm_id, pm_type, pm_name);
	}

	@Override
	public List<Car> findCarVipStateX(String cust_phone) {
		// TODO Auto-generated method stub
		return carMapper.findCarVipStateX(cust_phone);
	}

	@Override
	public List<Car> FindByCarcustidX(int number) {
		// TODO Auto-generated method stub
		return carMapper.FindByCarcustidX(number);
	}

	@Override
	public boolean chagerPmIDCustIDByCarNumberX(Car car) {
		// TODO Auto-generated method stub
		return carMapper.chagerPmIDCustIDByCarNumberX(car);
	}

	@Override
	public boolean chagerCustIDNULLByCarNumberX(String c_num, int pm_id) {
		// TODO Auto-generated method stub
		return carMapper.chagerCustIDNULLByCarNumberX(c_num, pm_id);
	}

	@Override
	public List<Car> FindCarByCaridX(String c_num) {
		// TODO Auto-generated method stub
		return carMapper.FindCarByCaridX(c_num);
	}

	@Override
	public Car FindVipByCarNumber18X(String number) {
		// TODO Auto-generated method stub
		return carMapper.FindVipByCarNumber18X(number);
	}

	@Override
	public boolean updatePic(Car car) {
		
		flag = carMapper.updatePic(car);
		return flag;
	}
	
	@Override
	public List<Car> FindCarRoleByCarNumberPmtypeNameX(String number, String pm_type, String pm_name) {
		// TODO Auto-generated method stub
		return carMapper.FindCarRoleByCarNumberPmtypeNameX(number, pm_type, pm_name);
	}

	@Override
	public boolean chagerCustIDByCarNumberX(String c_num, int cust_id) {
		// TODO Auto-generated method stub
		return carMapper.chagerCustIDByCarNumberX(c_num, cust_id);
	}

	@Override
	public List<Car> findCarVipStatebyCarIDCustPhoneX(String c_num, String cust_phone) {
		// TODO Auto-generated method stub
		return carMapper.findCarVipStatebyCarIDCustPhoneX(c_num, cust_phone);
	}
}
