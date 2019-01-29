package org.great.biz;

import java.util.List;

import org.great.bean.Param;

/**
 * 参数表BIZ	
 * @author 野比欣之助
 *
 */
public interface ParamBiz {
	
	public List<Param> getParamList();
	
	public Param getParamObject(String id);
}
