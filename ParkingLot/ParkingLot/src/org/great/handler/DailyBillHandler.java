package org.great.handler;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.great.bean.Receipt;
import org.great.biz.ReceiptBiz;
import org.great.log.OperationLog;
import org.great.util.DateTool;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 打印昨日订单
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/export")
public class DailyBillHandler {
	@Resource
	ReceiptBiz receiptBiz;

	@Resource
	Receipt receipt;

	@RequestMapping("/excel.action")
	@OperationLog(operationType = "收支明细", operationName = "下载昨天收支明细")
	@ResponseBody
	public void execute(HttpServletResponse response) throws Exception {

		String date = DateTool.getYesterdayDate(); // 获取昨天日期
		
		receipt.setRe_time(date);

		List<Receipt> list = receiptBiz.findDailyRecp(receipt);// 取得数据
		/*
		 * 第一件事情生成Excel
		 */
		try {
			// 1，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 2，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");

			// 3，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = hssfSheet.createRow(0);

			// 4，创建单元格，并设置值表头 设置表头居中
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

			// 5，写入实体数据
			for (int i = 0; i < list.size(); i++) {
				row = hssfSheet.createRow(i + 1);
				Receipt re = list.get(i);

				// 6，创建单元格，并设置值
				row.createCell(0).setCellValue(re.getUser().getU_name());// 收费员

				row.createCell(1).setCellValue(re.getRe_thing());// 收费类型

				row.createCell(2).setCellValue(re.getCar().getC_num());// 车牌号

				row.createCell(3).setCellValue(re.getRe_money());// 金额

				row.createCell(4).setCellValue(re.getRe_time());// 时间
			}
			
			// 将文件导出到用户前端保存
			String fileName = date+"收支明细.xls";
			fileName = new String(fileName.getBytes(),"ISO8859-1");
			response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();

			// 7，将文件输出到服务器
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			FileOutputStream fos = new FileOutputStream("D:/file_file/demo/recipt-"+date+".xls");//指定路径与名字和格式
//			try {
//				workbook.write(fos);
//				fos.flush();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				fos.close();
//				
//			}
						
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("导出信息失败！");
		}
		
		/*
		 * 第二件事情，将办理的套餐生效
		 */
		
	}
	
	/**
	 * 第三件事情，半小时判断一次车位预约失效
	 */

}
