package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Vip;
import org.springframework.stereotype.Repository;

/**
 * 车辆套餐表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface VipMapper {

	/**
	 * 添加车联包月信息
	 * 
	 * @param vip
	 * @return
	 */
	public boolean AddvipX(Vip vip);

	/**
	 * 根据video更改结束时间即续费包月--续费
	 * 
	 * @param vip
	 * @return
	 */
	public boolean chageOvertimeByVidX(Vip vip);

	/**
	 * 更改月缴状态
	 * 
	 * @return
	 * @author 吴宝林
	 * @param date
	 * 
	 */
	public boolean updateVipStu(String date);

	/**
	 * 根据车ID参数类型参数名称查询VIP表信息
	 * 
	 * @return
	 */
	public List<Vip> findVipPmIDX(@Param("c_id") int c_id, @Param("pm_type") String pm_type,
			@Param("pm_name") String pm_name);

	/**
	 * 根据车id查询vip表信息
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

	/**
	 * 月缴套餐自动生效
	 * @return
	 */
	public boolean activeVip();
}
