package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.bean.Countrules;
import org.great.bean.Param;
import org.great.bean.vo.NewRule;
import org.springframework.stereotype.Repository;

/**
 * 计费规则表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface CountrulesMapper {

	/**
	 * 根据时间查询计费的规则，注：只能查到开始时间和结束时间不相等的规则 例如：开始时间8结束时间8
	 * 
	 * @param time
	 * @return
	 */
	public Countrules findCountrulRoleX(Map<String, Object> map);

	/**
	 * 查询计费的规则，注：只能查到开始时间和结束时间相等的规则 例如：开始时间8结束时间8
	 * 
	 * @param time
	 * @return
	 */
	public Countrules findCountrulRoleEqualsX(Map<String, Object> map);
	
	/**
	 *  查找计费规则列表
	 * 
	 * @return
	 */	
	public List<Countrules> findRuleList();
	
	/**
	 *  查找计费规则列表A方案ajax显示
	 * 
	 * @return
	 */	
	public List<Countrules> findRuleListA();
	
	
	/**
	 *  查找计费规则列表B方案ajax显示
	 * 
	 * @return
	 */	
	public List<Countrules> findRuleListB();
	
	/**
	 *  获取修改计费规则下拉框值
	 * 
	 * @return
	 */	
	public List<Param> findSelect();
	
	/**
	 *  通过下拉框参数查询计费规则数据
	 * 
	 * @return
	 */	
	public List<Countrules> findSelectRuleList(String select);
	
	/**
	 *  修改每条具体数据内容
	 * 
	 * @return
	 */	
	public boolean updateRule(Countrules c);
	
	/**
	 * 添加新的方案名
	 * 
	 * @return
	 */	
	public boolean planNameAdd(String planName);
	
	/**
	 * 改规则状态为启用
	 * 
	 * @return
	 */	
	public boolean start(String crpm_id);
	/**
	 * 改规则状态其他未启用
	 * 
	 * @return
	 */	
	public boolean start2(String crpm_id);
	/**
	 * 添加新规则
	 * 
	 * @return
	 */	
	public boolean newRule(NewRule n);
	/**
	 * 删除规则
	 * 
	 * @return
	 */	
	public boolean delRule(String cr_id);
}
