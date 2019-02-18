package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	/**
	 * 查询所有的收费情况进行统计
	 * 
	 * @param re
	 * @return
	 */
	public List<Receipt> findCountMoneyReX(@Param("re_time1") String re_time1, @Param("re_time2") String re_time2);
	/**
	 * 添加收支表记录
	 * 
	 * @param receipt
	 * @return
	 */
	public boolean AddReceiptX(Receipt receipt);
	
	/**
	 * 	查找收支明细
	 * @param date
	 */
	public List<Receipt> findReceiptList();
	
	/**
	 * 	条件带参数查询收支明细
	 * @param date
	 */
	public List<Receipt> findQueryReceiptList(@Param("datemin") String datemin,@Param("datemax") String datemax,@Param("carNum") String carNum);
	
	/**
	 * 	收入
	 * @param date
	 */
	public int InCome();
	/**
	 * 	退费
	 * @param date
	 */
	public int Refund();
	/**
	 * 	停车总场次
	 * @param date
	 */
	public int ParkinBout();
	/**
	 * 	月缴用户收入
	 * @param date
	 */
	public int monthUserInCome();
	/**
	 * 	月缴用户收入
	 * @param date
	 */
	public int temporaryUserInCome();
	
	/**
	 * 	月缴用户套餐1
	 * @param date
	 */
	public int temporaryUserInCome1();
	/**
	 * 	月缴用户套餐2
	 * @param date
	 */
	public int temporaryUserInCome2();
	/**
	 * 	月缴用户套餐3
	 * @param date
	 */
	public int temporaryUserInCome3();
	/**
	 * 	月缴用户套餐4
	 * @param date
	 */
	public int temporaryUserInCome4();
}
