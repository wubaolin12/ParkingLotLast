package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	
	/**
	 * 查询可以停车的车位
	 */
	public List<Park> FindAllCanStopX(@Param("p_state")String p_state,@Param("pm_id")int pm_id);
	
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
	
	/**
	 * 修改车id 车位状态ID
	 * @param park
	 * @return
	 */
	public boolean SetCarParkX(Park park);
	
}
