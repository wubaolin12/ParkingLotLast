package org.great.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *	生成日账单Excel文件;
 *	Excel表格功能编写
 *
 * @author 吴宝林
 *
 */
/*
 * 使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
 *	若返回json等内容到页面，则需要加@ResponseBody注解
 */
@RestController
@RequestMapping("/bill")
public class DailyBillHandler {

}
