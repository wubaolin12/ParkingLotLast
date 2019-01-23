package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * 通用型mapper，提供通用的DAO方法，xml文件支持传入sql语句
 * @author yf 
 *
 */


@Repository
public interface Mapper
{
	
	//获取某个表的类名
	/**
	 * 获取表字段名的方法
	 * @param sql
	 * @return
	 */
	public List<String> getColname(String tb_name);
	
	//增加记录
	public int interObject(String sql);
	
	public int updateObject(String sql);
	
	public int delObject(String sql);
	//获取记录数
	public int getCordnum(String sql);
	
	public int insertData(@Param("dataMap") Map<String, String> dataMap,@Param("tb_name")String tb_name);
}
