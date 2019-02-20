package org.great.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 获取系统时间工具类
 * @author Administrator
 *
 */
public class DateTool {

	
	/**
	 * 获取日期，yyyy-MM-dd HH:mm:ss格式
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		System.out.println("time:"+time);
		return time;
	}
	
	/**
	 * 获取日期，yyyy-MM-dd格式
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		System.out.println("date:"+date);
		return date;
	}
	
	/**
	 * 获取昨天的日期
	 * @return
	 */
	public static String getYesterdayDate() {
		
		//使用默认时区和语言环境获得一个日历
		Calendar calendar = Calendar.getInstance();
		
		//根据日历的规则，为给定的日历字段添加或减去指定的时间量
		calendar.add(Calendar.DATE, -1);
		
		//返回一个Date对象
		Date date = calendar.getTime();
		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		return yesterday;
	}
	
	/**
	 * 	获取下一天的日期
	 * @return
	 * @throws ParseException 
	 */
	public static String getNextDate(String d) throws ParseException {
		
		//返回一个Date对象

		DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = fm.parse(d);
		
		//使用默认时区和语言环境获得一个日历
		Calendar calendar = Calendar.getInstance();		
		//根据日历的规则，为给定的日历字段添加或减去指定的时间量
		calendar.setTime(date);
		calendar.add(Calendar.DATE, +1);
		date = calendar.getTime();
		String nextDate = fm.format(date);
		
		System.out.println("下一天是=="+nextDate);
		return nextDate;
	}
//	public static void main(String[] args) throws Exception {
////		getDate();
//		System.out.println("---------");
////		getYesterdayDate();
////		String t1 = getTime();
////		String t2 = "2019-02-16 08:30:00";
////		System.out.println(t1);
////		
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		
////		long m1=sdf.parse(t1).getTime()-sdf.parse(t2).getTime();
////		
////		if(m1>=0) {
////			//预约到期
////			System.out.println("预约到期");
////		}
//		String d = "2019-02-20";
//		getNextDate(d);
//	}
}
