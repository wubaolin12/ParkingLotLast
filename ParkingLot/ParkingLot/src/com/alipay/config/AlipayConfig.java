package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *   支付宝支付工具  @宏琪大哥
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500592402";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHo7rW33DNd121mQHFJc3Q4GnSKRskqUx1bdFzQvxyt6MLGjF5h14gstBL9NjphspFdCYd927OIv00T25jqtTCpPO1TpxpG24gY8mLVH4se7h07SE/zf7/Jdt8IDNT7MP6QYZz+H6ChkECzMS4vbnB23R5HUqHghQ02cC/ob9RY+s/2sko/YPYkapTcIU8lky/b908qj/2Iwf8JTubLOo7Bx3w2NDGbcvq8K565YaCl5a3fENm1Ir+sZwwAXkGk+zdXNXemRYP4SjF+xKIBbzGH5ekeF8CELv/CXou5BM4RfsUiIkFVt13YRgOzCSflOa/iF5kzCSoBMqoGg54Qn5XAgMBAAECggEANJC/2WPr563OVsp61NYnYyAzvMpmAzkwkJrh01+H6QzBOWMkM8OY3TM39Uf69UIwcCktACbuXgiIcwWXI1cPvlCAevS/6kz2qkCcCLuunTfWUbM+VfZ/dd8Z84zm9uoYkARAyrhbVzLSW1JfWeVay9hkyp8TyKpPd7r+LXcBUQRu/F0CXb2Ld3hqC2xkSTNrJIO5zVigYkMagDWmRyvWYvrOcvzhTNms7brB2T7oHxOC2OaQN+GfhCcfyQtE+fx5saMukYD9Ge3Pt3sskXL4T7gB5dHnS05ze231AJkj8uDtFCVil+5ZTRPK4W9iX/ZBEHdpE1MFcZTIR6jd48dzQQKBgQDr3IZ1Infp0+JL4P8YdownlIFczpO2lMVjJdZq3f3CcChFofB92s84pDvvib+w4/aUJES3FYiv6RWa6XSmKnj1fWEpS8mvOFgYw+SvVWCjj4QFWxDNVcVdlneoW+NwVpKRSexjfLdrc0kY8XI9AvcZLYg17axJYYm4e3eLc1+XewKBgQDYr3cAq0F1oHVt0aZ7DSKl8KzGrLeBRFr2Us3ynGVuEhATzSMgkq5z1XydafTMRgmKo7FrWL780s+S5ccgZpZXp7bVr+Tnc4+Q0dvvabiJVEYYbmCcCjTWQDIniPi8VsTcPuIR3z9pieSbdjYf4JzWm/aFl1h1BUpiGd2nB6fP1QKBgBWM3KwvLg2rUm3kbOprSnsDUp6MMWrpRO++MU0qY1k0rjlOho65Q13Fg8RrLZyX95uphK3FxetsvJCe7A2Sq+KiRhJj3lWoLER3AZoTjvTi1Ak5PNvGDnZynRRA8RL+lf24Z2TfrFKhAfjJdsqkTrd6NYvX33oE83Rrs4yGSiGpAoGAcqEwhUwTzxRZywTz23jxcXPHEztfwKTWsiTQCp6uEfLASpllEeBHJcQ0rlnVRRNwDMXYH//M2Zb0dLPWCc/7jNeOo7DvmXnK40QB47+7/fp1MouB1EqZ9RX08nFFlO0aK6Ggmu/NbhmitJNuwqJili3f1oBgLVflJ8yjM6+bGRkCgYEAxV56jATfAa2h7se+PtBcoJIpzVAi5r50fc4bT6/YngmxF2vJJoWPcRJ2JHLVfNWPZvuny/p7DkttqzWwGqP/+CCt76JTbvb3pAw6+MAmWAJfoqNegWyAHIx9j2bKP82DLFvA4xBJ2z+KBfVICxTaCldsAWc0JFFXVAOFDkaA4qM=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyM59BDVwELGGpw6dfGwAa6IZkoRE0+lmmfN2enGntm4n076zD+0WDXz9JJCfrJh83XzbVNtAfEI1eSgxtjO8L2Uk6mddXh5U8hQvYG3Zh2bBJruSAI8xD65sv8ge6IwL0YwuhFTTIoHBqUGGiIlUZBketY30oyjOpS4riT5HPSuFTjh6QoLXt60Rr7slLVLVvhXu804HVjA+95OutvZkTFA2BtAR6d6oY0E9pQsAqBYm/NAiKckSuqVBg33rpgVAeJJHCpTy8nG8LaKurSFJIgnspgMYKwWaj6Qa4qARo0PjR8CbbI43EkqQRILe+c/w1zzLdozbgObh2KhGlADfkwIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "";
//	http://localhost:8080/ParkingLot/notify_url.jsp
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";
//	http://localhost:8080/ParkingLot/return_url.jsp
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

