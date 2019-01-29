package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Log;
import org.great.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
 * 日志表Impl实现类(log)			
 * @author 健哥
 *
 */
@Service("logBiz")
public class LogBizImpl implements LogBiz{

	@Resource
	private LogMapper logmapper;
	
	@Override
	public List<Log> logList() {
		// TODO Auto-generated method stub
		return logmapper.logList();
	}

	@Override
	public List<Log> searchLog(Map map) {
		// TODO Auto-generated method stub
		return logmapper.seachLog(map);
	}

	
}
