package test;

import java.util.List;

import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.great.mapper.ParamMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test1 {
	@Test
	public void TEst1() {
		
		System.out.println("*******************");
		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustBiz custBiz = (CustBiz) ct.getBean("custBiz");
		//		ParamBiz paramBiz =(ParamBiz) ct.getBean("paramBiz");
		//		 ParamMapper paramMapper = (ParamMapper) ct.getBean("paramMapper");
		 List<Cust> list=custBiz.findCustAllX();
		 System.out.println("list长度="+list.size());
		 System.out.println("list="+list);
	}
}
