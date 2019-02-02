package org.great.mapper;

import java.util.List;

import org.great.bean.Park;
import org.springframework.stereotype.Repository;

/**
 * 车位表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface ParkMapper {
	public int AddPark(Park park) ;
	/*
	 * 多条件查询
	 */
	public List<Park> FindList(Park park); 
	/*
	 * 初始化查询所有列表
	 */
	public List<Park> FindAll(Park park);
	public int SetState(Park park);
	/*
	 * 找车区分组
	 */
	public List<Park> FindGroup();
	public List<Park> FindMapID(String id);
	public List<Park> FindForeAndNum(Park park);
	public Park FindByID(String id);
	
	public int UpdatePark(Park park);
	public int EmptyCount(String p_fore);
	public int OccupiedCount(String p_fore);
	public int EmptyCount_close(String p_fore);
	
	/**
	 * 添加图片
	 * @param park
	 * @return
	 */
	public int addPicture(Park park);
}
