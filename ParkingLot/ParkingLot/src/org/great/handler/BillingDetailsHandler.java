package org.great.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Receipt;
import org.great.bean.vo.DataStatistics;
import org.great.biz.CountrulesBiz;
import org.great.biz.ReceiptBiz;
import org.great.util.BaseUtil;
import org.great.util.DateTool;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收支明细
 * 
 * @author 健哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/billingDetails")
public class BillingDetailsHandler {
	// 装配bean包
	@Resource
	private ReceiptBiz receiptBiz;
	
	@Resource
	BaseUtil baseUtil;

	/**
	 * 跳转收支明细界面
	 */
	@RequestMapping("/jumpshow.action")
	public String jumpbilling(HttpServletRequest request,HttpServletResponse response) {

		// 收支界面列表
		List<Receipt> receiptList = receiptBiz.findReceiptList();
		System.err.println("收支明细表receiptList=" + receiptList);

//		HttpSession session = request.getSession();
//		RedisSession session = baseUtil.getSession(response, request);
		request.setAttribute("receiptList", receiptList);

		return "billingDetails";
	}

	/**
	 * 跳转数据统计界面
	 */
	@RequestMapping("/DataStatistics.action")
	public String DataStatistics(HttpServletRequest request) {

		return "billingDetailsStatistics";
	}

	/**
	 * 时间条件查询
	 */
	@RequestMapping("/conditionQuery.action")
	public String conditionQuery(String datemin, String datemax, String carNum, HttpServletRequest request) {
		System.out.println("最小时间：" + datemin + "最大时间：" + datemax + "车牌号：" + carNum);

		String datemin1 = null;
		String datemax1 = null;
		String carNum1 = null;

		// 条件查询获得界面数据方法

		if (datemin != null && datemin != "") {
			datemin1 = datemin;
		}
		if (datemax != null && datemax != "") {
			datemax1 = datemax;
		}
		if (carNum != null && carNum != "") {
			carNum1 = carNum;
		}
		
		
		try {
			datemax1 = DateTool.getNextDate(datemax1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		DateFormat f = new SimpleDateFormat("yyyy-mm-dd");
//		
//		try {
//			Date date = f.parse(datemax1);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Calendar calendar = Calendar.getInstance();
//		
//		Calendar calendar1 = Calendar.getInstance();
//		
//		calendar.setTime(datemax1);
//		
//		calendar1.setTime(datemax1);
//
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
//		calendar1.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);// 让日期加1
		
		System.err.println("-------------最小时间：" + datemin1 + "最大时间：" + datemax1 + "车牌号：" + carNum1);

		List<Receipt> receiptList = receiptBiz.findQueryReceiptList(datemin1, datemax1, carNum1);

		System.err.println("模糊查询收支明细表" + receiptList);

//		HttpSession session = request.getSession();
		request.setAttribute("receiptList", receiptList);

		return "billingDetails";
	}

	/**
	 * 时间条件查询
	 */
	@RequestMapping("/findDataStatistics.action")
	public String conditionQuery(HttpServletRequest request) {
		System.err.println("进入方法啦啦啦阿拉拉阿拉啦啦");
		// 收入
		int income = receiptBiz.InCome();
		System.out.println("收入" + income);
		// 退费
		int refund = receiptBiz.Refund();
		System.out.println("退费" + refund);
		// 总收入=(收入-退费 )
		int allCome = income - refund;
		// 停车总场次
		int parkinbout = receiptBiz.ParkinBout();
		System.out.println("停车总场次" + parkinbout);
		// 月缴用户收入
		int monthUserInCome = receiptBiz.monthUserInCome();
		System.out.println("月缴用户收入" + monthUserInCome);
		// 临时用户收入
		int temporaryUserInCome = receiptBiz.temporaryUserInCome();
		System.out.println("临时用户收入" + temporaryUserInCome);
		// 月缴套餐收入1
		int temporaryUserInCome1 = (receiptBiz.temporaryUserInCome1()) * 300;
		System.out.println("月缴套餐收入1" + temporaryUserInCome1);
		// 月缴套餐收入2
		int temporaryUserInCome2 = (receiptBiz.temporaryUserInCome2()) * 600;
		System.out.println("月缴套餐收入2" + temporaryUserInCome2);
		// 月缴套餐收入3
		int temporaryUserInCome3 = (receiptBiz.temporaryUserInCome3()) * 800;
		System.out.println("月缴套餐收入3" + temporaryUserInCome3);
		// 月缴套餐收入4
		int temporaryUserInCome4 = (receiptBiz.temporaryUserInCome4()) * 1200;
		System.out.println("月缴套餐收入4" + temporaryUserInCome4);
		DataStatistics d = new DataStatistics(allCome, parkinbout, monthUserInCome, temporaryUserInCome,
				temporaryUserInCome1, temporaryUserInCome2, temporaryUserInCome3, temporaryUserInCome4);
//		HttpSession session = request.getSession();
		request.setAttribute("dataStatistics", d);
		return "billingDetailsStatistics";
	}
}
