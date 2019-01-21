package org.great.mapper;

import java.util.List;

import org.great.bean.Cust;
import org.springframework.stereotype.Repository;

/**
 * 用户表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface CustMapper {
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
	public List<Cust> findCustAllX();
}
