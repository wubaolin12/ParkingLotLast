package org.great.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.great.bean.Appointment;
import org.great.bean.Car;
import org.great.bean.Countrules;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.bean.Park;
import org.great.bean.Receipt;
import org.great.bean.Stopcartime;
import org.great.bean.Vip;
import org.great.biz.AppointmentBiz;
import org.great.biz.CarBiz;
import org.great.biz.CountrulesBiz;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.great.biz.ParkBiz;
import org.great.biz.ReceiptBiz;
import org.great.biz.StopcartimeBiz;
import org.great.biz.VipBiz;
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
		CarBiz carBiz = (CarBiz) ct.getBean("carBiz");
		ParamBiz paramBiz = (ParamBiz) ct.getBean("paramBiz");
		CustBiz custBiz = (CustBiz) ct.getBean("custBiz");
		VipBiz vipBiz = (VipBiz) ct.getBean("vipBiz");
		int money = 10;
		//判断是否要交钱的FLAG true 为要交钱， false为不用
		boolean flag = true;
		Param param = new Param("白名单", "车辆角色");
		Param param1 = paramBiz.GetPmIDByTypeNmaeX(param);
		Param param2 = new Param("注册会员", "车辆角色");
		Param param22 = paramBiz.GetPmIDByTypeNmaeX(param2);
		Param param3 = new Param("包月套餐", "车辆角色");
		Param param33 = paramBiz.GetPmIDByTypeNmaeX(param3);
		Param param4 = new Param("临时车辆", "车辆角色");
		Param param44 = paramBiz.GetPmIDByTypeNmaeX(param4);
		// 查找该车牌是否已经有记录
		Car car1 = carBiz.FindByCarNumber("沪A168T1");
		System.out.println("查询车辆信息" + car1);
		// 查询是否为白名单
		if (car1.getPm_id() == param1.getPm_id()) {
			System.out.println("-------这货是白名单，放他走!!!-------");
			flag = false;
		} //查询是否为注册车辆
		else if (car1.getPm_id() == param22.getPm_id()) {
			Car car2 = carBiz.findCustCarNumberByCarIDX(car1.getC_id());
			List<Vip> Viplist = vipBiz.findVipX(car1.getC_id());// 宏琪 改了此处 car1.getC_id() 原来为20
//			查询是否曾经是月缴会员
			if (Viplist != null && Viplist.size() != 0) {
				System.out.println("-------这货曾经是月缴会员快提醒他续费充值!!!-------");
			} else {
				System.out.println("-------这货没充过月缴会员，你也可以提醒他充值哦!!!-------");
			}
			if (car2.getCust().getCust_money() >= money) {
				int money2 = car2.getCust().getCust_money() - money;
				Cust cust = new Cust(car2.getCust().getCust_id(), money2);
				boolean flag2 = custBiz.chageCustMoneyByIDX(cust);
				System.out.println("flag2=" + flag2);
				if (flag2 == true) {
					flag = true;
					System.out.println("-------这货是注册会员卡里有钱自动扣掉，放他走!!!-------");
				} else {
					flag = false;
					System.out.println("-------这货是注册会员卡里有钱自动扣掉的时候发生了以外，扣除失败了!!!-------");
				}
			} else {
				flag = false;
				System.out.println("-------这货是注册会员卡里钱不够 ，不放!!!-------");
			}
		}//判断是否月缴车辆 
		else if (car1.getPm_id() == param33.getPm_id()) {
			
			Param param5 = new Param("待生效", "月缴状态");
			Param param55 = paramBiz.GetPmIDByTypeNmaeX(param5);
			Car car2 = carBiz.findCustCarNumberByCarIDX(car1.getC_id());
			List<Vip> Viplist1 = vipBiz.findVipX(car2.getC_id());
			//判断月缴是否生效
			if (Viplist1 != null && Viplist1.size() != 0) {
				for (int j = 0; j < Viplist1.size(); j++) {
					if (Viplist1.get(0).getPm_id() == param55.getPm_id()) {
						//未生效， 判断余额是都足够自动交钱
						if (car2.getCust().getCust_money() >= money) {
							int money2 = car2.getCust().getCust_money() - money;
							Cust cust = new Cust(car2.getCust().getCust_id(), money2);
							boolean flag2 = custBiz.chageCustMoneyByIDX(cust);
							System.out.println("flag2=" + flag2);
							if (flag2 == true) {
								flag = false;
								System.out.println("-------这货是会员还未生效，卡里有钱自动扣掉，放他走!!!-------");
							} else {
								flag = true;
								System.out.println("-------这货是会员还未生效，卡里钱自动扣掉的时候发生了意外，扣除失败了!!!-------");
							}
						} else {
							flag = true;
							System.out.println("-------这货是会员还未生效，卡里钱不够 ，不放!!!-------");
						}
					} else {
						flag = false;
						System.out.println("-------这货是月缴会员，放他走!!!-------");
					}
				}
			}
		}//判断是否为临时车辆 
		else if (car1.getPm_id() == param44.getPm_id()) {
			flag = false;
			System.out.println("-------这货要交钱的 ，不放!!!-------");
		}
		System.out.println("flag ="+flag);
		
		
		
		
		
		
		
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

//		int c = 161;
//		for (int i = 70083; i <= 70177; i++) {
//			Park park = new Park(9, "D", c, "开放", "" + i, 1);
//			boolean flag = parkBiz.AddPark(park);
//			c++;
//			System.out.println("flag="+flag+c);
//		}
//		int aa = 2001;
//		for (int i = 70083; i <= 70177; i++) {
//			Park park = new Park(9, "A", c, "开放", "" + i, 2);
//			boolean flag = parkBiz.AddPark(park);
//			boolean flag=parkBiz.SetCarParkX11(aa, i);
//			aa++;
//			System.out.println("flag="+flag+i);
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
