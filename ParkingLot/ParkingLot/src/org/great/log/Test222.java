package org.great.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "applicationContext.xml";
		System.out.println("****************");
		ApplicationContext conf = new ClassPathXmlApplicationContext(path);
		System.out.println("****************");

		UserLog ul = (UserLog) conf.getBean("userLog");

		ul.AddAop("�״�ү", "123");

	}

}
