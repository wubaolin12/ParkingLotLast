package org.great.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.great.bean.Receipt;
import org.great.biz.ReceiptBiz;
import org.great.tools.DateTool;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * springMVC 定时任务处理； 定时打印订单
 * 
 * @author Administrator
 *
 */
@Controller
public class DailyBillHandler {

//	@Scheduled(cron = "0 53 20 * * ?")
//	@Scheduled(cron = "*/10 * * * * ?")

	@Resource
	ReceiptBiz receiptBiz;

	@Resource
	Receipt receipt;

	@Scheduled(cron = "0 53 20 * * ?")
	public void cron() throws Exception {

//		String date = DateTool.getDate(); // 获取当天日期
		String date = "2019-01-22";
		
		receipt.setRe_time(date);

		List<Receipt> list = receiptBiz.findDailyRecp(receipt);// 取得数据

		for (Receipt r : list) {
			System.out.println("-----list---" + r.toString());

		}

		/*
		 * 生成Excel
		 */
		try {
			// 第一步，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");

			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = hssfSheet.createRow(0);

			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

			// 居中样式
			hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);

			HSSFCell hssfCell = null;
			String[] titles = { "收费员", "收费类型", "车牌号", "金额", "时间" };
			for (int i = 0; i < titles.length; i++) {
				hssfCell = row.createCell(i);// 列索引从0开始
				hssfCell.setCellValue(titles[i]);// 列名1
				hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
			}

			// 第五步，写入实体数据

			for (int i = 0; i < list.size(); i++) {
				row = hssfSheet.createRow(i + 1);
				Receipt re = list.get(i);

				// 第六步，创建单元格，并设置值
				row.createCell(0).setCellValue(re.getUser().getU_name());// 收费员

				row.createCell(1).setCellValue(re.getRe_thing());// 收费类型

				row.createCell(2).setCellValue(re.getCar().getC_num());// 车牌号

				row.createCell(3).setCellValue(re.getRe_money());// 金额

				row.createCell(4).setCellValue(re.getRe_time());// 时间
			}

			// 第七步，将文件输出到服务器
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileOutputStream fos = new FileOutputStream("D:/file_file/demo/recipt-"+date+".xls");//指定路径与名字和格式
			try {
				workbook.write(fos);
				fos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				fos.close();
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("导出信息失败！");

		}
	}

}
