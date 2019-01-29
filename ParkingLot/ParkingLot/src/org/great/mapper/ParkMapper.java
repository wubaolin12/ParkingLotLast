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
	public int setState(Park park);
}
