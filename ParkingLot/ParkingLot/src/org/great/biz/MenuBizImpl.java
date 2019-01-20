package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Menu;
import org.great.bean.RoleMenu;
import org.great.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
 * 菜单表Impl实现类
 * 
 * @author 健哥
 *
 */
@Service("menuBiz")
public class MenuBizImpl implements MenuBiz {

	@Resource
	MenuMapper menuMapper;

	@Override
	public List<Menu> findMenu(int role_id) {

		List<Menu> menuList = menuMapper.findMenu(role_id);

		return menuList;
	}

	@Override
	public List<Menu> findUnallot(int role_id) {
		
		List<Menu> menuList = menuMapper.findUnallot(role_id);

		return menuList;
	}

	@Override
	public int getCount(RoleMenu rm) {
		int count = menuMapper.getCount(rm);
		return count;
	}

}
