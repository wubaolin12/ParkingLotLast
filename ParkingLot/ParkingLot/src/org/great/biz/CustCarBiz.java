package org.great.biz;

import java.util.List;

import org.great.bean.Car;
import org.great.bean.Cust;





/**
 *  用户表，车辆表 BIZ
 * @author 健哥
 *
 */
public interface CustCarBiz {
	//查找白名单用户列表
	public List<Cust> findWriteList();
	//取消白名单用户资格，更改参数pm_id参数
	public boolean cancleVip(int c_id);
	//检索车辆添加白名单-检查
	public Car selectNum(String carNum);
	//检索车辆添加白名单-添加
	public boolean addWriteCar(String carNum);
	//模糊查询
	public List<Cust> queryWriteList(String c_num);

}
