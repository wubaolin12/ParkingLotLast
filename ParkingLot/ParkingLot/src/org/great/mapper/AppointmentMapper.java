package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Appointment;
import org.great.bean.Car;
import org.great.bean.Cust;
import org.springframework.stereotype.Repository;

/**
 * 预约停车的预约表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface AppointmentMapper {

	/*
	 * 添加预约记录
	 */
	public boolean AddAppointmentX(Appointment appointment);

	/*
	 * 根据用户ID查询该用户名下预约信息
	 */
	public List<Appointment> findCustCarAppoinmentX(int id);

	/**
	 * 删除一条预约表记录根据车牌号
	 * 
	 * @param appointment
	 * @return
	 */
	public boolean delAppointmentByCnumX(String c_num);

	/**
	 * 查询所有预约记录
	 * 
	 * @param id
	 * @return
	 */
	public List<Appointment> findCarAppoinmentX();

	/**
	 * 查询一条预约记录根据车ID
	 * 
	 * @return
	 */
	public List<Appointment> findCarAppoinmentByCarIDX(int c_id);
}
