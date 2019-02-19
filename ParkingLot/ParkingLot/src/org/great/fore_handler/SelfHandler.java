package org.great.fore_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Car;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.bean.Stopcartime;
import org.great.bean.Vip;
import org.great.biz.CarBiz;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.great.biz.ParkBiz;
import org.great.biz.RoleRelBiz;
import org.great.biz.StopcartimeBiz;
import org.great.biz.VipBiz;
import org.great.util.BaseUtil;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自助缴费
 * 
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/self")
public class SelfHandler {
	private boolean flag;// 标记
	@Resource
	public CustBiz custBiz;  //用户dao接口
	@Resource
	private Car car;
	@Resource
	ParamBiz paramBiz;
	@Resource
	ParkBiz parkBiz;
	@Resource
	BaseUtil baseUtil;
	@Resource
	private CarBiz carBiz;// 调用Mybatis调用数据库
	@Resource
	private VipBiz vipBiz;// 调用Mybatis调用数据库
	@Resource
	private StopcartimeBiz stopcartimeBiz;
//	public List<Park>parkList;//所有的车位列表;
//	//public Park updatePark; //查询条件的车位;
//	String result = "usererror";
//	public List<Park>pForeList;//车位区号列表;
	@Resource
	private RoleRelBiz roleRelBiz;
	
	/**
	 *  跳转自助缴费界面
	 */
	
	@RequestMapping("/foreToSelf.do")
	public String toRecharge(HttpServletRequest request,HttpServletResponse response) {
		
		RedisSession session = baseUtil.getSession(response, request);
		session.setAttribute("selfType", "loginYes");
		return "Fore/ChargeSelf";
	}
	
	/**
	 *  跳转自助缴费界面  免登录
	 */
	
	@RequestMapping("/foreToSelf_withoutLogin.do")
	public String foreToSelf_withoutLogin(HttpServletRequest request,HttpServletResponse response) {
		RedisSession session = baseUtil.getSession(response, request);
		session.setAttribute("selfType", "loginNo");
		return "Fore/ChargeSelf_withoutLogin";
	}

	/**
	 *  获得查询车牌号
	 * @throws IOException 
	 */
	
