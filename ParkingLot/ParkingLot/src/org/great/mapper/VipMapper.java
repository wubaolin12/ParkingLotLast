package org.great.mapper;

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
	 * 根据video更改结束时间即续费包月
	 * 
	 * @param vip
	 * @return
	 */
	public boolean chageOvertimeByVidX(Vip vip);

}
