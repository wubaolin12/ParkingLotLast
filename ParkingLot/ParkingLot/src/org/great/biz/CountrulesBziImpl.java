package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Countrules;
import org.great.bean.Param;
import org.great.mapper.CountrulesMapper;
import org.springframework.stereotype.Service;

/**
 * 计费规则表Impl实现类(tb_countrules)				
 * @author 健哥
 *
 */
@Service("countrulesBiz")
public class CountrulesBziImpl implements CountrulesBiz{
	@Resource
	private CountrulesMapper countrulesMapper;

	private boolean flag;
	@Override
	public Countrules findCountrulRoleX(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 return countrulesMapper.findCountrulRoleX(map);
	}

	@Override
	public Countrules findCountrulRoleEqualsX(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return countrulesMapper.findCountrulRoleEqualsX(map);
	}

	@Override
	public List<Countrules> findRuleList() {
		// TODO Auto-generated method stub
		return countrulesMapper.findRuleList();
	}

	@Override
	public List<Countrules> findRuleListA() {
		// TODO Auto-generated method stub
		return countrulesMapper.findRuleListA();
	}

	@Override
	public List<Countrules> findRuleListB() {
		// TODO Auto-generated method stub
		return countrulesMapper.findRuleListB();
	}

	@Override
	public List<Param> findSelect() {
		// TODO Auto-generated method stub
		return countrulesMapper.findSelect();
	}

	@Override
	public List<Countrules> findSelectRuleList(String select) {
		// TODO Auto-generated method stub
		return countrulesMapper.findSelectRuleList(select);
	}

	@Override
	public boolean updateRule(Countrules c) {
		// TODO Auto-generated method stub
		return countrulesMapper.updateRule(c);
	}

	@Override
	public boolean planNameAdd(String planName) {
		// TODO Auto-generated method stub
		return countrulesMapper.planNameAdd(planName);
	}

	@Override
	public boolean start(String crpm_id) {
		// TODO Auto-generated method stub
		return countrulesMapper.start(crpm_id);
	}

	@Override
	public boolean start2(String crpm_id) {
		// TODO Auto-generated method stub
		return countrulesMapper.start2(crpm_id);
	}
	
	

}
