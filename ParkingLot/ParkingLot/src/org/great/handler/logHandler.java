package org.great.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Log;
import org.great.bean.Menu;
import org.great.biz.LogBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 日志查看业务
 * @author ASUS YF
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/logmanage")
public class logHandler {
	
	@Resource
	private LogBiz lbiz;
	
	private String result;
	@RequestMapping("/logList.action")
	public String menuList(HttpServletRequest request, HttpServletResponse resp) 
	{
		System.out.println("-----logHandler,rlist");
		
		List<Log> llist=lbiz.logList();
		
		request.setAttribute("llist", llist);
		
		result="log-list";
		return result;
		
	}
	
	/**
	 * 查询菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@RequestMapping("/seachlogList.action")
	public String seachmenuList(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----logHandler,seachList");
		
		map.put("u_id", map.get("seachword"));
		map.put("log_event", map.get("seachword"));
		map.put("log_date", map.get("seachword"));
		map.remove("seachword");
		
		List<Log> llist=lbiz.searchLog(map);
		
		request.setAttribute("llist", llist);
		
		result="menu-list";
		return result;
		
	}

}
