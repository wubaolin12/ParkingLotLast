package org.great.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Combo;
import org.great.bean.Role;
import org.great.biz.BaseBiz;
import org.great.biz.ComboBiz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 套餐业务类
 * @author ASUS yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/combomanage")
public class ComboHandler {
	
	@Resource
	private ComboBiz cbiz;
	
	@Resource
	private BaseBiz bbiz;
	@Value("tb_comno")
	private String tb_name;
	
	private String result;
	
	/**
	 * 跳转修改套餐页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */
	@RequestMapping("/toUpdateCombo.action")
	public String toUpdateCombo(HttpServletRequest request) 
	{
		
		String id=request.getParameter("co_id");
		System.out.println("-----ComboHandler,toUpdatecombo++ID="+id);

		Combo combo=cbiz.getComboObject(id);
		request.setAttribute("comboObject", combo);
		result="update-combo";
		return result;
		
	}
	
	/**
	 * 跳转增加套餐页面
	 * @param request
	 * @return
	 * @author ASUS——yf
	 */	
	@RequestMapping("/toInsertCombo.action")
	public String toInsertCombo(HttpServletRequest request) 
	{
		System.out.println("-----ComboHandler,toInsertCombo");

		result="add-combo";
		return result;
		
	}
	
	
	/**
	 * 获取套餐列表
	 * @param request
	 * @param resp
	 * @return
	 * @author ASUS yf
	 */
	@RequestMapping("/comboList.action")
	public String comboLis(HttpServletRequest request, HttpServletResponse resp) 
	{
		System.out.println("-----comboLisHandler,comboLis");
		
		List<Combo>clist=cbiz.FindCombo();
		
		request.setAttribute("clist", clist);
		
		result="combo-list";
		return result;
		
	}
	
	/**
	 * 查询套餐
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@RequestMapping("/seachcomboList.action")
	public String seachcomboList(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----seachcomboListHandler,seachcomboList");
		
		map.put("co_price", map.get("seachword"));
		
		map.put("co_standard", map.get("seachword"));
		
		map.remove("seachword");

		
		result="combo-list";
		return result;
		
	}
	
	/**
	 * 增加套餐
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_yf
	 */
	@RequestMapping("/insertCombo.action")
	public String insertCombo(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("-----insertComboHandler,insertCombo");
		

		int num=bbiz.insertData(tb_name, map,null);	
		
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	/**
	 * 更新套餐
	 * @param request
	 * @param map
	 * @return
	 * @author ASUS_YF
	 */
	@RequestMapping("/updateCombo.action")
	public String updateCombo(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		String id=request.getParameter("role_id");
		System.out.println("-----updateComboHandler,updateCombo"+id);
		
		int num=bbiz.updateData(tb_name, map, "co_id", id);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
	
	/**
	 * 删除菜单
	 * @param request
	 * @return
	 * @author ASUS_yf
	 */
	@RequestMapping("/delCombo.action")
	public String delCombo(HttpServletRequest request) 
	{
		System.out.println("-----delComboHandler,delCombo");
		String id=request.getParameter("co_id");
		Map map=new HashMap<>();
		map.put("co_id", id);
		
		int num=bbiz.delData(tb_name, map);
					
		
		if(num>0) {
			result="success";
		}else {
			result="error";
		}
		return result;
		
	}
}
