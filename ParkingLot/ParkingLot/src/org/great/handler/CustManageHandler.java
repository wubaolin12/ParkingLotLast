package org.great.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("/custManageHandler")
public class CustManageHandler {

	@Resource
	ParamBiz paramBiz;
	@Resource
	CustBiz custBiz;
	private boolean flag = false;

	/**
	 * 收费端客户信息查看
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CustManageJsp.action")
	public ModelAndView CustManageJsp(HttpServletRequest request) {
		System.out.println("**********************************");
		List<Cust> custParamList = custBiz.findCustAllX();
		System.out.println("custParamList=" + custParamList);
		request.setAttribute("custParamList", custParamList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/CustManage");
		return mav;
	}

	/**
	 * 跳转弹出到添加客户界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CustAddJsp.action")
	public String CustAddJsp() {
		return "charge/CustAdd";
	}

	/**
	 * AJKS添加用户Cust验证手机号
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CustPhoneValidate.action")
	public @ResponseBody boolean CustPhoneValidate(Cust cust) {
		System.out.println("cust=" + cust);
		List<Cust> CustList = custBiz.FindByPhoneX(cust.getCust_phone());
		System.out.println("CustList=" + CustList);
		if (CustList == null || CustList.size() == 0) {
			flag = true;
		}
		return flag;
	}
	/**
	 * 跳转到月缴办理界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CustCarJsp.action")
	public String CustCarJsp() {
		return "charge/CustSetCar";
	}
	/**
	 * AJKS添加用户Cust
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CustAdd.action")
	public @ResponseBody boolean CustAdd(Cust cust) {
		System.out.println("--------------------------------------");
		System.out.println("cust=" + cust);
		flag = custBiz.AddCustX(cust);
		return flag;
	}

	/**
	 * AJKS查询用户Cust的车辆信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/FindCustCar.action")
	public @ResponseBody List<Cust> FindCustCar(Cust cust) {
		System.out.println("cust=" + cust);
		List<Cust> CustCarList = custBiz.findCustCarX(cust.getCust_phone());
		System.out.println("CustCarList=" + CustCarList);
		return CustCarList;
	}
}
