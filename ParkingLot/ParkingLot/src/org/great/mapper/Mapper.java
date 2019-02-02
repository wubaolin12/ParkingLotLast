package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.great.bean.User;
import org.springframework.stereotype.Repository;

/**
 * 
 * 通用型mapper，提供通用的DAO方法
 * @author yf 
 *
 */


@Repository
public interface Mapper
{
	
	/**删除记录
	 * 
	 * @param dataMap
	 * @param tb_name
	 * @return
	 */
	public int delData(@Param("dataMap") Map<String, String> dataMap,@Param("tb_name")String tb_name);
	
	/**修改记录
	 * 
	 * @param dataMap
	 * @param tb_name
	 * @param keykol
	 * @param id
	 * @return
	 */
	public int updateData(@Param("dataMap") Map<String, String> dataMap,
			@Param("tb_name")String tb_name,@Param("keycol")String keykol,@Param("keyid")String id);

	/**插入记录
	 * 
	 * @param dataMap
	 * @param dataMap2
	 * @param tb_namel
	 * @return
	 */
	public int insertData(@Param("dataMap") Map<String,String> dataMap,@Param("dataMap2") Map<String,String> dataMap2,@Param("tb_name")String tb_name);
}
