package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.Combo;

/**
 * 套餐表BIZ
 * @author 野比欣之助
 *
 */
public interface ComboBiz {
	/**所有套餐信息 
	 * 
	 * @return
	 */
	public List<Combo> FindCombo();
	/**
	 * 根据主键查套餐信息 -->
	 */
	public Combo  FindComboByIDX(int id);
	
	/**
	 * 获取套餐对象
	 * @param id
	 * @return
	 */
	public Combo getComboObject(String id);
	
	/**
	 * 搜索套餐
	 * @param map
	 * @return
	 */
	public List<Combo>seachCombo(Map map);
}
