package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.bean.Countrules;
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
	public Countrules findCountrulRoleX(Map<String, String> map);

	/**
	 * 查询计费的规则，注：只能查到开始时间和结束时间相等的规则 例如：开始时间8结束时间8
	 * 
	 * @param time
	 * @return
	 */
	public Countrules findCountrulRoleEqualsX(Map<String, String> map);
}
