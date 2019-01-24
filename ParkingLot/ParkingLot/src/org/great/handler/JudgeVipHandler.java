package org.great.handler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * 	自动判断月缴是否到期
 * @author 吴宝林
 *
 */
@Controller
public class JudgeVipHandler {

	@Scheduled(cron = "0 0 0 * * ?")
	public void execute() {
		
		
		
		
	}
}
