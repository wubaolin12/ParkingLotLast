package org.great.handler;

import javax.annotation.Resource;

import org.great.biz.VipBiz;
import org.great.util.DateTool;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * 	自动判断月缴是否到期
 * @author 吴宝林
 *
 */
@Controller
public class JudgeVipHandler {
	
	@Resource
	VipBiz vipBiz;

	@Scheduled(cron = "0 0 0 * * ?")
	public void execute() {
		
		String date = DateTool.getDate();
		
		boolean flag = vipBiz.updateVipStu(date);
		
		System.out.println("vip状态处理结果："+flag);
		
	}
}
