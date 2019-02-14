package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Cust;
import org.great.mapper.CustMapper;
import org.springframework.stereotype.Service;

/**
 * 用户表Impl实现类(tb_cust)
 * 
 * @author 健哥
 *
 */
@Service("custBiz")
public class CustBizImpl implements CustBiz {
	@Resource
	private CustMapper custMapper;

	@Override
	public List<Cust> FindByPhoneX(String Pnumber) {
		// TODO Auto-generated method stub
		return custMapper.FindByPhoneX(Pnumber);
	}

	@Override
	public boolean AddCustX(Cust cust) {
		// TODO Auto-generated method stub
		return custMapper.AddCustX(cust);
	}

	@Override
	public List<Cust> findCustAllX() {
		// TODO Auto-generated method stub
		return custMapper.findCustAllX();
	}

	@Override
	public boolean chageCustMoneyByIDX(Cust cust) {
		// TODO Auto-generated method stub
		return custMapper.chageCustMoneyByIDX(cust);
	}

	@Override
	public Cust ForeLogin(Cust cust) {
		// TODO Auto-generated method stub
		return custMapper.ForeLogin(cust);
	}

	@Override
	public List<Cust> FindByAcc(String cust_acc) {
		// TODO Auto-generated method stub
		return custMapper.FindByAcc(cust_acc);
	}

	/**
	 * 验证用户
	 * @param cust
	 * @return
	 */
	@Override
	public Cust checkUser(Cust cust)
	{
		return custMapper.checkUser(cust);
		
	}
	
	@Override
	public Cust FindByPhone(String Pnumber) {
		// TODO Auto-generated method stub
		return custMapper.FindByPhone(Pnumber);
	}
	


	/**
	 * 验证唯一性
	 * @author ASUS yf
	 */
	@Override
	public List<Cust> checkCust(Map map) {
		// TODO Auto-generated method stub
		return custMapper.checkCust(map);
	}

	/**
	 * 通过用户Id找到用户对象
	 * @author ASUS yf
	 */
	@Override
	public Cust FindByID(Cust cust) {
		// TODO Auto-generated method stub
		return custMapper.FindByID(cust);
	}


}
