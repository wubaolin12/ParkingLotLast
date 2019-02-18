package org.great.handler;

import java.util.List;

import org.great.bean.Receipt;
import org.great.biz.ReceiptBiz;
import org.great.mapper.ReceiptMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");

		ReceiptMapper receiptMapper = (ReceiptMapper) ct.getBean("receiptMapper");
		
		List<Receipt> a = receiptMapper.findQueryReceiptList("2019-01-01", "2019-02-16", "");
		
		System.out.println("a"+a);
	}

}
