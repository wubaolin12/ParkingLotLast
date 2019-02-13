package org.great.fore_handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.Appointment;
import org.great.bean.Car;
import org.great.bean.Combo;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.bean.Park;
import org.great.bean.Stopcartime;
import org.great.bean.User;
import org.great.biz.AppointmentBiz;
import org.great.biz.CarBiz;
import org.great.biz.ComboBiz;
import org.great.biz.ParamBiz;
import org.great.biz.ParkBiz;
import org.great.biz.StopcartimeBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("/appointmentParkLotHandler")
public class AppointmentParkLotHandler {

	@Resource
	ParkBiz parkBiz;
	@Resource
	AppointmentBiz appointmentBiz;
	@Resource
	CarBiz carBiz;
	@Resource
	ParamBiz paramBiz;
	@Resource
	StopcartimeBiz stopcartimeBiz;

	@RequestMapping("/appointmentParkLotJsp.do")
	public ModelAndView appointmentParkLotJsp(HttpServletRequest request) {

		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
//		查询改CUST下有多少量车 获得车牌 车ID 等信息
		List<Car> carList = carBiz.FindByCarcustidX(cust.getCust_id());
		System.out.println("carList=" + carList);
//		获得系统时间
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH");
		System.out.println(df.format(day));
		String time = df.format(day);
		System.out.println("time=" + time);
		int time1 = Integer.parseInt(time);
		List<Integer> timeList = new ArrayList<Integer>();
		for (int i = time1 + 1; i <= 23; i++) {
			timeList.add(i);
		}
		System.out.println("timeList=" + timeList);
//		查询可以停车的车位
//		List<Park> parkListCanStopCar =parkBiz.FindAllCanStopX("开放", 9);
//		System.out.println("parkListCanStopCar="+parkListCanStopCar);
		request.setAttribute("timeList", timeList);
		request.setAttribute("CustCarList", carList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Fore/appointmentParkLot");
		return mav;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/appointmentParkLot.do")
	public ModelAndView appointmentParkLot(int c_id, int time2, HttpServletRequest request) {
		System.err.println("---------打印传过来的值-----------------");
		System.out.println("c_id=" + c_id);
		System.out.println("time2=" + time2);
//		获得系统时间
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd " + time2 + ":00:00");
		System.out.println(df.format(day));
		String time = df.format(day);
		System.out.println("time=" + time);
		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
		Appointment appointment = new Appointment(cust.getCust_id(), c_id, time);
		boolean falg = appointmentBiz.AddAppointmentX(appointment);
		System.out.println("falg=" + falg);
//		查询改CUST下有多少量车 获得车牌 车ID等信息
		List<Car> carList = carBiz.FindByCarcustidX(cust.getCust_id());
		System.out.println("carList=" + carList);
		// 传回界面的时间下拉框的Liist
		Date day1 = new Date();
		SimpleDateFormat df1 = new SimpleDateFormat("HH");
		System.out.println(df1.format(day1));
		String t = df1.format(day1);
		System.out.println("t=" + t);
		int t1 = Integer.parseInt(t);
		List<Integer> timeList = new ArrayList<Integer>();
		for (int i = t1 + 1; i <= 23; i++) {
			timeList.add(i);
		}
		System.out.println("timeList=" + timeList);
////		查询可以停车的车位
//		List<Park> parkListCanStopCar =parkBiz.FindAllCanStopX("开放", 9);
//		System.out.println("parkListCanStopCar="+parkListCanStopCar);
		request.setAttribute("timeList", timeList);
		request.setAttribute("CustCarList", carList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Fore/appointmentParkLot");
		return mav;
	}

	@RequestMapping("/appointmentParkLotListJsp.do")
	public ModelAndView appointmentParkLotListJsp(HttpServletRequest request) {
		// 获得客户信息在session
		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
		// 根据用户ID查询该用户名下预约信息
		List<Appointment> appointmentsList = appointmentBiz.findCustCarAppoinmentX(cust.getCust_id());
		System.out.println("appointmentsList=" + appointmentsList);
		// 发送信息
		request.setAttribute("appointmentsList", appointmentsList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Fore/appointmentParkLotRead");
		return mav;
	}

	@RequestMapping("/appointmentParkLotCancel.do")
	public ModelAndView appointmentParkLotCancel(String c_num, HttpServletRequest request) {
		System.out.println("c_num=" + c_num);
		boolean flag = appointmentBiz.delAppointmentByCnumX(c_num);
		System.out.println("flag");
		// 获得客户信息在session
		Cust cust = (Cust) request.getSession().getAttribute("ForeUser");
		System.out.println("cust=" + cust);
		// 根据用户ID查询该用户名下预约信息
		List<Appointment> appointmentsList = appointmentBiz.findCustCarAppoinmentX(cust.getCust_id());
		System.out.println("appointmentsList=" + appointmentsList);
		// 发送信息
		request.setAttribute("appointmentsList", appointmentsList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Fore/appointmentParkLotRead");
		return mav;
	}
}
