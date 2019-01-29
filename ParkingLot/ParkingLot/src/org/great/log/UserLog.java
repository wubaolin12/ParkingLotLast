package org.great.log;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserLog {

	@Log(operationType = "增加用户", operationName = "1")
	public void AddAop(String userName, String password) {
		System.out.println("�����û����ӷ���");
	}

	@Log(operationType = "删除用户", operationName = "�޸��û�")
	public void deleAop() {

		System.out.println("����ɾ���û�����");
	}
}
