package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Car;
import org.great.bean.Cust;
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
	/**增加车辆信息
	 * 
	 * @param car
	 * @return
	 */
	public boolean AddCarCX(Car car);
	/**根据车牌号更改车辆角色
	 * 
	 * @param car
	 * @return
	 */
	public boolean chagerPmIDByCarNumberX(Car car);
	/**根据手机号查询该用户名下车辆信息
	 * 
	 * @param Pnumber
	 * @return
	 */
	public List<Car> findCustCarX(Cust cust);

	/**通过车牌找到车Vip表信息
	 * 
	 * @param cust
	 * @return
	 */
	public Car FindVipByCarNumberX(String number);
	
	/**根据手机号查询该用户名下有无该车牌号车辆信息车辆信息
	 * 
	 * @param number
	 * @return
	 */
	public Car findCustCarNumberByPhoneX(String Number);

	/**
	 * 根据车ID查询车辆信息和用户信息
	 * 
	 * @param cid
	 * @return
	 */
	public Car findCustCarNumberByCarIDX(int cid);
}
