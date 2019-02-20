package org.great.fore_handler;

import javax.annotation.Resource;

import org.great.bean.Car;
import org.great.bean.Park;
import org.great.biz.ParkBiz;
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
	
	@Resource
	ParkBiz parkBiz;

	@RequestMapping("/findcar.do")
	public String execute() {
		
		return "Fore/find-car";
	}
	
	@ResponseBody
	@RequestMapping(value="/carMsg.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Park carMsg(@RequestBody Car car) {
		System.out.println(car.toString());
		
		Park park = parkBiz.findCar(car);
		
		if(park==null) {
			System.out.println("查不到车");
			return null;
		}
		return park;
	}
}
