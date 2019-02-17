package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Receipt;
import org.great.biz.CountrulesBiz;
import org.great.biz.ReceiptBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *收支明细
 * 
 * @author 健哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/billingDetails")
public class BillingDetailsHandler {
	//装配bean包
		@Resource
		private ReceiptBiz receiptBiz;
	/**
	 * 	跳转收支明细界面
	 */
	@RequestMapping("/jumpshow.action")
	public String jumpbilling(HttpServletRequest request) {	
		
		//收支界面列表
		List<Receipt> receiptList  = receiptBiz.findReceiptList();
		System.err.println("收支明细表receiptList="+receiptList);
		
		HttpSession session = request.getSession();				
		session.setAttribute("receiptList", receiptList);
		
		return "billingDetails";
	}
	
	/**
	 * 	跳转数据统计界面
	 */
	@RequestMapping("/DataStatistics.action")
	public String DataStatistics(HttpServletRequest request) {	

		
		return "billingDetailsStatistics";
	}
	
	/**
	 * 	时间条件查询
	 */
	@RequestMapping("/conditionQuery.action")
	public String conditionQuery(String datemin, String datemax, String carNum,HttpServletRequest request) {	
		System.out.println("最小时间："+datemin+"最大时间："+datemax+"车牌号："+carNum);
		
		String datemin1 = null;
		String datemax1 = null;
		String carNum1 = null;
		
		//条件查询获得界面数据方法
		
		if (datemin != null && datemin != "") {
			datemin1 = datemin;
		}
		if (datemax != null && datemax != "") {
			datemax1 = datemax;
		}
		if(carNum != null && carNum != "") {
			carNum1 = carNum;
		}
		
		System.err.println("-------------最小时间："+datemin1+"最大时间："+datemax1+"车牌号："+carNum1);
		
		List<Receipt> receiptList  = receiptBiz.findQueryReceiptList(datemin1, datemax1, carNum1);	
		
		System.err.println("模糊查询收支明细表"+receiptList);
		
		HttpSession session = request.getSession();				
	    session.setAttribute("receiptList", receiptList);
		
		return "billingDetails";
	}
}
