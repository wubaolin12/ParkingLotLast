package org.great.log;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserLog {

	@Log(operationType = "���Ӳ���", operationName = "�����û�")
	public void AddAop(String userName, String password) {
		System.out.println("�����û����ӷ���");
	}

	@Log(operationType = "�޸Ĳ���", operationName = "�޸��û�")
	public void deleAop() {

		System.out.println("����ɾ���û�����");
	}
}
