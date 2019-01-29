package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Car;
import org.great.bean.Cust;
import org.great.mapper.CustCarMapper;
import org.great.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 用户表,车辆表Impl实现类(tb_cust)									
 * @author 健哥
 *
 */
@Service("custCarBiz")
public class CustCarBizImpl implements CustCarBiz {

	
	@Resource
	private CustCarMapper custCarMapper;
	
	@Override 
	public List<Cust> findWriteList() {
		// TODO Auto-generated method stub
		return custCarMapper.findWriteList();
	}

	@Override
	public boolean cancleVip(int c_id) {
		// TODO Auto-generated method stub
		return custCarMapper.cancleVip(c_id);
	}
	
	//检索车辆添加白名单-检查
	@Override
	public Car selectNum(String carNum) {
		// TODO Auto-generated method stub
		return custCarMapper.selectNum(carNum);
	}
	//检索车辆添加白名单-添加
	@Override
	public boolean addWriteCar(String carNum) {
		// TODO Auto-generated method stub
		return custCarMapper.addWriteCar(carNum);
	}

	@Override
	public List<Cust> queryWriteList(String c_num) {
		// TODO Auto-generated method stub
		return custCarMapper.queryWriteList(c_num);
	}

}
