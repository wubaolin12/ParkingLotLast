package org.great.biz;

import java.util.List;

import org.great.bean.Receipt;

/**
 * 收支明细表BIZ					
 * @author 野比欣之助
 *
 */
public interface ReceiptBiz {

	/**
	 * 	自动生成日结单Excel
	 * @param date
	 */
	public List<Receipt> findDailyRecp(Receipt re);
}
