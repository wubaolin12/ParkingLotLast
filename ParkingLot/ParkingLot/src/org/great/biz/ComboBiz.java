package org.great.biz;

import java.util.List;

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
}
