package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Param;
import org.great.mapper.ParamMapper;
import org.springframework.stereotype.Service;

/**
 * 参数表Impl实现类(param)		
 * @author 健哥
 *
 */
@Service("paramBiz")
public class ParamBizImpl implements ParamBiz{
	@Resource
	private ParamMapper paramMapper;

	@Override
	public Param GetPmIDByTypeNmaeX(Param param) {
		// TODO Auto-generated method stub
		return paramMapper.GetPmIDByTypeNmaeX(param);
	}

}
