package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Log;
import org.springframework.stereotype.Repository;

/**
 * 日志表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface LogMapper {

	public List<Log> logList();
	
	public List<Log> seachLog(@Param("dataMap")Map map);
}
