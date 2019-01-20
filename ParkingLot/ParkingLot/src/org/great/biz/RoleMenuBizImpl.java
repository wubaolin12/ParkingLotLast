package org.great.biz;

import javax.annotation.Resource;

import org.great.bean.RoleMenu;
import org.great.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

/**
 * 	角色菜单关系表biz实现类
 * @author 吴宝林
 *
 */
@Service("roleMenuBiz")
public class RoleMenuBizImpl implements RoleMenuBiz {

	@Resource
	private RoleMenuMapper roleMenuMapper;
	
	@Override
	public boolean del(RoleMenu rm) {
		int ret = roleMenuMapper.del(rm);
		
		boolean flag = false;
		//如果大于0，删除成功
		if(ret>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean insert(RoleMenu rm) {
		int ret = roleMenuMapper.insert(rm);
		
		boolean flag = false;
		//如果大于0，删除成功
		if(ret>0) {
			flag = true;
		}
		return flag;
	}

}
