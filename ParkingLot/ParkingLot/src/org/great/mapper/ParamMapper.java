package org.great.mapper;

import java.util.List;

import org.great.bean.Param;
import org.springframework.stereotype.Repository;

/**
 * 参数表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface ParamMapper {

	/**
	 * 参数列表
	 * @return
	 * @author ASUS yf
	 */
	public List<Param> paramList();
	
	public Param getParamObject(@org.apache.ibatis.annotations.Param("pm_id")String id);
	
}
