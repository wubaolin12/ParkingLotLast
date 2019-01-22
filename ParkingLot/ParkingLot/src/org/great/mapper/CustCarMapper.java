package org.great.mapper;

import java.util.List;

import org.great.bean.Car;
import org.great.bean.Cust;
import org.springframework.stereotype.Repository;

/**
 * 用户表，车辆表，获取用户白名单列表
 * 
 * @author 健哥
 *
 */
@Repository
public interface CustCarMapper {
	//查找白名单用户列表
	public List<Cust> findWriteList();
	//取消白名单用户资格，更改参数pm_id参数
	public boolean cancleVip(int c_id);
}
