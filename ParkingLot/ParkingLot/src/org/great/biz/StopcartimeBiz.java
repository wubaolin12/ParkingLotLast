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
			
			//修改停车状态和停车时间
			public boolean UpdateSctTimeandState(Stopcartime sct);
			
			//通过主键ID查找该停车表的信息
			public Stopcartime FindByID(int id);
			
			/**修改停车金额
			 * 
			 * @param sct
			 * @return
			 */
			public boolean UpdateSctMoneyX(Stopcartime sct);
}
