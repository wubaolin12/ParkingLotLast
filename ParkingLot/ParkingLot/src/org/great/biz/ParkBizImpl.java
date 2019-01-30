package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Car;
import org.great.bean.Park;
import org.great.mapper.CarMapper;
import org.great.mapper.ParkMapper;
import org.springframework.stereotype.Service;

/**
 * 车位表Impl实现类(tb_park)							
 * @author 健哥,宏琪大哥
 *
 */
@Service("parkBiz")
public class ParkBizImpl implements ParkBiz{
	@Resource
	private ParkMapper parkMapper;

	private boolean flag;//标记
	@Override
	public boolean AddPark(Park park) {
		// TODO Auto-generated method stub
		int count = parkMapper.AddPark(park);
		
		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}
	@Override
	public List<Park> FindList(Park park) {
		// TODO Auto-generated method stub
		List<Park> list=parkMapper.FindList(park);
		return list;
	}
	@Override
	public List<Park> FindAll(Park park) {
		// TODO Auto-generated method stub
		List<Park> list=parkMapper.FindAll(park);
		return list;
	}
	@Override
	public boolean setState(Park park) {
		// TODO Auto-generated method stub
		int count = parkMapper.SetState(park);
		
		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}
	@Override
	public List<Park> FindGroup() {
		// TODO Auto-generated method stub
		List<Park> list=parkMapper.FindGroup();
		return list;
	}
	@Override
	public List<Park> FindMapID(String id) {
		// TODO Auto-generated method stub
		List<Park> list=parkMapper.FindMapID(id);
		return list;
	}
	@Override
	public List<Park> FindForeAndNum(Park park) {
		// TODO Auto-generated method stub
		List<Park> list=parkMapper.FindForeAndNum(park);
		return list;
	}
	@Override
	public Park FindByID(String id) {
		// TODO Auto-generated method stub
		Park p=parkMapper.FindByID(id);
		return p;
	}
	@Override
	public boolean UpdatePark(Park park) {
		// TODO Auto-generated method stub
		int count = parkMapper.UpdatePark(park);
		
		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}
	@Override
	public int EmptyCount(String p_fore) {
		// TODO Auto-generated method stub
		return parkMapper.EmptyCount(p_fore);
	}
	@Override
	public int OccupiedCount(String p_fore) {
		// TODO Auto-generated method stub
		return parkMapper.OccupiedCount(p_fore);
	}
	@Override
	public int EmptyCount_close(String p_fore) {
		// TODO Auto-generated method stub
		return parkMapper.EmptyCount_close(p_fore);
	}
	
}
