package org.great.biz;

import java.util.List;

import org.great.bean.Stopcartime;

/**
 * 停车时间表BIZ					
 * @author 野比欣之助
 *
 */
public interface StopcartimeBiz {

	//添加停车开始时间
			public boolean AddStopBeginTime(Stopcartime sct);
			
			//查找该车是否在停车中
			public List<Stopcartime> FindSctByNumber(int number);
}
