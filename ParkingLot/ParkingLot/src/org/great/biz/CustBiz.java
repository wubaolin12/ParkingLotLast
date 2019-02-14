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
	public Cust FindByPhone(String Pnumber);
	/**
	 * 查询客户所有
	 * 
	 * @return
	 */
	public List<Cust> findCustAllX();
	
	/**修改余额
	 * 
	 * @param cust
	 * @return
	 */
	public boolean chageCustMoneyByIDX(Cust cust);
	
	/**
	 * 前端登录 宏琪大哥
	 * 
	 * @return
	 */
	public Cust ForeLogin(Cust cust);
	
	/**
	 * 判断有没有重复 用户名  宏琪大哥
	 * 
	 * @return
	 */
	public List<Cust> FindByAcc(String cust_acc);
	
	/**
	 * 判断用户密码
	 * 
	 * @return
	 */
	public Cust checkUser(Cust cust);
}
