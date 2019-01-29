package org.great.util;

import javax.annotation.Resource;

import org.great.biz.BaseBiz;
import org.great.biz.RoleBiz;
import org.great.mapper.RoleMapper;
/**
 *  提起加载biz的类
 * @author ASUS yf
 *
 */

public class BizCup {
	
	@Resource
	public static BaseBiz bbiz;
	
	@Resource
	public static RoleBiz rbiz;
	
	@Resource
	public static RoleMapper rolemapper;
}
