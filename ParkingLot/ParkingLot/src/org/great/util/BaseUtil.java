package org.great.util;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.Countrules;
import org.great.biz.CountrulesBiz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * UTIL父类,提供共有属性给子类继承
 * 
 * @author yf
 *
 */
@Resource
@Scope("prototype")
@Service("baseUtil")
public class BaseUtil {
	@Value("1")
	protected int currentpage;
	@Value("1")
	protected int totalpage;
	@Value("4")
	protected int rownum;
	@Value("0")
	protected int cordnum;
	@Resource
	 CountrulesBiz countrulesBiz;
	/**
	 * 计算总页数的方法
	 * 
	 * @param cordnum
	 * @param rownum
	 * @return
	 */
	public int getPage(int cordnum, int rownum) {
		int tatalpage = 1;
		if (cordnum % rownum == 0 && cordnum != 0) {
			tatalpage = cordnum / rownum;
		} else if (cordnum == 0) {
			tatalpage = 1;
		} else {
			tatalpage = cordnum / rownum + 1;
		}
		return tatalpage;

	}

	/**
	 * 测试MD5
	 * 
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

	/**
	 * 根据时间计算停车费
	 * 
	 * @param fTime
	 * @param oTime
	 * @return
	 */
	public  int count(String fTime, String oTime) {
		// 计算时间停车时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		double m1 = 0;
		try {
			double m2 = myFormatter.parse(oTime).getTime() - myFormatter.parse(fTime).getTime();
			m1 = m2 / (60 * 60 * 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("相差时间: " + m1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", m1);
		map.put("pmtype", "规则状态");
		map.put("pmname", "启用");
		// 在此处查询该车辆是不是预约车辆。。。做一个判断
		// 查询计费规则
		Countrules countrules = countrulesBiz.findCountrulRoleX(map);
		if (countrules == null) {
			countrules = countrulesBiz.findCountrulRoleEqualsX(map);
		}
		System.out.println("countrules=" + countrules);
		// 根据查询的计费规则计算费用
//			int t = Integer.parseInt(time);
//			System.out.println("t=" + t);
		int t = 0;
		if (countrules.getCr_starttime() < 0.5) {
			t = 0;
		} else {
			t = (int) countrules.getCr_starttime();
		}
		int tt = (int) m1;
		System.out.println(t);
		int money = countrules.getCr_fristmoney() + (tt - t) * countrules.getCr_addmoney();
		System.out.println("money=" + money);
		
		return money;
	}

}
