package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Vip;
import org.great.mapper.VipMapper;
import org.springframework.stereotype.Service;

/**
 * 车辆套餐表Impl实现类(tb_vip)							
 * @author 健哥(佩奇)
 *
 */
@Service("vipBiz")
public class VipBizImpl implements VipBiz{
	@Resource
	VipMapper VipMapper;
	@Override
	public boolean AddvipX(Vip vip) {
		// TODO Auto-generated method stub
		return VipMapper.AddvipX(vip);
	}
	@Override
	public boolean chageOvertimeByVidX(Vip vip) {
		// TODO Auto-generated method stub
		return VipMapper.chageOvertimeByVidX(vip);
	}
	@Override
	public boolean updateVipStu(String date) {
		
		boolean flag = VipMapper.updateVipStu(date);
		
		return flag;
	}
	@Override
	public List<Vip> findVipPmIDX(int c_id, String pm_type, String pm_name) {
		// TODO Auto-generated method stub
		return VipMapper.findVipPmIDX(c_id, pm_type, pm_name);
	}
	@Override
	public List<Vip> findVipX(int c_id) {
		// TODO Auto-generated method stub
		return VipMapper.findVipX(c_id);
	}
}
