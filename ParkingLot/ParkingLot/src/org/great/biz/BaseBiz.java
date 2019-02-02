package org.great.biz;

import java.util.Map;
/**
 * 通用biz接口
 * @author YF
 *
 */
public interface BaseBiz {

	


	public String creatSQL(String tb_name, Map map);
	/**
	 * 插入数据的方法
	 * @param tb_name
	 * @param map
	 * @param keymap
	 * @return
	 */
	public int insertData(String tb_name,Map map,Map keymap);
	/**
	 * 更新数据的方法
	 * @param tb_name
	 * @param map
	 * @param keykol
	 * @param i
	 * @return
	 */
	public int updateData(String tb_name,Map map,String keykol,String i);
	/**
	 * 删除数据的方法
	 * @param tb_name
	 * @param map
	 * @return
	 */
	public int delData(String tb_name,Map map);

}
