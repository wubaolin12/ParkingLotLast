package org.great.mapper;

import java.util.List;

import org.great.bean.Stopcartime;
import org.springframework.stereotype.Repository;

/**
 * 停车时间表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface StopcartimeMapper {

	//添加停车开始时间
	public int AddStopBeginTime(Stopcartime sct);
	
	//查找该车是否在停车中
	public List<Stopcartime> FindSctByNumber(int number);
}
