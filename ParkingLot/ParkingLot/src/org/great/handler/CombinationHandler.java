package org.great.handler;
/**
 * 套餐缴费  宏琪大哥
 * @author Administrator
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Combo;
import org.great.bean.Cust;
import org.great.bean.Park;
import org.great.biz.ComboBiz;
import org.great.biz.ParkBiz;
import org.great.util.BaseUtil;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/Combination")
public class CombinationHandler {
	@Resource
	ComboBiz comboBiz;
	@Resource
	BaseUtil baseUtil;
	
	@RequestMapping("/toPay.action")
	public String toPay(HttpServletRequest request) {
		List<Combo> comList = comboBiz.FindCombo();
		request.setAttribute("comListhq", comList);
		return "CombinationPay";
	}
	
	//提交 缴费表单
		@RequestMapping("/moneyTo_Combination.pay")
		public String moneyTo_Combination(HttpServletRequest request,HttpServletResponse response,String WIDsubject, String WIDout_trade_no,String WIDbody,String WIDtotal_amount) {
			System.out.println("订单名称="+WIDsubject);
			System.out.println("商户订单号="+WIDout_trade_no);
			System.out.println("商品描述="+WIDbody);
			System.out.println("金额="+WIDtotal_amount);
			request.setAttribute("WIDsubject", WIDsubject);
			request.setAttribute("WIDout_trade_no", WIDout_trade_no);
			request.setAttribute("WIDbody", WIDbody);
			request.setAttribute("WIDtotal_amount", WIDtotal_amount);
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			RedisSession session = baseUtil.getSession(response, request);
			session.setAttribute("PayType", "套餐缴费");
			
			String path=request.getScheme()+"://"+request.getServerName()+":"+
					request.getServerPort()+request.getContextPath()+"/";
			return "../../"+"alipay.trade.page.pay";
		}
		
		
		/**
		 *   支付成功后，跳转回界面
		 */
		
		@RequestMapping("/successToCombination.action")
		public String successToRecharge(HttpServletRequest request,HttpServletResponse response,String out_trade_no,String trade_no ,String total_amount) {
			System.out.println("成功");
			System.out.println("商户订单号="+out_trade_no);
			System.out.println("支付宝交易号="+trade_no);
			System.out.println("付款金额="+total_amount);
			List<Combo> comList = comboBiz.FindCombo();
			request.setAttribute("comListhq", comList);
			try {
			
			response.setContentType("text/html;charset=utf-8");
			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>alert('支付成功'); location.href='" + path
					+ "Combination/toPay.action';</script>");
			out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			return "CombinationPay";
		}
		
		/**
		 *   支付失败后，跳转回缴费界面
		 */
		
		@RequestMapping("/failedToCom.do")
		public String failedToRecharge(HttpServletRequest request,HttpServletResponse response) {
			System.out.println("失败");
			try {
				response.setContentType("text/html;charset=utf-8");
				String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath() + "/";
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>alert('支付失败'); location.href='" + path
						+ "Combination/toPay.action';</script>");
				out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "CombinationPay";
		}
}
