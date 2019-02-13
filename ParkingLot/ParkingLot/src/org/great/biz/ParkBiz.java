package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.Park;

/**
 * 车位表BIZ							
 * @author 野比欣之助
 *
 */
public interface ParkBiz {
	public boolean AddPark(Park park);
	public List<Park> FindList(Park park);
	public List<Park> FindAll(Park park);
	public boolean setState(Park park);
	public List<Park> FindGroup();
	public List<Park> FindMapID(String id);
	public List<Park> FindForeAndNum(Park park);
	public Park FindByID(String id);
	public boolean UpdatePark(Park park);
	public int EmptyCount(String p_fore);
	public int OccupiedCount(String p_fore);
	public int EmptyCount_close(String p_fore);
	
	/**
	 * 添加车位当前照片
	 * @param park
	 */
	public int addPicture(Park park);
	
	/**
	 * 查询可以停车的车位
	 */
	public List<Park> FindAllCanStopX(@Param("p_state")String p_state,@Param("pm_id")int pm_id);
	/**
	 * 修改车id 车位状态ID
	 * @param park
	 * @return
	 */
	public boolean SetCarParkX(Park park);
}
