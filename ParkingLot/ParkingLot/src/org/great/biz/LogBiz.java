package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.Log;

/**
 * 日志表BIZ			
 * @author 野比欣之助
 *
 */
public interface LogBiz {

	public List<Log> logList();
	
	public List<Log> searchLog(Map map);
}
