package org.great.biz;

import org.great.bean.Vip;

/**
 * 车辆套餐表BIZ						
 * @author 野比欣之助
 *
 */
public interface VipBiz {
	/**添加车联包月信息
	 * 
	 * @param vip
	 * @return
	 */
	public boolean AddvipX(Vip vip);

	/**
	 * 根据video更改结束时间即续费包月
	 * 
	 * @param vip
	 * @return
	 */
	public boolean chageOvertimeByVidX(Vip vip);

	/**
	 * 	自动判断是否到期
	 * @param date
	 * @return
	 */
	public boolean updateVipStu(String date);
}
