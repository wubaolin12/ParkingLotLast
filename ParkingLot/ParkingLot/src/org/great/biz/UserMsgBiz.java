package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.bean.User;
import org.great.bean.vo.UserMsg;

/**
 * 员工表，角色表，参数表BIZ
 * @author 野比欣之助
 *
 */
public interface UserMsgBiz {

	/**
	 * 用户信息列表
	 * @param map
	 * @return
	 */
	public List<UserMsg> userList(Map map);
	
	/**
	 * 获取一个用户对象
	 * @param id
	 * @return
	 */
	public UserMsg getUserObject(String id);
}
