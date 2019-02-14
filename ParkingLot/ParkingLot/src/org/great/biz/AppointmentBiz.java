package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.Appointment;
/**
 *预约停车的预约表biz接口
 * @author 野比欣之助
 *
 */
public interface AppointmentBiz {
	/** 根据用户ID查询该用户名下预约信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Appointment> findCustCarAppoinmentX(int cust_id);
	/**添加预约记录
	 * 
	 * @param appointment
	 * @return
	 */
	public boolean AddAppointmentX(Appointment appointment);
	/**
	 * 删除一条预约表记录根据车牌号
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
