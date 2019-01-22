package org.great.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.Role;
import org.great.bean.Staff_rel;
import org.great.bean.User;
import org.great.bean.vo.UserMsg;
import org.great.mapper.Mapper;
import org.great.mapper.UserMapper;
import org.great.mapper.UserMsgMapper;
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
		Mapper mm=(Mapper)conf.getBean("mapper", Mapper.class);
		System.out.println(um);
		org.great.bean.User user=new org.great.bean.User();
/*		user.setU_id(1);
		Staff_rel sf=um.Selectstaff_rel(user);*/
		String sql="select * from tb_user";
/*		RowBounds rb=new RowBounds(0, 4);
		List <User>list= um.findList(sql, rb);
		for(User u:list) {
			System.out.println(u.getSf().toString());
		}*/

		UserMsgMapper UMM=(UserMsgMapper)conf.getBean("userMsgMapper", UserMsgMapper.class);
		List<UserMsg>list=UMM.findUserMsg(null);
		for(UserMsg m:list) {
			//System.out.println(m);
		}
		
		List<User>ulist=um.findUList2("tb_user");
		System.out.println(ulist.toString());
		
		Map dataMap=new HashMap<>();
		dataMap.put("u_name", "张5");
		dataMap.put("u_phone", "11155554444");
		
		int i=mm.insertData(dataMap, "tb_user");
		System.out.println("-----i"+i);
	}
	
	

}
