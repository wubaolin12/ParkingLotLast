package org.great.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springMVC 定时任务处理； 定时打印订单
 * 
 * @author Administrator
 *
 */
@Component
public class FirstCron {
	private static final Logger logger = LoggerFactory.getLogger(FirstCron.class);

	@Scheduled(cron = "0 00 22 * * ?")
	public void cron() {
		logger.info("----------该交日报了！！.......");
		System.out.println("----------该交日报了！！.......");
	}

}
