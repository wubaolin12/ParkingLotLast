package org.great.biz;

import java.util.List;

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
	public List<Cust> ForeLogin(Cust cust) {
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
}
