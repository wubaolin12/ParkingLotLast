package org.great.fore_handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.Car;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.biz.CarBiz;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/carManagHandler")
public class CarManagHandler {

	@Resource
	CarBiz carBiz;
	@Resource
	CustBiz custBiz;
	@Resource
	ParamBiz paramBiz;

	/**
	 * 跳到车辆管理JSP前端————野比欣之助
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/jumpCarMangerJSP.do")
	public String JumpCarMangerJSP(HttpServletRequest request) {
		// 查询该用户名下车辆信息
		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
		List<Car> CarList = carBiz.findCustCarX(cust);
		System.out.println("CarList=" + CarList);
		if (CarList != null && CarList.size() != 0 && CarList.size() != 1 && CarList.get(0).getC_id() != 0) {
			request.setAttribute("CarList", CarList);
		}
		return "Fore/carInfoRead";
	}

	/**
	 * 车辆取消绑定客户前端————野比欣之助
	 * 
	 * @param c_num
	 * @param request
	 * @return
	 */
	@RequestMapping("/Carunbind.do")
	public String Carunbind(String c_num, HttpServletRequest request) {

		System.out.println("c_num=" + c_num);
//		查询用户信息根据用户手机号
		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
		List<Car> CarListOne = carBiz.FindCarByCaridX(c_num);
		System.out.println("CarListOne=" + CarListOne);
		Param param = new Param("白名单", "车辆角色");
		Param param1 = paramBiz.GetPmIDByTypeNmaeX(param);
		Param param2 = new Param("注册会员", "车辆角色");
		Param param22 = paramBiz.GetPmIDByTypeNmaeX(param2);
		Param param3 = new Param("包月套餐", "车辆角色");
		Param param33 = paramBiz.GetPmIDByTypeNmaeX(param3);
		int pid = 14;
		if (CarListOne.get(0).getPm_id() == param1.getPm_id()) {
			pid = 5;
		} else if (CarListOne.get(0).getPm_id() == param22.getPm_id()) {
			pid = 6;
		} else if (CarListOne.get(0).getPm_id() == param33.getPm_id()) {
			pid = 7;
		} else {
			pid = 14;
		}
		boolean flag = carBiz.chagerCustIDNULLByCarNumberX(c_num, pid);
//		根据车牌号取消车辆绑定用户信息
		System.out.println("flag=" + flag);
		List<Car> CarList = carBiz.findCustCarX(cust);
		System.out.println("CarList=" + CarList);
		request.setAttribute("CarList", CarList);
		return "Fore/carInfoRead";
	}

	/**
	 * 跳到车辆添加JSP页面前端客户端 ————野比欣之助
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/JumpCarAddJSP.do")
	public String JumpCarAddJSP(HttpServletRequest request) {
		// 查询该用户名下车辆信息
		return "Fore/carAddCust";
	}

	/**
	 * 车辆添加绑定注册用户前端————野比欣之助
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/JumpCarAdd.do")
	public String JumpCarAdd(String c_num, HttpServletRequest request) {
		// 查询该用户名下车辆信息
		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
		List<Car> CarList = carBiz.FindCarByCaridX(c_num);
		System.out.println("CarList=" + CarList);
		Param param2 = new Param("注册会员", "车辆角色");
		Param param22 = paramBiz.GetPmIDByTypeNmaeX(param2);
		Param param4 = new Param("临时车辆", "车辆角色");
		Param param44 = paramBiz.GetPmIDByTypeNmaeX(param4);
		if (CarList != null && CarList.size() != 0) {
			if (CarList.get(0).getPm_id() == param44.getPm_id()) {
				Car car = new Car(cust.getCust_id(), param22.getPm_id(), c_num);
				boolean flag = carBiz.chagerPmIDCustIDByCarNumberX(car);
				System.out.println("-----这只野生临时的汽车人已经是我麾下的了----");
				System.out.println("flag=" + flag);
			} else {
				if (CarList.get(0).getCust_id() == 0) {
					boolean flag = carBiz.chagerCustIDByCarNumberX(c_num, cust.getCust_id());
					System.out.println("----------这是一只无主的包月还是白名单车辆-----现在他被我承包了-----");
					System.out.println("flag="+flag);
				} else {
					System.out.println("-----什么都不做------他已经很牛逼了----他是会员还是白名单来着的----");
				}
			}
		} else {
			Car car = new Car(cust.getCust_id(), param22.getPm_id(), c_num);
			boolean flag = carBiz.AddCarCX(car);
			System.out.println("flag=" + flag);
			System.out.println("-----这只超野生没有记录的汽车人已经是我麾下的了----");
		}
		return "Fore/carAddCust";
	}
}
