package org.great.handler;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Car;
import org.great.bean.Countrules;
import org.great.bean.Cust;
import org.great.bean.Param;
import org.great.bean.RoleRel;
import org.great.bean.Stopcartime;
import org.great.bean.User;
import org.great.bean.Vip;
import org.great.biz.CarBiz;
import org.great.biz.CountrulesBiz;
import org.great.biz.CustBiz;
import org.great.biz.ParamBiz;
import org.great.biz.RoleRelBiz;
import org.great.biz.StopcartimeBiz;
import org.great.biz.VipBiz;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.aip.ocr.AipOcr;

/**
 * 车辆出场车牌识别
 * 
 * @author 孔祥晶
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/AppearanceLicensePlate")
public class AppearanceLicensePlateRecognition {
	@Resource
	private RoleRelBiz roleRelBiz;
	@Resource
	CountrulesBiz countrulesBiz;
	@Resource
	ParamBiz paramBiz;
	// 设置APPID/AK/SK
	public static final String APP_ID = "15429813";
	public static final String API_KEY = "mEMqLxA8KSG7U69GpMjwlSOU";
	public static final String SECRET_KEY = "2bqK1oVuECWry3FvNDpwHTirPlFCV5Rm";
	private String serverFilePatn;// 车牌图片服务器地址
	private String path;// 上传文件地址
	private boolean flag;// 标记
	private Map<String, String> result = new HashMap();
	@Resource
	private Car car;
	@Resource
	private CarBiz carBiz;// 调用Mybatis调用数据库
	@Resource
	private VipBiz vipBiz;// 调用Mybatis调用数据库
	@Resource
	private CustBiz custBiz;// 调用Mybatis调用数据库
	@Resource
	private StopcartimeBiz stopcartimeBiz;

	static AipOcr client = null;
	static {
		client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		// 可选：设置网络连接参数
		// 设置http代理
		// client.setHttpProxy("proxy_host", proxy_port);
		// 设置socket代理
		// client.setSocketProxy("proxy_host", proxy_port);
		// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
		// 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "src/main/java/log4j.properties");
		client.setConnectionTimeoutInMillis(2000);
		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		client.setSocketTimeoutInMillis(60000);
	}

	/**
	 * 跳转到上传车牌界面 孔大爷
	 */

	@RequestMapping("/AppearanceLicensePlateUp.action")
	public String JumpLicensePlate() {

		return "AppearanceLicensePlateUpLoad";
	}

	/**
	 * 跳转到LED显示界面 孔大帅
	 */
	@RequestMapping("/AppearanceCarAdmissionDisplay.action")
	public String JumpCarAdmissionDisplay() {

		return "AppearanceCarAdmissionDisplay";
	}

	/**
	 * 车辆入场扫描 孔大爷
	 */

	@ResponseBody
	@RequestMapping(value = "/AppearanceCarAdmission.action", method = RequestMethod.POST)
	public Map LicensePlates(HttpServletRequest request, MultipartFile myfile) {

		// 获得文件名字
		String filename = myfile.getOriginalFilename();

		System.out.println("获取到的文件名:" + filename);

		try {
			/**
			 * 项目服务器地址路径
			 */
			String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath() + "/upload/";
			/**
			 * 上传文件绝对路径
			 */
			path = request.getSession().getServletContext().getRealPath("/upload/");

			System.out.println("服务器地址路径=" + projectServerPath + "上传文件绝对路径=" + path);

			File file = new File(path + filename);
			/**
			 * 判断路径是否存在，如果不存在就创建一个
			 */
			if (!file.getParentFile().exists()) {

				file.getParentFile().mkdirs();
			}
			/**
			 * 创建文件
			 */
			myfile.transferTo(new File(path + File.separator + filename));
			/**
			 * 返回服务器文件地址
			 */

			serverFilePatn = projectServerPath + filename;

			System.out.println("服务器文件地址=" + serverFilePatn);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("multi_detect", "true");

		// 参数为本地路径
		// String image = "C:\\Users\\Administrator\\Desktop\\timg.jpg";
		JSONObject res = client.plateLicense(path + filename, options);
		System.out.println(res.toString(2));

		// 参数为二进制数组
//    byte[] file = null;
//    
//	try {
//		
//		file = readFileByBytes("C:\\Users\\Administrator\\Desktop\\timg2.jpg");
//		
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//    res = client.plateLicense(file, options);
//    System.out.println(res.toString(2));

//取到车牌

		String str = res.toString().split(":")[3];

		String number = str.substring(1, 8);

		System.out.println(number);

		// 查找该车牌是否已经有记录
		car = carBiz.FindByCarNumber(number);
		System.out.println("找到的车记录" + car);

		// 获取当前时间算出场时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currenime = new Date();
		String currendate = df.format(currenime);

		// 先查询该车的正在停车的那条数据，然后改变状态成出场
		List<Stopcartime> sctlist = stopcartimeBiz.FindSctByNumber(car.getC_id());

		HttpSession session = request.getSession();// 获取session

		System.out.println(car.getC_id() + "ID下的所有停车记录：" + sctlist);

		result.put("code", "200");// 失败回调

		for (Stopcartime stopcartime : sctlist) {

			if (stopcartime.getPm_id() == 1) {

				Stopcartime sct = new Stopcartime(2, currendate, stopcartime.getSct_id());

				// 修改出场时间
				flag = stopcartimeBiz.UpdateSctTimeandState(sct);

				Stopcartime stopct = stopcartimeBiz.FindByID(stopcartime.getSct_id());
				System.err.println("stopct=" + stopct);
				String fTime = stopct.getSct_starttime();
				String oTime = stopct.getSct_overtime();
				System.out.println("fTime=" + fTime + "oTime=" + oTime);
				// 计算时间停车时间
				SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				float m1 = 0;
//				long mm = 0;
				try {
					float m2 = myFormatter.parse(oTime).getTime() - myFormatter.parse(fTime).getTime();
					m1 = m2 / (60 * 60 * 1000);
//					if(m1>=0&&m1<=0.5) {
//						m1 = 0;
//					}else if(m1>0.5&&m1<=1) {
//						m1 = 1;
//					}else {
//						long m = myFormatter.parse(oTime).getTime() - myFormatter.parse(fTime).getTime();
//						mm = m / (60 * 60 * 1000);
//						m1 = mm;
//					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i = (int)(m1+0.5);
				System.out.println("相差时间: " + i);
				Map<String, String> map = new HashMap<String, String>();
				String time = "" + i;
				System.out.println("time="+time);
				map.put("time", time);
				map.put("pmtype", "规则状态");
				map.put("pmname", "启用");

				// 查询计费规则
				Countrules countrules = countrulesBiz.findCountrulRoleX(map);
				if (countrules == null) {
					countrules = countrulesBiz.findCountrulRoleEqualsX(map);
				}
				System.out.println("countrules=" + countrules);
				// 根据查询的计费规则计算费用
				int t = Integer.parseInt(time);
				System.out.println("t=" + t);
				String statime =""+0;
				if(countrules.getCr_starttime().equals("0.5")) {
					statime = ""+0;
				}else {
					statime = countrules.getCr_starttime();
				}
				int ftime = Integer.parseInt(statime);
				System.out.println("ftime=" + ftime);
				int money = countrules.getCr_fristmoney() + (t - ftime) * countrules.getCr_addmoney();
				System.out.println("money=" + money);
				Stopcartime sctz = new Stopcartime(stopcartime.getSct_id(), money);
				System.out.println("sctz=" + sctz);
				flag = stopcartimeBiz.UpdateSctMoneyX(sctz);
				if (flag) {
					Param param = new Param("白名单", "车辆角色");
					Param param1 = paramBiz.GetPmIDByTypeNmaeX(param);
					Param param2 = new Param("注册会员", "车辆角色");
					Param param22 = paramBiz.GetPmIDByTypeNmaeX(param2);
					Param param3 = new Param("包月套餐", "车辆角色");
					Param param33 = paramBiz.GetPmIDByTypeNmaeX(param3);
					Param param4 = new Param("临时车辆", "车辆角色");
					Param param44 = paramBiz.GetPmIDByTypeNmaeX(param4);
					// 查找该车牌是否已经有记录
					Car car1 = carBiz.FindByCarNumber(number);
					System.out.println("查询车辆信息" + car1);
					if (car1.getPm_id() == param1.getPm_id()) {
						System.out.println("-------这货是白名单，放他走!!!-------");
					} else if (car1.getPm_id() == param22.getPm_id()) {
						Car car2 = carBiz.findCustCarNumberByCarIDX(car1.getC_id());
						List<Vip> Viplist = vipBiz.findVipX(20);
						if (Viplist != null && Viplist.size() != 0) {
							System.out.println("-------这货曾经是月缴会员快提醒他续费充值!!!-------");
						} else {
							System.out.println("-------这货没充过月缴会员，你也可以提醒他充值哦!!!-------");
						}
						if (car2.getCust().getCust_money() >= money) {
							int money2 = car2.getCust().getCust_money() - money;
							Cust cust = new Cust(car2.getCust().getCust_id(), money2);
							boolean flag2 = custBiz.chageCustMoneyByIDX(cust);
							System.out.println("flag2=" + flag2);
							if (flag2 == true) {
								System.out.println("-------这货是注册会员卡里有钱自动扣掉，放他走!!!-------");
							} else {
								System.out.println("-------这货是注册会员卡里有钱自动扣掉的时候发生了以外，扣除失败了!!!-------");
							}
						} else {
							System.out.println("-------这货是注册会员卡里钱不够 ，不放!!!-------");
						}
					} else if (car1.getPm_id() == param33.getPm_id()) {

						Param param5 = new Param("待生效", "月缴状态");
						Param param55 = paramBiz.GetPmIDByTypeNmaeX(param5);
						Car car2 = carBiz.findCustCarNumberByCarIDX(car1.getC_id());
						List<Vip> Viplist1 = vipBiz.findVipX(car2.getC_id());
						if (Viplist1 != null && Viplist1.size() != 0) {
							for (int j = 0; j < Viplist1.size(); j++) {
								if (Viplist1.get(0).getPm_id() == param55.getPm_id()) {
									if (car2.getCust().getCust_money() >= money) {
										int money2 = car2.getCust().getCust_money() - money;
										Cust cust = new Cust(car2.getCust().getCust_id(), money2);
										boolean flag2 = custBiz.chageCustMoneyByIDX(cust);
										System.out.println("flag2=" + flag2);
										if (flag2 == true) {
											System.out.println("-------这货是会员还未生效，卡里有钱自动扣掉，放他走!!!-------");
										} else {
											System.out.println("-------这货是会员还未生效，卡里钱自动扣掉的时候发生了意外，扣除失败了!!!-------");
										}
									} else {
										System.out.println("-------这货是会员还未生效，卡里钱不够 ，不放!!!-------");
									}
								} else {

									System.out.println("-------这货是月缴会员，放他走!!!-------");
								}
							}
						}
					} else if (car1.getPm_id() == param44.getPm_id()) {
						System.out.println("-------这货要交钱的 ，不放!!!-------");
					}
					// 查询该出场车辆的信息
					Stopcartime sct2 = stopcartimeBiz.FindByID(stopcartime.getSct_id());
					// 该信息传输到页面
					session.setAttribute("Stopkxj", sct2);
					User user = (User) request.getAttribute("User");
					List<RoleRel> RoleRelList = roleRelBiz.FindRoleIDbyUserIDX(user.getU_id());
					if (RoleRelList != null && RoleRelList.size() != 0) {
						if (RoleRelList.get(0).getRole().getRole_name().equals("收费员")) {
							result.put("code", "300");
						} else {
							result.put("code", "200");
						}
					}
					result.put("code", "200");
					System.out.println("——————————————修改出场时间成功————————————————————————");
				}
			}
		}
		session.setAttribute("Carkxj", car);
		return result;
	}

	/**
	 * 根据文件路径读取byte[] 数组
	 */
	public static byte[] readFileByBytes(String filePath) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException(filePath);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
			BufferedInputStream in = null;

			try {
				in = new BufferedInputStream(new FileInputStream(file));
				short bufSize = 1024;
				byte[] buffer = new byte[bufSize];
				int len1;
				while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
					bos.write(buffer, 0, len1);
				}

				byte[] var7 = bos.toByteArray();
				return var7;
			} finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException var14) {
					var14.printStackTrace();
				}

				bos.close();
			}
		}
	}
	
	/**跳到月缴退费的界面
	 * 
	 * @return
	 */
	@RequestMapping("/VipReturnsJsp.action")
	public String  VipReturnsJsp() {
		return "charge/VipReturns";
	} 
}
