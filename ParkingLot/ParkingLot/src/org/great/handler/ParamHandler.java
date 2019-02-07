package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Param;
import org.great.bean.Role;
import org.great.biz.BaseBiz;
import org.great.biz.ParamBiz;
import org.great.log.OperationLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

/**
 * 参数管理
 * @author ASUS yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/parammanage")
public class ParamHandler {

	@Resource
	private ParamBiz pbiz;	
	@Resource
	private BaseBiz bbiz;
	@Value("tb_param")
	private String tb_name;
	
	private String result;
	
	/**
	 * 跳转修改参数页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */
	@RequestMapping("/toUpdateParam.action")
	public String toUpdateParam(HttpServletRequest request) 
	{
		
		String id=request.getParameter("pm_id");
		System.out.println("-----ParamHandler,toUpdateparam++ID="+id);
				
		Param param=pbiz.getParamObject(id);
		request.setAttribute("paramObject", param);
		result="param/update-param";
		return result;
		
	}
	
	/**
	 * 跳转增加参数页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */	
	@RequestMapping("/toInsertParam.action")
	public String toInsertParam(HttpServletRequest request) 
	{
		System.out.println("-----PramHandler,toInsertParam");

		result="param/add-param";
		return result;
		
	}
	
	
	/**
	 * 获取参数列表
	 * @param request
	 * @param resp
	 * @return
	 * @author ASUSyf
	 */
	@RequestMapping("/paramlist.action")
	public String paramList(HttpServletRequest request, HttpServletResponse resp) 
	{
		System.out.println("-----PARAMHandler,plist");
		
		List<Param>plist=pbiz.getParamList();
		request.setAttribute("plist", plist);
		
		result="param/param-list";
		return result;
		
	}
	
	/**
	 * 查询菜单
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@RequestMapping("/seachParamList.action")
	public String seachparamList(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----roleHandler,seachmenuList");
		
		map.put("pm_name", map.get("seachword"));
		
		map.remove("seachword");
		
		//List<Menu> mlist=mbiz.seachMenu(map);
		
		//request.setAttribute("mlist", mlist);
		
		result="param/param-list";
		return result;
		
	}
	
	/**
	 * 增加参数
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_yf
	 */
	@OperationLog(operationType = "系统管理", operationName = "增加参数")	
	@RequestMapping("/insertParam.action")
	public String insertParam(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----paramHandler,insertparam");
		

		int num=bbiz.insertData(tb_name, map,null);	
		
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	/**
	 * 更新参数
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@OperationLog(operationType = "系统管理", operationName = "修改参数")	
	@RequestMapping("/updatePram.action")
	public String updateParam(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		String id=request.getParameter("pm_id");
		System.out.println("-----paramHandler,updateparam"+id);
		
		int num=bbiz.updateData(tb_name, map, "pm_id", id);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	/**
	 * 修改参数的方法
	 * @param response
	 * @param request
	 * @param map
	 * @return
	 */
	@OperationLog(operationType = "系统管理", operationName = "修改参数")	
	@ResponseBody
	@RequestMapping(value = "/updateParamAjax.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String updateParamAjax(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("--------updateParamAjax");
		System.out.println(map.toString());
		int num=bbiz.updateData(tb_name, map, "pm_id", map.get("pm_id"));		
		if(num>0) {
			Param param=pbiz.getParamObject(map.get("pm_id"));
			JSONObject json = JSONObject.fromObject(param);
			String jstr=json.toString();
			
			result=jstr;
		}
		return result;
		
	}
	
	
	/**
	 * 删除菜单
	 * @param request
	 * @return
	 * @author ASUS_yf
	 */
	@OperationLog(operationType = "系统管理", operationName = "删除参数")	
	@RequestMapping("/delParam.action")
	public String delParam(HttpServletRequest request) 
	{
		System.out.println("-----paramHandler,param");
		String id=request.getParameter("pm_id");
		Map map=new HashMap<>();
		map.put("pm_id", id);
		
		int num=bbiz.delData(tb_name, map);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
}
