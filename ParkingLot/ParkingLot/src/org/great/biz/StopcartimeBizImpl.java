package org.great.biz;

import javax.annotation.Resource;

import org.great.bean.Stopcartime;
import org.great.mapper.StopcartimeMapper;
import org.springframework.stereotype.Service;

/**
 * 停车时间表Impl实现类（tb_stopcartime）								
 * @author 健哥(佩奇)
 *
 */
@Service("stopcartimeBiz")
public class StopcartimeBizImpl implements StopcartimeBiz{

	@Resource
	private StopcartimeMapper stopcartimeMapper;
	
	private boolean flag;
	
	//增加停车时间
	@Override
	public boolean AddStopBeginTime(Stopcartime sct) {
		
		int count = stopcartimeMapper.AddStopBeginTime(sct);
		
		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}

}
