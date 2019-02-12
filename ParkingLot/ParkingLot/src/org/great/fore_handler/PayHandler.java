package org.great.fore_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Cust;
import org.great.bean.Menu;
import org.great.bean.Park;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.great.biz.CustBiz;
import org.great.biz.MenuBiz;
import org.great.biz.ParkBiz;
import org.great.biz.UserBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前端客户端管理
 * 
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/pay")
public class PayHandler {

	@Resource
	public CustBiz custBiz;  //用户dao接口
	
//	public List<Park>parkList;//所有的车位列表;
//	//public Park updatePark; //查询条件的车位;
//	String result = "usererror";
//	public List<Park>pForeList;//车位区号列表;
		
	
	/**
	 *  跳转个人充值界面
	 */
	
	@RequestMapping("/toRecharge.do")
	public String toRecharge() {
		return "Fore/Recharge";
	}
	
	/**
	 *   支付成功后，跳转回个人充值界面
	 */
	
	@RequestMapping("/successToRecharge.do")
	public String successToRecharge(HttpServletRequest request,HttpServletResponse response,String out_trade_no,String trade_no ,String total_amount) {
		System.out.println("成功");
		System.out.println("商户订单号="+out_trade_no);
		System.out.println("支付宝交易号="+trade_no);
		System.out.println("付款金额="+total_amount);
		//改变session里面foreuser的余额
		String str = total_amount.substring(0, total_amount.indexOf(".")) + total_amount.substring(total_amount.indexOf(".") + 1);
		int total_amount_int=Integer.parseInt(str)/100;
		System.out.println("金额="+total_amount_int);
		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		cust.setCust_money(cust.getCust_money()+total_amount_int);
		System.out.println(cust);
		//修改数据库的余额
		custBiz.chageCustMoneyByIDX(cust);
		return "Fore/Recharge";
	}
	
	/**
	 *   支付失败后，跳转回个人充值界面
	 */
	
	@RequestMapping("/failedToRecharge.do")
	public String failedToRecharge() {
		System.out.println("失败");
		return "Fore/Recharge";
	}
}
