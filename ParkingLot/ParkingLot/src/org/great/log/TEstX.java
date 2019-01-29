package org.great.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.great.bean.Car;
import org.great.bean.Countrules;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.bean.Vip;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.great.biz.VipBiz;
import org.great.mapper.CarMapper;
import org.great.mapper.CountrulesMapper;
import org.great.mapper.ParamMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TEstX {
	@Test
	public void ttt() {
		
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		float mm = 0;
		try {
			float m = myFormatter.parse("2019-01-25 02:07:51").getTime() - myFormatter.parse("2019-01-25 01:27:51").getTime();
			mm = m / (60 * 60 * 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("相差的秒数: " + mm);
		
		
		
//		Date day = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(df.format(day));
//		Calendar calendar=Calendar.getInstance();   
//		   calendar.setTime(day); 
////		   calendar.add(Calendar.YEAR,-1);//日期减1年
////		   calendar.add(Calendar.MONTH,3);//日期加3个月
////		   calendar.add(Calendar.DAY_OF_YEAR,10);//日期加10天
//		   System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//今天的日期 
//		   calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+90-1);//让日期加1  
//		   Date dt2=calendar.getTime();
//	        String reStr = df.format(dt2);
//	        System.out.println("reStr="+reStr);
		
		
		
		
		
		
//		Date day = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(df.format(day));
//		String today = df.format(day);
//		System.out.println("today="+today);
//		Date day1 = new Date(day.getTime() + 30 * 24 * 60 * 60 * 1000);
//		String finday = df.format(day1);
//		System.out.println("finday"+finday);
		
		
//		System.out.println("*******************");
//		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CustBiz custBiz = (CustBiz) ct.getBean("custBiz");
//		CountrulesMapper countrulesMapper =(CountrulesMapper) ct.getBean("countrulesMapper");
//		Car car2 = new Car(1, 7, "冀B120N4");
//		System.out.println("***********");
//		ParamBiz paramBiz  =(ParamBiz) ct.getBean("paramBiz");
//		ParamMapper paramMapper =(ParamMapper) ct.getBean("paramMapper");
//		Param param3 = new Param("包月套餐", "车辆角色");
//		Param param33 = paramBiz.GetPmIDByTypeNmaeX(param3);
//		Param param4 = new Param("临时车辆", "车辆角色");
//		Param param = new Param("白名单", "车辆角色");
//		Param param = new Param("生效中","月缴状态");
//		Param param2 = new Param("注册会员", "车辆角色");
//		Param param22 = paramBiz.GetPmIDByTypeNmaeX(param);
//		System.out.println("param22="+param22);
//		System.out.println("paramMapper="+paramMapper);
//		System.out.println("param1="+paramMapper.GetPmIDByTypeNmaeX(param));
//		VipBiz vipBiz  =(VipBiz) ct.getBean("vipBiz");
//		List<Vip> list = vipBiz.findVipPmIDX(20,"月缴状态","生效中");
//		System.out.println("list="+list);
//		Map<String, String> map = new HashMap<String, String>();
//		String time = "" +5 ;
//		map.put("time", time);
//		map.put("pmtype", "规则状态");
//		map.put("pmname", "启用");
//	Countrules countrules = countrulesMapper.findCountrulRoleX(map);
//		System.out.println("list="+list.size());
//		System.out.println("countrules="+countrules);
	}
}
