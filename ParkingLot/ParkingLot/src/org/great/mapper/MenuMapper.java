package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.Menu;
import org.great.bean.RoleMenu;
import org.springframework.stereotype.Repository;

/**
 * 菜单表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface MenuMapper {

	/**
	 *  查找菜单
	 * @param role(角色id)
	 * @return MenuList
	 * @author 吴宝林
	 */
	public List<Menu> findMenu(int role_id);

	/**
	 * 查找未分配菜单
	 * @param role_id
	 * @return
	 * @author 吴宝林
	 */
	public List<Menu> findUnallot(int role_id);

	/**
	 * 	计算子节点(子目录)数量
	 * @param rm
	 * @return
	 */
	public int getCount(RoleMenu rm);
	
	/**
	 * 获取菜单列表
	 * @param sql
	 * @param rb
	 * @return
	 */
	public List<Menu> findMenList(String sql,RowBounds rb);
	
	/**
	 *  获取菜单列表
	 * @return
	 * @author yf
	 */
	public List<Menu> getMenuList();
	
	public List<Menu>seachMenu(@Param("dataMap")Map map);
	
	/**
	 * 获取一个对象
	 * @param id
	 * @return
	 */
	public Menu getMenuObject(@Param("menu_id")String id);
}
