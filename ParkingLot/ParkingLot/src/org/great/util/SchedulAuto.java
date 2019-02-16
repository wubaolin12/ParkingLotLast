package org.great.util;

import javax.annotation.Resource;

import org.great.biz.AppointmentBiz;
import org.great.biz.VipBiz;
import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 	自动判断月缴是否到期
 * @author 吴宝林
 *
 */
@Component
public class SchedulAuto {
	
	@Resource
	VipBiz vipBiz;
	
	@Resource
	AppointmentBiz appointmentBiz;

	/**
	 * 自动判断月缴是否到期，到期修改状态为已过期
	 * 自动判断是否有未生效的套餐，如果有改为生效中
	 */
	@Scheduled(cron = "0 0 2 * * ?")
	public void execute() {
		
		String date = DateTool.getDate();
		
		boolean flag1 = vipBiz.updateVipStu(date);
		
		boolean flag2 = vipBiz.activeVip();
		
		System.out.println("vip状态处理结果："+flag1);
		
	}
	
	/**
	 * 判断预约停车是否超时
	 */
	@Scheduled(cron = "0 0/30 * * * ? ")
	private void bookPark() {
		System.out.println("预约停车判断是否超时---");
		String time = DateTool.getTime();
		appointmentBiz.pastDue(time);
	}
}
