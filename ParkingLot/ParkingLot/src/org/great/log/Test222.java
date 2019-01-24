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
		Map dataMap=new HashMap<>();
		dataMap.put("u_name", "张6");
		dataMap.put("u_phone", "张6");
		//dataMap.put("u_phone", "11155554444");
		List<UserMsg>list=UMM.findUserMsg(dataMap);
		//System.out.println(list.get(0).getRole().getRole_name());
		for(UserMsg m:list) {
			System.out.println("----"+m.getParam().getPm_name());
		}
		System.out.println("-+++--"+list.toString());
//		int b=UMM.getCountNum(dataMap);
//		System.out.println("------umsgnum="+b);
/*		List<User>ulist=um.findUList2("tb_user");
		System.out.println(ulist.toString());
		
		Map dataMap=new HashMap<>();
		dataMap.put("u_name", "张6");
		dataMap.put("u_phone", "11155554444");
		
		//int i=mm.insertData(dataMap, "tb_user");
		int i=mm.updateData(dataMap, "tb_user","u_id",""+4);
		System.out.println("-----i"+i);*/
		Map map2=new HashMap<>();
		map2.put("u_id", 7);
		map2.put("u_id2", 7);
		//int a=mm.delData(map2, "tb_user");
		
		Map map3=new HashMap<>();
		map3.put("test", map2.get("u_id"));
		map2.remove("u_id");
		
		dataMap.put("u_name", "张11");
		dataMap.put("u_phone", "11155554444");
		dataMap.put("u_sex", "男");
		//dataMap.put("id", null);
		System.out.println(map3);
		System.out.println(map2);
		Map map4=new HashMap<>();
		map4.put("id", null);
		int id=0;
		User user2=new User();
		String keycol=null;
		int i=mm.insertData(dataMap,map4,"tb_user");
		System.out.println("-----i="+i+", u_id="+id+"datamap"+dataMap.toString()+" map4"+map4.toString());
		System.out.println(keycol);
		
		
	}
	
	

}
