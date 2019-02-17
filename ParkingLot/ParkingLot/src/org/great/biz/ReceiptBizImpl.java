package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Receipt;
import org.great.mapper.ReceiptMapper;
import org.springframework.stereotype.Service;

/**
 * 收支明细表Impl实现类(tb_receipt)
 * 
 * @author 健哥
 *
 */
@Service("receiptBiz")
public class ReceiptBizImpl implements ReceiptBiz {

	@Resource
	ReceiptMapper receiptMapper;

	@Override
	public List<Receipt> findDailyRecp(Receipt re) {

		// 获取时间

		return receiptMapper.findDailyRecp(re);
	}

	@Override
	public List<Receipt> findCountMoneyReX(String re_time1, String re_time2) {
		// TODO Auto-generated method stub
		return receiptMapper.findCountMoneyReX(re_time1, re_time2);
	}

	@Override
	public boolean AddReceiptX(Receipt receipt) {
		// TODO Auto-generated method stub
		return receiptMapper.AddReceiptX(receipt);
	}

	//获取收支明细列表
	@Override
	public List<Receipt> findReceiptList() {
		// TODO Auto-generated method stub
		return receiptMapper.findReceiptList();
	}

	@Override
	public List<Receipt> findQueryReceiptList(String datemin, String datemax, String carNum) {
		// TODO Auto-generated method stub
		return receiptMapper.findQueryReceiptList(datemin, datemax, carNum);
	}

	@Override
	public int InCome() {
		// TODO Auto-generated method stub
		return receiptMapper.InCome();
	}

	@Override
	public int Refund() {
		// TODO Auto-generated method stub
		return receiptMapper.Refund();
	}

	@Override
	public int ParkinBout() {
		// TODO Auto-generated method stub
		return receiptMapper.ParkinBout();
	}

	@Override
	public int monthUserInCome() {
		// TODO Auto-generated method stub
		return receiptMapper.monthUserInCome();
	}

	@Override
	public int temporaryUserInCome() {
		// TODO Auto-generated method stub
		return receiptMapper.temporaryUserInCome();
	}

	@Override
	public int temporaryUserInCome1() {
		// TODO Auto-generated method stub
		return receiptMapper.temporaryUserInCome1();
	}

	@Override
	public int temporaryUserInCome2() {
		// TODO Auto-generated method stub
		return receiptMapper.temporaryUserInCome2();
	}

	@Override
	public int temporaryUserInCome3() {
		// TODO Auto-generated method stub
		return receiptMapper.temporaryUserInCome3();
	}

	@Override
	public int temporaryUserInCome4() {
		// TODO Auto-generated method stub
		return receiptMapper.temporaryUserInCome4();
	}



}