	@RequestMapping("/foreCar.do")
	public String car(HttpServletRequest request,HttpServletResponse response,String number) throws IOException {
		System.out.println("车牌="+number);
		request.setCharacterEncoding("utf-8");
		number = new String(request.getParameter("number").getBytes("iso-8859-1"), "utf-8");  
		System.out.println("车牌="+number);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
		
		int money = 0;
		//判断是否要交钱的FLAG 1 为要交钱， 0为不用
		int flag = 1;
		Param param = new Param("白名单", "车辆角色");
		Param param1 = paramBiz.GetPmIDByTypeNmaeX(param);
		Param param2 = new Param("注册会员", "车辆角色");
		Param param22 = paramBiz.GetPmIDByTypeNmaeX(param2);
		Param param3 = new Param("包月套餐", "车辆角色");
		Param param33 = paramBiz.GetPmIDByTypeNmaeX(param3);
		Param param4 = new Param("临时车辆", "车辆角色");
		Param param44 = paramBiz.GetPmIDByTypeNmaeX(param4);
		// 查找该车牌是否已经有记录
		Car car1 = carBiz.FindByCarNumber(number);
		System.out.println("查询车辆信息" + car1);
		
		//跳转的页面
		String jumpTo="";
		RedisSession session = baseUtil.getSession(response, request);
		String selfType = session.getAttribute("selfType",String.class).toString();
				if(selfType.equals("loginYes")) {
					jumpTo="self/foreToSelf.do";
				}else if(selfType.equals("loginNo")) {
					jumpTo="self/foreToSelf_withoutLogin.do";
				}
		
		if(car1!=null) {
		Param stopP_1 = new Param("停车中", "停车状态");
		Param stopP1 = paramBiz.GetPmIDByTypeNmaeX(stopP_1);
		Param stopP_2 = new Param("停车结束", "停车状态");
		Param stopP2 = paramBiz.GetPmIDByTypeNmaeX(stopP_2);
		Param stopP_19 = new Param("预约停车中", "停车状态");
		Param stopP19 = paramBiz.GetPmIDByTypeNmaeX(stopP_19);
		
		
		// 先查询该车的正在停车的那条数据，然后改变状态成出场
		List<Stopcartime> sctlist = stopcartimeBiz.FindSctByNumber(car1.getC_id());
		Stopcartime wantStopInfo=null;//想要的停车信息
			for(int i=0;i<sctlist.size();i++) {
				if(sctlist.get(i).getPm_id()!=stopP2.getPm_id()) {
					wantStopInfo=sctlist.get(i);
					break;
				}
			}
			//停车场里有此车
			if(wantStopInfo!=null) {
				// 获取当前时间算出场时间
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date currenime = new Date();
				String currendate = df.format(currenime);
				//计算钱
				money=baseUtil.count(wantStopInfo.getSct_starttime(),currendate);
				//如果是预约中车辆 多收十元
				if(wantStopInfo.getPm_id()==stopP19.getPm_id()) {
					money=money+10;
				}
				// 查询是否为白名单
				if (car1.getPm_id() == param1.getPm_id()) {
					System.out.println("-------这货是白名单，放他走!!!-------");
					flag = 0;
				} //查询是否为注册车辆
				else if (car1.getPm_id() == param22.getPm_id()) {
					Car car2 = carBiz.findCustCarNumberByCarIDX(car1.getC_id());
					List<Vip> Viplist = vipBiz.findVipX(car1.getC_id());// 宏琪 改了此处 car1.getC_id() 原来为20
//					查询是否曾经是月缴会员
					if (Viplist != null && Viplist.size() != 0) {
						System.out.println("-------这货曾经是月缴会员快提醒他续费充值!!!-------");
					} else {
						System.out.println("-------这货没充过月缴会员，你也可以提醒他充值哦!!!-------");
					}
					if (car2.getCust().getCust_money() >= money) {
						int money2 = car2.getCust().getCust_money() - money;
						Cust cust = new Cust(car2.getCust().getCust_id(), money2);
						boolean flag2 = custBiz.chageCustMoneyByIDX(cust);
						System.out.println("flag2=" + flag2);
						if (flag2 == true) {
							flag = 0;
							System.out.println("-------这货是注册会员卡里有钱自动扣掉，放他走!!!-------");
						
						} else {
							flag = 1;
							System.out.println("-------这货是注册会员卡里有钱自动扣掉的时候发生了以外，扣除失败了!!!-------");
						}
					} else {
						flag = 1;
						System.out.println("-------这货是注册会员卡里钱不够 ，不放!!!-------");
					}
				}//判断是否月缴车辆 
				else if (car1.getPm_id() == param33.getPm_id()) {
					Param param5 = new Param("待生效", "月缴状态");
					Param param55 = paramBiz.GetPmIDByTypeNmaeX(param5);
					Car car2 = carBiz.findCustCarNumberByCarIDX(car1.getC_id());
					List<Vip> Viplist1 = vipBiz.findVipX(car2.getC_id());
					//判断月缴是否生效
					if (Viplist1 != null && Viplist1.size() != 0) {
						for (int j = 0; j < Viplist1.size(); j++) {
							if (Viplist1.get(0).getPm_id() == param55.getPm_id()) {
								//未生效， 判断余额是都足够自动交钱
								if (car2.getCust().getCust_money() >= money) {
									int money2 = car2.getCust().getCust_money() - money;
									Cust cust = new Cust(car2.getCust().getCust_id(), money2);
									boolean flag2 = custBiz.chageCustMoneyByIDX(cust);
									System.out.println("flag2=" + flag2);
									if (flag2 == true) {
										flag = 0;
										System.out.println("-------这货是会员还未生效，卡里有钱自动扣掉，放他走!!!-------");
									} else {
										flag = 1;
										System.out.println("-------这货是会员还未生效，卡里钱自动扣掉的时候发生了意外，扣除失败了!!!-------");
									}
								} else {
									flag = 1;
									System.out.println("-------这货是会员还未生效，卡里钱不够 ，不放!!!-------");
								}
							} else {
								flag = 0;
								System.out.println("-------这货是月缴会员，放他走!!!-------");
							}
						}
					}
				}//判断是否为临时车辆 
				else if (car1.getPm_id() == param44.getPm_id()) {
					flag = 1;
					System.out.println("-------这货要交钱的 ，不放!!!-------");
				}
				System.out.println("flag ="+flag);
				session.setAttribute("selfStop", wantStopInfo);
				request.setAttribute("selfFlag",flag );
				request.setAttribute("selfMoney",money );
			}//停车场无此车
			else {
				out.println("<script type='text/javascript'>alert('停车场无此车！'); location.href='" + path
						+ jumpTo+"';</script>");
				out.close();
			}
		
		
		
		
		}//如果车表里找不到此车
		else {
			out.println("<script type='text/javascript'>alert('没有此车牌号信息！'); location.href='" + path
					+ jumpTo+ "';</script>");
			out.close();
		}
		String lastJump="";
		if(jumpTo.equals("self/foreToSelf.do")) {
			lastJump="Fore/ChargeSelf";
		}else if(jumpTo.equals("self/foreToSelf_withoutLogin.do")){
			lastJump="Fore/ChargeSelf_withoutLogin";
		}
		return lastJump;
	}
	
	
	
	
	/**
	 *  跳转提交金额到二维码（自助缴费）
	 */
	
