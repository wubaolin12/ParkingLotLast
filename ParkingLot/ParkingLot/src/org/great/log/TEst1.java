package org.great.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.great.bean.Appointment;
import org.great.bean.Countrules;
import org.great.bean.Param;
import org.great.bean.Park;
import org.great.bean.Receipt;
import org.great.bean.Stopcartime;
import org.great.biz.AppointmentBiz;
import org.great.biz.CountrulesBiz;
import org.great.biz.ParamBiz;
import org.great.biz.ParkBiz;
import org.great.biz.ReceiptBiz;
import org.great.biz.StopcartimeBiz;
import org.great.mapper.ParkMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TEst1 {
	public static long fromDateStringToLong(String inVal) { // 此方法计算时间毫秒
		Date date = null; // 定义时间类型
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
		date = inputFormat.parse(inVal); // 将字符型转换成日期型
		} catch (Exception e) {
		e.printStackTrace();
		}
		return date.getTime(); // 返回毫秒数
		}

	public static void main(String[] args) {

//		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		double m1 = 0;
//		String oTime = "2019-02-15 14:57:41";
//		String fTime = "2019-02-15 12:55:43";
//		try {
//			double m2 = myFormatter.parse(oTime).getTime() - myFormatter.parse(fTime).getTime();
//			m1 = m2 / (60 * 60 * 1000);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("相差时间: " + m1);

//		Date day = new Date();
//		int time2 = 15;
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd " + time2 + ":00:00");
//		if(time2<10) {
//			 df = new SimpleDateFormat("yyyy-MM-dd " + "0"+time2 + ":00:00");
//		}else {
//			 df = new SimpleDateFormat("yyyy-MM-dd " + time2 + ":00:00");
//		}
//		String time = df.format(day);
//		System.out.println("time="+time);
		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
//		StopcartimeBiz stopcartimeBiz = (StopcartimeBiz) ct.getBean("stopcartimeBiz");
		ParkBiz parkBiz = (ParkBiz) ct.getBean("parkBiz");
//		Param par = new Param("停车结束", "停车状态");
//		Param par1 = paramBiz.GetPmIDByTypeNmaeX(par);
//		System.err.println(par1);
//		Stopcartime sct12 = stopcartimeBiz.FindByCarIDX(37, par1.getPm_id());
//		System.out.println("sct12=" + sct12);
//		List<Appointment> appointmentsList =appointmentBiz.findCustCarAppoinmentX(1);
//System.out.println("appointmentsList="+appointmentsList);
//				CountrulesBiz countrulesBiz = (CountrulesBiz) ct.getBean("countrulesBiz");
////	/ParkingLot/src/org/great/biz/CountrulesBiz.java
//		Receipt re = new Receipt(1,"%2019-01-22%");
		
		
		
//		for (int i = 0; i < args.length; i++) {
//		Park park = new Park();
//		 boolean flag =parkBiz.AddPark(park);
//		}
//		 System.out.println("list="+list);
//		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		double m1 = 0;
//		long mm = 0;
//		try {
//			double m2 = myFormatter.parse("2019-01-21 09:40:03").getTime() - myFormatter.parse("2019-01-21 09:01:40").getTime();
//			m1 = m2 / (60 * 60 * 1000);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int i = (int)(m1+0.5);
//		System.out.println("相差时间: " + m1);
//		System.out.println("相差时间: " + i);
//		int tt = (int) m1;
//		System.err.println(tt);
//		Map<String, Object> map = new HashMap<String, Object>();
//		String time = "" + i;
//		System.out.println("time="+time);
//		map.put("time", m1);
//		map.put("pmtype", "规则状态");
//		map.put("pmname", "启用");
//		// 查询计费规则
//		Countrules countrules = countrulesBiz.findCountrulRoleX(map);
//		System.err.println("countrules="+countrules);
//		if (countrules == null) {
//			countrules = countrulesBiz.findCountrulRoleEqualsX(map);
//		}
//		System.err.println("countrules="+countrules);
//		Date day=new Date();    
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 12:00:00"); 
//		System.out.println(df.format(day)); 
//		String time = df.format(day);
//		System.out.println("time="+time);
	}
}
