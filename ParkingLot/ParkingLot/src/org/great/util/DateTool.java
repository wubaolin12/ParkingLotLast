package org.great.util;

import java.text.SimpleDateFormat;
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
	
//	public static void main(String[] args) {
//		getDate();
//		System.out.println("---------");
//		getTime();
//	}
}