	@RequestMapping("/foreMoneyTo_Self.pay")
	public String moneyTo_recharge(HttpServletRequest request,HttpServletResponse response,String WIDsubject, String WIDout_trade_no,String WIDbody,String WIDtotal_amount) {
		System.out.println("订单名称="+WIDsubject);
		System.out.println("商户订单号="+WIDout_trade_no);
		System.out.println("商品描述="+WIDbody);
		System.out.println("金额="+WIDtotal_amount);
		request.setAttribute("WIDsubject", WIDsubject);
		request.setAttribute("WIDout_trade_no", WIDout_trade_no);
		request.setAttribute("WIDbody", WIDbody);
		request.setAttribute("WIDtotal_amount", WIDtotal_amount);
		
		RedisSession session = baseUtil.getSession(response, request);
		session.setAttribute("PayType", "自助缴费");
		
		 //response.setContentType("text/html;charset=utf-8");
		String path=request.getScheme()+"://"+request.getServerName()+":"+
				request.getServerPort()+request.getContextPath()+"/";
		return "../../"+"alipay.trade.page.pay";
	}
	
	
	/**
	 *   支付成功后，跳转回自助缴费界面
	 * @throws IOException 
	 */
	@RequestMapping("/foreSuccessToSelf.do")
	public String successToRecharge(HttpServletRequest request,HttpServletResponse response,String out_trade_no,String trade_no ,String total_amount) throws IOException {
		System.out.println("成功");
		System.out.println("商户订单号="+out_trade_no);
		System.out.println("支付宝交易号="+trade_no);
		System.out.println("付款金额="+total_amount);
		//改变停车记录
		RedisSession session = baseUtil.getSession(response, request);
		Stopcartime wantStopInfo=(Stopcartime)session.getAttribute("selfStop",Stopcartime.class);
		
		// 获取当前时间算出场时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currenime = new Date();
		String currendate = df.format(currenime);
		
		//改变 预约车辆停车记录 为 正常停车  和增加 停车时间
		Param stopP_19 = new Param("停车中", "停车状态");
		Param stopP19 = paramBiz.GetPmIDByTypeNmaeX(stopP_19);
		wantStopInfo.setPm_id(stopP19.getPm_id());
		wantStopInfo.setSct_starttime(currendate);
		
		stopcartimeBiz.UpdateSctTimeandStateHq(wantStopInfo);
		
		//跳转的页面
				String jumpTo="";
				String selfType=(String)session.getAttribute("selfType",String.class);
				if(selfType.equals("loginYes")) {
					jumpTo="self/foreToSelf.do";
				}else if(selfType.equals("loginNo")) {
					jumpTo="self/foreToSelf_withoutLogin.do";
				}
		response.setContentType("text/html;charset=utf-8");
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('自助缴费成功，请迅速出场，免得再次收费！'); location.href='" + path
				+jumpTo+ "';</script>");
		out.close();
		
//		try {
//			response.setContentType("text/html;charset=utf-8");
//			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//					+ request.getContextPath() + "/";
//			PrintWriter out = response.getWriter();
//			out.println("<script type='text/javascript'>alert('充值"+total_amount+"元成功！'); location.href='" + path
//					+ "pay/toRecharge.do';</script>");
//			out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		String lastJump="";
		if(jumpTo.equals("self/foreToSelf.do")) {
			lastJump="Fore/ChargeSelf";
		}else if(jumpTo.equals("self/foreToSelf_withoutLogin.do")){
			lastJump="Fore/ChargeSelf_withoutLogin";
		}
		return lastJump;
	}
	
	/**
	 *   支付失败后，跳转回个人充值界面
	 */
	
	@RequestMapping("/foreFailedToSelf.do")
	public String failedToRecharge(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("失败");
//		try {
//			response.setContentType("text/html;charset=utf-8");
//			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//					+ request.getContextPath() + "/";
//			PrintWriter out = response.getWriter();
//			out.println("<script type='text/javascript'>alert('充值失败！'); location.href='" + path
//					+ "pay/toRecharge.do';</script>");
//			out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
		
		//跳转的页面
		String jumpTo="";
		RedisSession session = baseUtil.getSession(response, request);
		String selfType=(String)session.getAttribute("selfType", String.class);
		if(selfType.equals("loginYes")) {
			jumpTo="self/foreToSelf.do";
		}else if(selfType.equals("loginNo")) {
			jumpTo="self/foreToSelf_withoutLogin.do";
		}
		
		
		String lastJump="";
		if(jumpTo.equals("self/foreToSelf.do")) {
			lastJump="Fore/ChargeSelf";
		}else if(jumpTo.equals("self/foreToSelf_withoutLogin.do")){
			lastJump="Fore/ChargeSelf_withoutLogin";
		}
		return lastJump;
		
		
	}
	
}
