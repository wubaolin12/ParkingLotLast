package org.great.biz;

import java.util.List;

import org.great.bean.Param;

/**
 * 参数表BIZ	
 * @author 野比欣之助
 *
 */
public interface ParamBiz {
	/**根据类型和名字查询ID
	 * 
	 * @return
	 */
	public Param GetPmIDByTypeNmaeX(Param param);
}
