package org.great.util;

import java.security.MessageDigest;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

/**
 * UTIL父类,提供共有属性给子类继承
 * @author yf
 *
 */
@Resource
@Scope("prototype")
public class BaseUtil {
	@Value("1")
	protected int currentpage;
	@Value("1")
	protected int totalpage;	
	@Value("4")
	protected int rownum;
	@Value("0")
	protected int cordnum;
	
	/**
	 * 	计算总页数的方法
	 * @param cordnum
	 * @param rownum
	 * @return
	 */
	public int getPage(int cordnum,int rownum)
	{	
		int tatalpage=1;
	    if(cordnum%rownum==0&&cordnum!=0){
			tatalpage=cordnum/rownum;
		}else if(cordnum==0){
			tatalpage=1;
		}else{
			tatalpage=cordnum/rownum+1;
		}
		return tatalpage;
	    
	}
	
	/**
	 * 	测试MD5
	 * @param 密码
	 * @return MD5
	 * @author 孔大爷；吴宝林修改过
	 * 
	 */
	public static String getStrrMD5(String password) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte strTemp[] = password.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte md[] = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}

			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	
}
