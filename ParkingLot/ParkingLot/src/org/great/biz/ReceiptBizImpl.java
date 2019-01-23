package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.Receipt;
import org.great.mapper.ReceiptMapper;
import org.springframework.stereotype.Service;

/**
 * 收支明细表Impl实现类(tb_receipt)							
 * @author 健哥
 *
 */
@Service("receiptBiz")
public class ReceiptBizImpl implements ReceiptBiz{

	@Resource
	ReceiptMapper receiptMapper;
	
	@Override
	public List<Receipt> findDailyRecp(Receipt re) {
		
		
		//获取时间
		
		return receiptMapper.findDailyRecp(re);
	}

}
