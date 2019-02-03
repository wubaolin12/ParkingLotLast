package org.great.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Menu;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.great.biz.MenuBiz;
import org.great.biz.UserBiz;
import org.great.log.OperationLog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	后台管理端主界面跳转
 * @author 吴宝林
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/main")
public class MainHandler {

	@Resource
	public UserBiz userBiz;
	@Resource
	private MenuBiz menuBiz;
	
	/**
	 * 	跳转到管理端首页
	 */
	@RequestMapping("/main.action")
	@OperationLog(operationType = "登录操作", operationName = "进入主页")
	public String mainJsp(HttpServletRequest request) {
		
//		HttpSession session = request.getSession(); 
//		User users = (User) session.getAttribute("User");
		User users = (User) request.getAttribute("User");
		
		// 角色关系
		RoleRel re = userBiz.FindStaffRole(users.getU_id());

		List<Menu> menuList = menuBiz.findMenu(re.getRole_id());
		request.setAttribute("menuList", menuList);
		return "main";
	}
	

	
}
