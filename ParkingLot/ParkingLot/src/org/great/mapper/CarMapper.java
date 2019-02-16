package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Car;
import org.great.bean.Cust;
import org.springframework.stereotype.Repository;

/**
 * 车辆表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface CarMapper {

	// 通过车牌找到车辆信息
	public Car FindByCarNumber(String number);

	// 车辆入场时增加临时车辆
	public int AddCarMsg(String number);

	/**
	 * 增加车辆信息
	 * 
	 * @param car
	 * @return
	 */
	public boolean AddCarCX(Car car);

	/**
	 * 根据车牌号更改车辆角色
	 * 
	 * @param car
	 * @return
	 */
	public boolean chagerPmIDByCarNumberX(Car car);

	/**
	 * 根据手机号查询该用户名下车辆信息
	 * 
	 * @param Pnumber
	 * @return
	 */
	public List<Car> findCustCarX(Cust cust);

	/**
	 * 通过车牌找到车Vip表信息
	 * 
	 * @param cust
	 * @return
	 */
	public Car FindVipByCarNumberX(String number);

	/**
	 * 根据手机号查询该用户名下有无该车牌号车辆信息车辆信息
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

	/**
	 * 根据手机号查询该用户名下车辆VIP信息
	 * 
	 * @param cust
	 * @return
	 */
	public List<Car> findCustCarVipStateX(@Param("cust_phone") String cust_phone, @Param("cpm_id") int cpm_id,
			@Param("pm_type") String pm_type, @Param("pm_name") String pm_name);

	/**
	 * 根据车牌号号查询车辆VIP信息
	 * 
	 * @return
	 */
	public List<Car> findCarVipStateX(String cust_phone);

	/**
	 * 通过用户CustID找到车信息
	 */
	public List<Car> FindByCarcustidX(int number);

	/**
	 * 根据车牌号更改车辆角色和车主ID
	 * 
	 * @return
	 */
	public boolean chagerPmIDCustIDByCarNumberX(Car car);

	/**
	 * 根据车牌号更改车主ID 主要是设为空 取消绑定的-
	 * 
	 * @param car
	 * @return
	 */
	public boolean chagerCustIDNULLByCarNumberX(@Param("c_num") String c_num, @Param("pm_id") int pm_id);

	/**
	 * 通过用户CarID找到车信息
	 * 
	 * @param c_num
	 * @param pm_id
	 * @return
	 */
	public List<Car> FindCarByCaridX(String c_num);

	/**
	 * 通过车牌找到车Vip表信息 18 待生效
	 * 
	 * @param number
	 * @return
	 */
	public Car FindVipByCarNumber18X(String number);

}
