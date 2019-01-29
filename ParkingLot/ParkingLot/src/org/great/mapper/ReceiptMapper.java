package org.great.mapper;

import java.util.List;

import org.great.bean.Receipt;
import org.springframework.stereotype.Repository;


/**
 * 收支明细表Mapper
 * 
 * @author 野比欣之助
 *
 */
@Repository
public interface ReceiptMapper {

	/**
	 * 每天定时生成日结单Excel文件
	 * @return
	 */
	 
	public List<Receipt> findDailyRecp(Receipt re);
}
