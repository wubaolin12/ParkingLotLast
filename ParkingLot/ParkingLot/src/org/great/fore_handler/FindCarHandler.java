package org.great.fore_handler;

import org.great.bean.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 反向寻车
 * @author 吴宝林
 *
 */
@Controller
@RequestMapping("/findcar")
public class FindCarHandler {

	@RequestMapping("/findcar.do")
	public String execute() {
		
		return "Fore/find-car";
	}
	
	@ResponseBody
	@RequestMapping(value="/carMsg.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public void carMsg(@RequestBody Car car) {
		System.out.println(car.toString());
		
		

	}
}
