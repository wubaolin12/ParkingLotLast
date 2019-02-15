package org.great.handler;
/**
 * 套餐缴费  宏琪大哥
 * @author Administrator
 *
 */

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.Combo;
import org.great.bean.Park;
import org.great.biz.ComboBiz;
import org.great.biz.ParkBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/Combination")
public class CombinationHandler {
	@Resource
	ComboBiz comboBiz;
	
	
	@RequestMapping("/toPay.action")
	public String toPay(HttpServletRequest request) {
		List<Combo> comList = comboBiz.FindCombo();
		request.setAttribute("comListhq", comList);
		return "CombinationPay";
	}
}
