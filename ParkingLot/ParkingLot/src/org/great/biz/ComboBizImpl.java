package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Combo;
import org.great.mapper.ComboMapper;
import org.springframework.stereotype.Service;

/**
 * 套餐表Impl实现类
 * @author 健哥
 *
 */
@Service("comboBiz")
public class ComboBizImpl implements ComboBiz{

	@Resource
	ComboMapper comBoMapper;
	@Override
	public List<Combo> FindCombo() {
		// TODO Auto-generated method stub
		return comBoMapper.FindCombo();
	}
	@Override
	public Combo FindComboByIDX(int id) {
		// TODO Auto-generated method stub
		return comBoMapper.FindComboByIDX(id);
	}
	@Override
	public Combo getComboObject(String id) {
		// TODO Auto-generated method stub
		return comBoMapper.getComboObject(id);
	}
	@Override
	public List<Combo> seachCombo(Map map) {
		// TODO Auto-generated method stub
		return comBoMapper.seachCombo(map);
	}

}
