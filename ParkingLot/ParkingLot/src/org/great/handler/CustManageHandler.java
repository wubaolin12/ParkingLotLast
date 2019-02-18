package org.great.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.Car;
import org.great.bean.Combo;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.bean.Receipt;
import org.great.bean.Stopcartime;
import org.great.bean.User;
import org.great.bean.Vip;
import org.great.bean.vo.AnyX;
import org.great.biz.CarBiz;
import org.great.biz.ComboBiz;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.great.biz.ReceiptBiz;
import org.great.biz.StopcartimeBiz;
import org.great.biz.VipBiz;
import org.great.util.BaseUtil;
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
	ComboBiz comboBiz;
	@Resource
	ReceiptBiz receiptBiz;
	@Resource
	ParamBiz paramBiz;
	@Resource
	CustBiz custBiz;
	@Resource
	CarBiz carBiz;
	@Resource
	VipBiz vipBiz;
	@Resource
	StopcartimeBiz stopcartimeBiz;
	@Resource
	BaseUtil baseUtil;
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
			System.out.println("*************");
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
	public @ResponseBody boolean CustAdd(Cust cust, HttpServletRequest request) {
		System.out.println("--------------------------------------");
		System.out.println("cust=" + cust);
		flag = custBiz.AddCustX(cust);
		String FLAG = "SUCCESS";
		request.setAttribute("FLAG", FLAG);
		return flag;
	}

	/**
	 * AJKS验证车牌号是否被他人注册或者是本身就是注册会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CarAddNumV.action")
	public @ResponseBody boolean CarAddPhoneV(String carnum, String cust_phone) {
		System.out.println("--------------------------------------");
		System.out.println("carnum=" + carnum);
		System.out.println("cust_phone=" + cust_phone);
		Car car1 = carBiz.findCustCarNumberByPhoneX(carnum);
		System.out.println("car1=" + car1);
		String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
		boolean flag1 = Pattern.matches(pattern, carnum);
		if (flag1 == true) {

			if (car1 == null) {
				flag = true;
			} else if (car1 != null && !car1.getCust().getCust_phone().equals(cust_phone)) {
				flag = false;
			} else if (car1 != null && car1.getCust().getCust_phone().equals(cust_phone)) {
				flag = true;
			}
		} else {
			flag = false;
		}
		System.out.println("flag=" + flag);
		return flag;
	}

	/**
	 * 查询用户Cust的车辆信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/FindCustCar.action")
	public ModelAndView FindCustCar(Cust cust, HttpServletRequest request) {
		System.out.println("***********************");
		System.out.println("cust=" + cust);
		List<Car> CustCarList = carBiz.findCustCarX(cust);
		System.out.println("CustCarList=" + CustCarList);
		request.setAttribute("CustCarList", CustCarList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/CustSetCar");
		return mav;
	}

	/**
	 * 跳转到车辆添加注册办理界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CarAddJsp.action")
	public ModelAndView CarAddJsp(HttpServletRequest request) {
		List<Combo> comList = comboBiz.FindCombo();
		request.setAttribute("comList", comList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/CarAdd");
		return mav;
	}

	/**
	 * AJKS用户Cust添加车辆
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CarAddH.action")
	public @ResponseBody String CarAdd(AnyX anyX, HttpServletRequest request) {
		System.out.println("--------------------------------------");
		String str = null;
		int pid = 0;
		// 得到车辆表信息
		Car car1 = carBiz.FindByCarNumber(anyX.getCarnum());
		System.out.println("car1=" + car1);
		Param param = new Param("待生效", "月缴状态");
		Param param1 = paramBiz.GetPmIDByTypeNmaeX(param);
		// 得到套餐ID
		int co_id = Integer.parseInt(anyX.getAdminRole());
		Map<String, String> map = new HashMap<>();
		int dauNum = 0;
		if (co_id != 0) {
			Combo comBo = comboBiz.FindComboByIDX(co_id);
			dauNum = Integer.parseInt(comBo.getCo_standard());
			map = VipTime(dauNum);
		}
//		判断车辆有无被注册
		// 什么都没有的车辆
		if (car1 == null) {
			if (anyX.getPm_id().equals("注册会员")) {
				pid = 6;
				List<Cust> list = custBiz.FindByPhoneX(anyX.getCust_phone());
				Car car2 = new Car(list.get(0).getCust_id(), pid, anyX.getCarnum());
				flag = carBiz.AddCarCX(car2);
				str = "添加成为注册车辆了";
			} else if (anyX.getPm_id().equals("包月会员")) {
				pid = 7;
				List<Cust> list = custBiz.FindByPhoneX(anyX.getCust_phone());
				System.out.println("list=" + list);
				Car car2 = new Car(list.get(0).getCust_id(), pid, anyX.getCarnum());
				System.out.println("car2=" + car2);
				flag = carBiz.AddCarCX(car2);
				System.out.println("Cflag=" + flag);
				car2 = carBiz.FindByCarNumber(anyX.getCarnum());
				Vip vip = new Vip(co_id, car2.getC_id(), map.get("today"), map.get("finday"), param1.getPm_id());
				System.out.println("vip=" + vip);
				flag = vipBiz.AddvipX(vip);
				System.out.println("Vflag=" + flag);
				str = "添加成为包月会员车辆了";
				Combo combo = comboBiz.FindComboByIDX(co_id);
				int money = Integer.parseInt(combo.getCo_price());
				DateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date currenime = new Date();
				String currendate = dff.format(currenime);
				User user = (User) request.getAttribute("User");
				boolean ff = baseUtil.addReceipt(user.getU_id(), car2.getC_id(), "月缴收费", money, currendate);
				System.out.println("ff=" + ff);
				System.err.println("**************************************");
			}
		} // 临时车辆
		else if (car1.getCust_id() == 0) {
			if (anyX.getPm_id().equals("注册会员")) {
				pid = 6;
				List<Cust> list = custBiz.FindByPhoneX(anyX.getCust_phone());
				Car car2 = new Car(list.get(0).getCust_id(), pid, anyX.getCarnum());

				System.out.println("car2=" + car2);
				flag = carBiz.chagerPmIDCustIDByCarNumberX(car2);
				str = "临时车辆添加成为注册车辆了";

			} else if (anyX.getPm_id().equals("包月会员")) {
				pid = 7;
				List<Cust> list = custBiz.FindByPhoneX(anyX.getCust_phone());
				System.out.println("list=" + list);
				Car car2 = new Car(list.get(0).getCust_id(), pid, anyX.getCarnum());
				System.out.println("car2=" + car2);
				flag = carBiz.chagerPmIDCustIDByCarNumberX(car2);
				System.out.println("Cflag=" + flag);
				car2 = carBiz.FindByCarNumber(anyX.getCarnum());
				Vip vip = new Vip(co_id, car2.getC_id(), map.get("today"), map.get("finday"), param1.getPm_id());
				System.out.println("vip=" + vip);
				flag = vipBiz.AddvipX(vip);
				System.out.println("Vflag=" + flag);
				str = "临时车辆添加成为包月会员车辆了";
				Car car3 = carBiz.FindByCarNumber(anyX.getCarnum());
				Combo combo = comboBiz.FindComboByIDX(co_id);
				int money = Integer.parseInt(combo.getCo_price());
				DateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date currenime = new Date();
				String currendate = dff.format(currenime);
				User user = (User) request.getAttribute("User");
				boolean ff = baseUtil.addReceipt(user.getU_id(), car3.getC_id(), "月缴收费", money, currendate);
				System.out.println("ff=" + ff);
				System.err.println("**************************************");
			}
		} // 注册会员车辆
		else {
			if (car1.getPm_id() == 6) {
				if (anyX.getPm_id().equals("注册会员")) {
					str = "已经是注册会员了";
				} else if (anyX.getPm_id().equals("包月会员")) {
					pid = 7;
					Car car3 = new Car(pid, anyX.getCarnum());
					System.err.println("car3=" + car3);
					flag = carBiz.chagerPmIDByCarNumberX(car3);
					System.err.println("cflag=" + flag);
					Vip vip = new Vip(co_id, car1.getC_id(), map.get("today"), map.get("finday"), param1.getPm_id());
					System.err.println("vip=" + vip);
					flag = vipBiz.AddvipX(vip);
					System.err.println("vip123==" + vip);
					System.err.println("vflag=" + flag);
					str = "添加成为包月会员车辆了";
					Car car4 = carBiz.FindByCarNumber(anyX.getCarnum());
					Combo combo = comboBiz.FindComboByIDX(co_id);
					int money = Integer.parseInt(combo.getCo_price());
					DateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date currenime = new Date();
					String currendate = dff.format(currenime);
					User user = (User) request.getAttribute("User");
					boolean ff = baseUtil.addReceipt(user.getU_id(), car4.getC_id(), "月缴收费", money, currendate);
					System.out.println("ff=" + ff);
					System.err.println("***************");
				}
			} else if (car1.getPm_id() == 7) {
				if (anyX.getPm_id().equals("注册会员")) {
					str = "已经是包月会员了";
				} else if (anyX.getPm_id().equals("包月会员")) {
					pid = 7;
					Car car3 = carBiz.FindVipByCarNumberX(anyX.getCarnum());
					System.out.println("car3=" + car3);
					int vid = 0;
					String overday = null;
					// 判断VIP信息是否为待生效还是已生效， null待生效
					if (car3 != null) {
						vid = car3.getVip().getV_id();
						overday = car3.getVip().getV_overtime();
					} else {
						Car car11 = carBiz.FindVipByCarNumber18X(anyX.getCarnum());
						vid = car11.getVip().getV_id();
						overday = car11.getVip().getV_overtime();
					}

					Calendar calendar = Calendar.getInstance();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date day = null;
					try {
						day = df.parse(overday);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					calendar.setTime(day);
					calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dauNum - 1);// 让日期加1
					Date dt2 = calendar.getTime();
					String finday = df.format(dt2);
					System.out.println("finday=" + finday);
					Vip vip1 = new Vip(vid, finday);
					flag = vipBiz.chageOvertimeByVidX(vip1);
					Car car5 = carBiz.FindByCarNumber(anyX.getCarnum());
					Combo combo = comboBiz.FindComboByIDX(co_id);
					int money = Integer.parseInt(combo.getCo_price());
					DateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date currenime = new Date();
					String currendate = dff.format(currenime);
					User user = (User) request.getAttribute("User");
					boolean ff = baseUtil.addReceipt(user.getU_id(), car5.getC_id(), "月缴收费", money, currendate);
					System.out.println("ff=" + ff);
					str = "续费会员成功了";
				}
			} else if (car1.getPm_id() == 14) {
				if (anyX.getPm_id().equals("注册会员")) {
					str = "已经是白名单了";
				} else if (anyX.getPm_id().equals("包月会员")) {
					str = "已经是白名单了";
				}
			}

		}
		System.out.println("anyX==" + anyX);
		System.out.println("str=" + str);
		String FLAG = "SUCCESS";
		request.setAttribute("FLAG", FLAG);
		System.out.println("FLAG=" + FLAG);
		return str;
	}

	public Map<String, String> VipTime(int dauNum) {
		Map<String, String> map = new HashMap<>();
		// 获得系统时间
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.setTime(day);
		calendar1.setTime(day);
		// 今天的日期
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		calendar1.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);// 让日期加1
		// 添加完的日期
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dauNum - 1);// 让日期加1
		Date dt2 = calendar.getTime();
		Date dt3 = calendar1.getTime();
		String finday = df.format(dt2);
		String today = df.format(dt3);
		System.out.println("today=" + today);
		System.out.println("finday=" + finday);
		map.put("today", today);
		map.put("finday", finday);
		return map;
	}

	/**
	 * 跳转到添加月缴退费查看界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/VipReturnsJsp.action")
	public String VipReturnsJsp() {
		return "charge/VipReturns";
	}

	/**
	 * 跳转到添加月缴退费查看界面并根据手机号查询月缴车辆
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/VipReturnsReadJSP.action")
	public ModelAndView VipReturnsReadJSP(String cust_phone, HttpServletRequest request) {
		System.out.println("cust_phone=" + cust_phone);
		List<Car> CustCarList = carBiz.findCustCarVipStateX(cust_phone, 7, "月缴状态", "待生效");
		System.out.println("==CustCarList=" + CustCarList + "==================");
		request.setAttribute("CustCarList", CustCarList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/VipReturns");
		return mav;

	}

	/**
	 * 跳转到添加月缴退费确定界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/VipReturnThisJsp.action")
	public String VipReturnThisJsp() {
		return "charge/VipReturnThis";
	}

	/**
	 * AJKS验证车牌号是否可以退月缴会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/CarNumVIPReturn.action")
	public @ResponseBody boolean CarNumVIPReturn(String carnum, String cust_phone) {
		System.out.println("--------------------------------------");
		System.out.println("carnum=" + carnum);
		System.out.println("cust_phone=" + cust_phone);
		List<Car> car1List = carBiz.findCarVipStateX(carnum);
		System.out.println("car1List=" + car1List);
		if (car1List == null || car1List.size() == 0) {
			flag = false;
		} else if (car1List.get(0).getPm_id() == 5) {
			flag = false;
		} else if (car1List.get(0).getPm_id() == 6) {
			flag = false;
		} else if (car1List.get(0).getPm_id() == 7) {
			if (car1List.get(0).getVip().getPm_id() == 18) {
				flag = true;

			} else {
				flag = false;
			}
		} else if (car1List.get(0).getPm_id() == 14) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 月缴退费办理中
	 * 
	 * @param anyX
	 * @return
	 */
	@RequestMapping("/CarVipReturn.action")
	public @ResponseBody String CarVipReturn(AnyX anyX, HttpServletRequest request) {
		System.out.println("--------------------------------------");
		System.out.println("anyX=" + anyX);
		String str = "";
		List<Car> car1List = carBiz.findCarVipStateX(anyX.getCarnum());
		System.out.println("car1List=" + car1List);
		flag = vipBiz.VipReturnX(car1List.get(0).getVip().getV_id());
		if (flag == true) {
			int pid = 6;
			Car car1 = new Car(pid, car1List.get(0).getC_num());
			System.out.println("car1=" + car1);
			boolean flag1 = carBiz.chagerPmIDByCarNumberX(car1);
			if (flag1 == true) {
				str = "退费成功！！";
				// 获取当前时间算出场时间
				Combo combo = comboBiz.FindComboByIDX(car1List.get(0).getVip().getCo_id());
				System.out.println("combo=" + combo);
				int money = Integer.parseInt(combo.getCo_price());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date currenime = new Date();
				String currendate = df.format(currenime);
				User user = (User) request.getAttribute("User");
				System.out.println("currendate=" + currendate);
				System.out.println("user=" + user);
				boolean ff = baseUtil.addReceipt(user.getU_id(), car1List.get(0).getC_id(), "月缴退费", money, currendate);
				System.out.println("ff=" + ff);
			} else {
				str = "退费失败！！";
			}
		} else {
			str = "退费失败！！";
		}
		String FLAG = "SUCCESS";
		request.setAttribute("FLAG", FLAG);
		return str;
	}

	/**
	 * 生成日结单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/DailyMailJSP.action")
	public String DailyMailJSP() {
		return "charge/DailyStatement";
	}

	/**
	 * 生成日结单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/DailyMail.action")
	public ModelAndView DailyMail(HttpServletRequest request) {
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(day));
//		String time = "%" + "2019-01-22" + "%";
		String time = "%" + df.format(day) + "%";
		System.out.println(time);
		User user = (User) request.getAttribute("User");
		System.out.println("user=" + user);
		Receipt re = new Receipt(user.getU_id(), time);
		List<Receipt> receiptList = receiptBiz.findDailyRecp(re);
		System.out.println("receiptList=" + receiptList);
		request.setAttribute("receiptList", receiptList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/DailyStatement");
//		要打印接下去写
		return mav;
	}

	/**
	 * 跳到停车场开闸动画界面收费段的
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/OpenDoorJSP.action")
	public String OpenDoorJSP(String c_num, int sct_money, String sct_starttime, String sct_overtime) {
		System.out.println("c_num=" + c_num + "sct_money=" + sct_money + "sct_starttime=" + sct_starttime
				+ "sct_overtime=" + sct_overtime);
		Param par = new Param("停车结束", "停车状态");
		Param par1 = paramBiz.GetPmIDByTypeNmaeX(par);
		System.out.println(par1);
		// 查找该车牌是否已经有记录
		Car car = carBiz.FindByCarNumber(c_num);
		System.out.println("找到的车记录" + car);
		Stopcartime sct1 = stopcartimeBiz.FindByCarIDX(car.getC_id(), par1.getPm_id());
		Stopcartime sct = new Stopcartime(2, sct_overtime, sct1.getSct_id());
		flag = stopcartimeBiz.UpdateSctTimeandState(sct);
		System.out.println("——————————————修改出场时间成功————————————————————————");
		Stopcartime sctz = new Stopcartime(sct1.getSct_id(), sct_money);
		System.out.println("sctz=" + sctz);
		flag = stopcartimeBiz.UpdateSctMoneyX(sctz);
		return "charge/OpenDoor";
	}

	/**
	 * 跳到缴费渠道统计JSP
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/countGetMoneyWayJSP.action")
	public ModelAndView countGetMoneyWayJSP(HttpServletRequest request) {
		String re_time1 = null;
		String re_time2 = null;
		List<Receipt> ReceiptList = receiptBiz.findCountMoneyReX(re_time1, re_time2);

		request.setAttribute("ReceiptList", ReceiptList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/countGetMoneyWay");
		return mav;
	}

	/**
	 * 缴费渠道统计日期查看
	 * 
	 * @param anyX
	 * @return
	 */
	@RequestMapping("/countGetMoneyWayAjax.action")
	public ModelAndView countGetMoneyWayAjax(String re_time1, String re_time2, HttpServletRequest request) {
		System.out.println("------re_time2--------------------------------");
		String re_time3 = null;
		String re_time4 = null;
		System.out.println("re_time1=" + re_time1 + "---re_time2=" + re_time2);
		if (re_time1 != null && re_time1 != "") {
			re_time3 = re_time1;
		}
		if (re_time2 != null && re_time2 != "") {
			re_time4 = re_time2;
		}
		System.out.println("re_time3=" + re_time3 + "---re_time4=" + re_time4);
		List<Receipt> ReceiptList = receiptBiz.findCountMoneyReX(re_time3, re_time4);
		request.setAttribute("ReceiptList", ReceiptList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("charge/countGetMoneyWay");
		return mav;
	}
}
