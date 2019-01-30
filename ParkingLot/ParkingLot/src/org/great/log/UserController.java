package org.great.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("userController")
public class UserController {

	//@RequestMapping("testAOP")
	@OperationLog(operationType = "增加操作", operationName = "添加用户")
	public void testAOP(String userName, String password){
		System.out.println("UserController被调用了~~~~~~~~~~~~~~~~···");

//		String tmp = null;
//		tmp.substring(1);

	}
	
	@OperationLog(operationType = "修改操作", operationName = "修改用户")
	public void testAOP2(String userName, String password){
		System.out.println("UserController被调用了~~~~~~~~~~~~~~~~···");

		String tmp = null;
		tmp.substring(1);

	}
	
}