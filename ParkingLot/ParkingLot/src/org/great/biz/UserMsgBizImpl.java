package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.User;
import org.great.bean.vo.UserMsg;
import org.great.mapper.UserMsgMapper;
import org.springframework.stereotype.Service;

/**
 * 员工表，角色表，参数表BizImpl
 * 
 * @author 野比欣之助
 *
 */
@Service("userMsgBiz")
public class UserMsgBizImpl implements UserMsgBiz {
	@Resource
	private UserMsgMapper umm;
	
	@Override
	public List<UserMsg> userList(Map map) {
		// TODO Auto-generated method stub
		return umm.findUserMsg(map);
	}

	@Override
	public UserMsg getUserObject(String id) {
		// TODO Auto-generated method stub
		return umm.getUserObject(id);
	}

}
