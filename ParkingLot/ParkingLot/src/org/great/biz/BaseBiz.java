package org.great.biz;

import java.util.Map;
/**
 * 通用biz接口
 * @author YF
 *
 */
public interface BaseBiz {

	
	public int insertObject(String tb_name,Map map);
	
	public int updateObject(String tb_name, Map map, String key, int keyid);
	
	public int delObject(String tb_name,String colname,int id);

}
