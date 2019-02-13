package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Sche;
import org.great.mapper.ScheMapper;
import org.springframework.stereotype.Service;

/**
 * 排班表Impl实现类(tb_sche)
 * 
 * @author 健哥(佩奇)
 *
 */
@Service("scheBiz")
public class ScheBizImpl implements ScheBiz {

	@Resource
	private ScheMapper scheMapper;

	@Override
	public List<Sche> getScheByUserID(int uid) {
		// TODO Auto-generated method stub
		return scheMapper.getScheByUserID(uid);
	}
}
