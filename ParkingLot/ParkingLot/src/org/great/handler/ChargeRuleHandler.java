package org.great.handler;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Countrules;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.biz.CountrulesBiz;
import org.great.biz.CustCarBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *计费规则
 * 
 * @author 健哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/ChargeRule")
public class ChargeRuleHandler {
	//装配bean包
	@Resource
	private CountrulesBiz countrulesBiz;
	
	/**
	 * 	跳转计费规则界面
	 */
	@RequestMapping("/jumpshow.action")
	public String jumpbilling(HttpServletRequest request) {	
		//计费规则列表
		List<Countrules> ruleList = countrulesBiz.findRuleList();
		HttpSession session = request.getSession();				
		session.setAttribute("ruleList", ruleList);	
		System.out.println("ruleList="+ruleList);

		return "ChargeRule";
	}
	
	/**
	 * 	计费规则状态更改
	 */
	@RequestMapping("/changeState.action")
	public @ResponseBody boolean changeState(HttpServletRequest request,String cr_id,String pm_id) {	
		
		boolean a = false;
		
		boolean b = false;
		
		boolean c = false;
		
		System.err.println("............哪一条规则= "+cr_id+" 当前状态= "+pm_id);
		

			
		a  = countrulesBiz.start(cr_id);
			
		b  = countrulesBiz.start2(cr_id);
			
		System.err.println("...................计费规则状态更改a ="+a );
			
		System.err.println("...................计费规则状态更改b ="+b );
	

		if(a==true && b ==true) {
			c =true;
		}

		return c;
	}
	
	/**
	 * 	跳转计费规则修改界面
	 */
	@RequestMapping("/jumpUpdate.action")
	public String jumpUpate(HttpServletRequest request) {
		
		//获取计费规则下拉框取值
		List<Param> ruleSelect = countrulesBiz.findSelect();
		
		System.err.println(".........ruleSelect="+ruleSelect);
		
		HttpSession session = request.getSession();				
		session.setAttribute("ruleSelect", ruleSelect);	
		
		return "ChargeRuleUpdate";
		}
	
	
	/**
	 * 	跳转计费规则添加界面
	 */
	@RequestMapping("/jumpAdd.action")
	public String jumpAdd(HttpServletRequest request) {	
		return "ChargeRuleAdd";
	}
	
	
	/**
	 * 	ajax显示计费规则
	 */
	@RequestMapping("/ruleData.action")
	public @ResponseBody List<Countrules> showPlan(String select) {
		
		List<Countrules> ruleList = countrulesBiz.findSelectRuleList(select);	
		
		System.err.println("查询A方案ruleList="+ruleList);
		
		return ruleList;
}
	
	
	/**
	 * 	新增计费规则方案名
	 */
	@RequestMapping("/planNameAdd.action")
	public @ResponseBody String planAdd(String planName) {
		
		boolean a  = countrulesBiz.planNameAdd(planName);	
		
		System.err.println("新增方案名="+a);
		
		return "方案名添加成功";
}
	
	/**
	 * 	修改具体规则参数
	 */
	@RequestMapping("/updateRule.action")
	public @ResponseBody String updateRule(String cr_id,String cr_starttime,String cr_overtime,String cr_fristmoney,String cr_addmoney) {

//		int cr_id, double cr_starttime, double cr_overtime, int cr_fristmoney, int cr_addmoney
		
		
		System.err.println("修改具体规则="+cr_id+" "+cr_starttime+" "+cr_overtime+" "+cr_fristmoney+" "+cr_addmoney);
		int cr_id1 = Integer.valueOf(cr_id);
		
		double cr_starttime1 = Double.valueOf(cr_starttime);
		
		double cr_overtime1 = Double.valueOf(cr_overtime);
		
		int cr_fristmoney1 = Integer.valueOf(cr_fristmoney);
		
		int cr_addmoney1 = Integer.valueOf(cr_addmoney);
		
		Countrules c = new Countrules(cr_id1,cr_starttime1,cr_overtime1,cr_fristmoney1,cr_addmoney1);
		
		boolean a = countrulesBiz.updateRule(c);
		
		System.out.println("修改数据=   "+a);
		
		return "success";
	}
}
