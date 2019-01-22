package org.great.biz;

import java.util.List;

import org.great.bean.Cust;

/**
 * 用户表BIZ								
 * @author 野比欣之助
 *
 */
public interface CustBiz {
	/**
	 * 添加一个客户用户
	 * 
	 * @param cust
	 * @return
	 */
	public boolean AddCustX(Cust cust);
	/**
	 * 通过手机号找到客户信息
	 * 
	 * @return
	 */
	public List<Cust> FindByPhoneX(String Pnumber);
	/**
	 * 查询客户所有
	 * 
	 * @return
	 */
	public List<Cust> findCustAllX();
	/**
	 * 查询该客户下的车辆信息
	 * 
	 * @param Pnumber
	 * @return
	 */
	public List<Cust> findCustCarX(String Pnumber);
}
