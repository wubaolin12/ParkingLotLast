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

}
