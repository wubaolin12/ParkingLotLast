package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Combo;
import org.springframework.stereotype.Repository;

/**
 * 套餐表Maooer
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface ComboMapper {

	/**所有套餐信息 
	 * 
	 * @return
	 */
	public List<Combo> FindCombo();
	/**
	 * 根据主键查套餐信息 -->
	 */
	public Combo  FindComboByIDX(int id);
	
	public Combo  getComboObject(String id);
	
	public List<Combo> seachCombo(@Param("dataMap")Map map);
}
