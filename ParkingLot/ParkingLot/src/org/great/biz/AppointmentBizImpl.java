package org.great.biz;
/**
 * 
 * 通用biz实现类，提供通用的业务方法，如增、删、改等操作
 * @author Yf
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.Appointment;
import org.great.mapper.AppointmentMapper;
import org.great.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service("appointmentBiz")
public class AppointmentBizImpl implements AppointmentBiz {
	@Resource
	private AppointmentMapper appointmentMapper;

	@Override
	public boolean AddAppointmentX(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentMapper.AddAppointmentX(appointment);
	}

	@Override
	public List<Appointment> findCustCarAppoinmentX(int cust_id) {
		// TODO Auto-generated method stub
		return appointmentMapper.findCustCarAppoinmentX(cust_id);
	}

	@Override
	public boolean delAppointmentByCnumX(String c_num) {
		// TODO Auto-generated method stub
		return appointmentMapper.delAppointmentByCnumX(c_num);
	}

	@Override
	public List<Appointment> findCarAppoinmentX() {
		// TODO Auto-generated method stub
		return appointmentMapper.findCarAppoinmentX();
	}

	@Override
	public List<Appointment> findCarAppoinmentByCarIDX(int c_id) {
		// TODO Auto-generated method stub
		return appointmentMapper.findCarAppoinmentByCarIDX(c_id);
	}

}
