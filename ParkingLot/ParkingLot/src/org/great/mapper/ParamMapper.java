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
	/**根据类型和名字查询ID
	 * 
	 * @return
	 */
	public Param GetPmIDByTypeNmaeX(Param param);
}
