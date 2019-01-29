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

	/**参数列表
	 * @author ASUS yf
	 */
	@Override
	public List<Param> getParamList() {
		// TODO Auto-generated method stub
		return paramMapper.paramList();
	}

	
	/**获取参数对象
	 * @author ASUS yf
	 */
	@Override
	public Param getParamObject(String id) {
		// TODO Auto-generated method stub
		return paramMapper.getParamObject(id);
	}

}
