package org.great.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
 * 前端出场 缴费
 * 
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/outPay")
public class OutParkingLotHandler {

	@Resource
	public CustBiz custBiz;  //用户dao接口
	
//	public List<Park>parkList;//所有的车位列表;
//	//public Park updatePark; //查询条件的车位;
//	String result = "usererror";
//	public List<Park>pForeList;//车位区号列表;
		
	
	
	/**
	 *  跳转提交金额到二维码（出场缴费//套餐缴费）
	 * @throws UnsupportedEncodingException 
	 */
	
	@RequestMapping("/moneyTo_out.action")
	public String moneyTo_recharge(HttpServletRequest request,String WIDsubject, String WIDout_trade_no,String WIDbody,String WIDtotal_amount) throws UnsupportedEncodingException {
		System.out.println("订单名称="+WIDsubject);
		System.out.println("商户订单号="+WIDout_trade_no);
		System.out.println("商品描述="+WIDbody);
		System.out.println("金额="+WIDtotal_amount);
		request.setAttribute("WIDsubject", WIDsubject);
		request.setAttribute("WIDout_trade_no", WIDout_trade_no);
		request.setAttribute("WIDbody", WIDbody);
		request.setAttribute("WIDtotal_amount", WIDtotal_amount);
		request.getSession().setAttribute("PayType", "出场缴费");
		
		//防止乱码
		request.setCharacterEncoding("utf-8");
		
		String path=request.getScheme()+"://"+request.getServerName()+":"+
				request.getServerPort()+request.getContextPath()+"/";
		return "../../"+"alipay.trade.page.pay";
		
		
	}
	
	/**
	 *   支付成功后，跳转开闸界面
	 */
	
	@RequestMapping("/successToOut.action")
	public String successToRecharge(HttpServletRequest request,HttpServletResponse response,String out_trade_no,String trade_no ,String total_amount) {
		System.out.println("成功");
		System.out.println("商户订单号="+out_trade_no);
		System.out.println("支付宝交易号="+trade_no);
		System.out.println("付款金额="+total_amount);
		
		request.getSession().setAttribute("moneyFlag", 0);
		return "AppearanceCarAdmissionDisplay";
	}
	
	/**
	 *   支付失败后，跳转回个人充值界面
	 */
	
	@RequestMapping("/failedToRecharge.do")
	public String failedToRecharge(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("失败");
		return "AppearanceCarAdmissionDisplay";
	}
}
