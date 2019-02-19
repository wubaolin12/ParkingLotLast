package org.great.handler;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Menu;
import org.great.bean.Park;
import org.great.bean.ParkState;
import org.great.bean.RoleRel;
import org.great.bean.User;
import org.great.biz.MenuBiz;
import org.great.biz.ParkBiz;
import org.great.biz.UserBiz;
import org.great.util.BaseUtil;
import org.great.util.RedisSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 停车场里 车辆查看
 * 
 * @author 宏琪大哥
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/ParkView")
public class ParkViewHandler {

	@Resource
	public ParkBiz parkBiz; 
	@Resource
	BaseUtil baseUtil;
	
	public List<Park>parkList;//所有的车位列表;
	//public Park updatePark; //查询条件的车位;
	String result = "usererror";
	public List<Park>pForeList;//车位区号的列表
	/**
	 * 	无查询条件的所有列表
	 */
	
	@RequestMapping("/allList.action")
	public String LookCar(HttpServletRequest request,HttpServletResponse response) {
		Park p=new Park(0, null, 0, null,null);
		parkList=parkBiz.FindAll(p);
		System.out.println("长度"+parkList.size());
		request.setAttribute("parkList", parkList);
		pForeList=parkBiz.FindGroup();
		
		RedisSession session = baseUtil.getSession(response, request);
		session.setAttribute("pForeList", pForeList);
		return "ParkView";
	}

	/**
	 * 有条件的查询
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	//@RequestMapping()(value = "/findPark.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@RequestMapping("/findPark.action")
	public String findPark(HttpServletRequest request, Park updatePark) {
		System.out.println("__有条件____");
		System.out.println(updatePark);
		if(updatePark.getP_state().equals("所有")) {
			updatePark.setP_state(null);
		}
		if(updatePark.getP_fore().equals("所有")) {
			updatePark.setP_fore(null);
		}
		if(updatePark.getC_num().equals("")) {
			parkList=parkBiz.FindAll(updatePark);

		}else {
		
		parkList=parkBiz.FindList(updatePark);
		}
		request.setAttribute("parkList", parkList);
		return "ParkView";
	}
	/**
	 * 	跳转查看分区状态界面
	 */
	
	@RequestMapping("/jumpState.action")
	public String jumpState(HttpServletRequest request ) {
		List<ParkState> stateList=new ArrayList<ParkState>();
		pForeList=parkBiz.FindGroup();
		System.out.println("区号长度"+pForeList.size());
		request.getSession().setAttribute("pForeList", pForeList);
		for (int i = 0; i < pForeList.size(); i++) {
			//查空车位数 开放
			int emptyCount=parkBiz.EmptyCount(pForeList.get(i).getP_fore());
			//查空车位数 维护
			int emptyCount_close=parkBiz.EmptyCount_close(pForeList.get(i).getP_fore());
			//查占有数
			int occupiedCount=parkBiz.OccupiedCount(pForeList.get(i).getP_fore());
			ParkState ps=new ParkState(pForeList.get(i).getP_fore(), emptyCount, occupiedCount,emptyCount_close);
			stateList.add(ps);
		}
		for (int i = 0; i < stateList.size(); i++) {
			System.out.println("我要的++++++"+stateList.get(i));
		}
		request.setAttribute("stateList", stateList);
		return "Park_Realtime_Status";
	}
	
	@RequestMapping("/findForeInfo.action")
	public String findForeInfo(HttpServletRequest request,String p_fore ) {
		List<ParkState> stateList=new ArrayList<ParkState>();
		pForeList=parkBiz.FindGroup();
		System.out.println("区号长度"+pForeList.size());
		request.getSession().setAttribute("pForeList", pForeList);
			//查空车位数 开放
			int emptyCount=parkBiz.EmptyCount(p_fore);
			//查空车位数 维护
			int emptyCount_close=parkBiz.EmptyCount_close(p_fore);
			//查占有数
			int occupiedCount=parkBiz.OccupiedCount(p_fore);
			ParkState ps=new ParkState(p_fore, emptyCount, occupiedCount,emptyCount_close);
			stateList.add(ps);
		request.setAttribute("stateList", stateList);
		return "Park_Realtime_Status";
	}
	
	
}
