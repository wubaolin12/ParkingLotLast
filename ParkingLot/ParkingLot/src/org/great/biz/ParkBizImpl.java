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
 * @author 健哥
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
		int count = parkMapper.setState(park);
		
		if (count > 0) {

			flag = true;
		} else {

			flag = false;
		}
		
		return flag;
	}

}
