package org.great.biz;

import java.util.List;

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
}
