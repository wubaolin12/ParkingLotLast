package org.great.biz;

import java.util.List;

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

	//通过车的ID找到该车的所有停车记录
	@Override
	public List<Stopcartime> FindSctByNumber(int number) {
		
		return stopcartimeMapper.FindSctByNumber(number);
	}

	//修改出场时间
	@Override
	public boolean UpdateSctTimeandState(Stopcartime sct) {
		
		int count = stopcartimeMapper.UpdateSctTimeandState(sct);

		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}

	//通过主键ID找到该停车表的信息
	@Override
	public Stopcartime FindByID(int id) {
		
		
		return stopcartimeMapper.FindByID(id);
	}

	@Override
	public boolean UpdateSctMoneyX(Stopcartime sct) {
		// TODO Auto-generated method stub
		return stopcartimeMapper.UpdateSctMoneyX(sct);
	}

}
