package org.great.fore_handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.great.bean.Cust;
import org.great.biz.CustBiz;
import org.great.util.BaseUtil;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后端充值
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
	
	@Resource
	BaseUtil baseUtil;
	
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
	 *  跳转提交金额到二维码（充值）
	 */
	
	@RequestMapping("/moneyTo_recharge.do")
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
		session.setAttribute("PayType", "充值");
		
		 //response.setContentType("text/html;charset=utf-8");
//		String path=request.getScheme()+"://"+request.getServerName()+":"+
//				request.getServerPort()+request.getContextPath()+"/";
		return "../../"+"alipay.trade.page.pay";
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
		
		// 获取redissession，得到key对应 的值
		RedisSession session = baseUtil.getSession(response, request);
		Cust cust = (Cust) session.getAttribute("ForeUser", Cust.class);
		cust.setCust_money(cust.getCust_money()+total_amount_int);
		System.out.println(cust);
		//修改数据库的余额
		custBiz.chageCustMoneyByIDX(cust);
		
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
		return "Fore/Recharge";
	}
	
	/**
	 *   支付失败后，跳转回个人充值界面
	 */
	
	@RequestMapping("/failedToRecharge.do")
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
		
		return "Fore/Recharge";
		
		
	}
}
