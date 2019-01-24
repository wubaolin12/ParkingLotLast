package org.great.handler;

import javax.annotation.Resource;

import org.great.biz.BaseBiz;
import org.great.biz.MenuBiz;
import org.great.util.BaseUtil;

/**
 * 菜单管理handle
 * @author yf
 *
 */
public class MenuHandler extends BaseUtil{
	
	
	@Resource
	private BaseBiz bbiz;
	@Resource
	private MenuBiz mbiz;
	
	
}
