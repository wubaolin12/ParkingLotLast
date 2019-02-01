package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	/**
	 * 根据车ID参数类型参数名称查询VIP表信息
	 * 
	 * @return
	 */
	public List<Vip> findVipPmIDX(@Param("c_id") int c_id, @Param("pm_type") String pm_type,
			@Param("pm_name") String pm_name);
	/**根据车id查询vip表信息
	 * 
	 * @param c_id
	 * @return
	 */
	public List<Vip> findVipX(int c_id);
	/**
	 * 根据V_id删除信息记录
	 * 
	 * @param v_id
	 * @return
	 */
	public boolean VipReturnX(int v_id);
}
