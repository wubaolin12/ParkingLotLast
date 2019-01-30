package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.great.bean.vo.UserMsg;
import org.springframework.stereotype.Repository;

/**
 * 员工表，角色表，参数表
 * 
 * @author Administrator
 *
 */
@Repository
public interface UserMsgMapper {

	/**
	 * yf获取用户信息
	 * @return
	 */
	public List<UserMsg> findUserMsg(@Param("dataMap")Map map);
	
	/**
	 * 获取一个用户对象
	 * @param id
	 * @return
	 */
	public UserMsg getUserObject (@Param("u_id")String u_id);
	
	
	//public int getCountNum(@Param("dataMap")Map map);
}
