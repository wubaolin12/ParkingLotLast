package org.great.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.great.bean.Appointment;
import org.great.bean.Countrules;
import org.great.bean.Park;
import org.great.bean.Receipt;
import org.great.biz.AppointmentBiz;
import org.great.biz.CountrulesBiz;
import org.great.biz.ReceiptBiz;
import org.great.mapper.ParkMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TEst1 {
	
	
	public static void main(String[] args) {
		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
//		AppointmentBiz appointmentBiz = (AppointmentBiz) ct.getBean("appointmentBiz");
//		List<Appointment> appointmentsList =appointmentBiz.findCustCarAppoinmentX(1);
//System.out.println("appointmentsList="+appointmentsList);
				CountrulesBiz countrulesBiz = (CountrulesBiz) ct.getBean("countrulesBiz");
////	/ParkingLot/src/org/great/biz/CountrulesBiz.java
//		Receipt re = new Receipt(1,"%2019-01-22%");
//		 List<Park> list=parkMapper.FindAllCanStopX("开放",9);
//		 System.out.println("list="+list);
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		double m1 = 0;
//		long mm = 0;
		try {
			double m2 = myFormatter.parse("2019-01-21 09:40:03").getTime() - myFormatter.parse("2019-01-21 09:01:40").getTime();
			m1 = m2 / (60 * 60 * 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = (int)(m1+0.5);
		System.out.println("相差时间: " + m1);
		System.out.println("相差时间: " + i);
		int tt = (int) m1;
		System.err.println(tt);
		Map<String, Object> map = new HashMap<String, Object>();
		String time = "" + i;
		System.out.println("time="+time);
		map.put("time", m1);
		map.put("pmtype", "规则状态");
		map.put("pmname", "启用");
		// 查询计费规则
		Countrules countrules = countrulesBiz.findCountrulRoleX(map);
		System.err.println("countrules="+countrules);
		if (countrules == null) {
			countrules = countrulesBiz.findCountrulRoleEqualsX(map);
		}
		System.err.println("countrules="+countrules);
//		Date day=new Date();    
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 12:00:00"); 
//		System.out.println(df.format(day)); 
//		String time = df.format(day);
//		System.out.println("time="+time);
	}
}
