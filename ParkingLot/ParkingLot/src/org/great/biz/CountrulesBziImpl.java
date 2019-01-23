package org.great.biz;

import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Countrules;
import org.great.mapper.CountrulesMapper;
import org.springframework.stereotype.Service;

/**
 * 计费规则表Impl实现类(tb_countrules)				
 * @author 健哥
 *
 */
@Service("countrulesBzi")
public class CountrulesBziImpl implements CountrulesBiz{
	@Resource
	private CountrulesMapper countrulesMapper;

	private boolean flag;
	@Override
	public Countrules findCountrulRoleX(Map<String, String> map) {
		// TODO Auto-generated method stub
		 return countrulesMapper.findCountrulRoleX(map);
	}

	@Override
	public Countrules findCountrulRoleEqualsX(Map<String, String> map) {
		// TODO Auto-generated method stub
		return countrulesMapper.findCountrulRoleEqualsX(map);
	}

}
