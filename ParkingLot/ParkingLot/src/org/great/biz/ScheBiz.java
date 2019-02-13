package org.great.biz;

import java.util.List;

import org.great.bean.Sche;

/**
 * 排班表BIZ			
 * @author 野比欣之助
 *
 */
public interface ScheBiz {
	/**根据员工ID查询排班
	 * 
	 * @return
	 */
	public List<Sche> getScheByUserID(int uid);
}
