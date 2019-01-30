package org.great.log;

import org.great.handler.MainHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	
	public static void main(String[] args){
		 //启动Spring容器        
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
        //获取service或controller组件
		MainHandler mainHandler = (MainHandler) ctx.getBean("mainHandler");
//		mainHandler.mainJsp();
	}
}
