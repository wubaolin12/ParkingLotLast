package org.great.mapper;

import java.util.List;

import org.great.bean.Sche;
import org.springframework.stereotype.Repository;

/**
 * 排班表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface ScheMapper {
	/**根据员工ID查询排班
	 * 
	 * @return
	 */
	public List<Sche> getScheByUserID(int uid);
}
