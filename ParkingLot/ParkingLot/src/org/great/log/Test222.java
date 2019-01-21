package org.great.log;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.Role;
import org.great.bean.Staff_rel;
import org.great.bean.User;
import org.great.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "applicationContext.xml";
		System.out.println("****************");
		ApplicationContext conf = new ClassPathXmlApplicationContext(path);
		System.out.println("****************");
/*
		UserLog ul = (UserLog) conf.getBean("userLog");

		ul.AddAop("�״�ү", "123");*/
		UserMapper um=(UserMapper)conf.getBean("userMapper", UserMapper.class);
		System.out.println(um);
		org.great.bean.User user=new org.great.bean.User();
/*		user.setU_id(1);
		Staff_rel sf=um.Selectstaff_rel(user);*/
		String sql="select * from tb_user";
		RowBounds rb=new RowBounds(0, 4);
		List <User>list= um.findList(sql, rb);
		for(User u:list) {
			System.out.println(u.getSf().toString());
		}
		System.out.println("role---"+list.toString());
	}

}
