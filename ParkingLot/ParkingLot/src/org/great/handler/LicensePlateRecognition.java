package org.great.handler;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.Car;
import org.great.bean.Stopcartime;
import org.great.biz.CarBiz;
import org.great.biz.StopcartimeBiz;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.aip.ocr.AipOcr;

/**
 * 车牌识别
 * 
 * @author 孔祥晶
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/LicensePlate")
public class LicensePlateRecognition {

	// 设置APPID/AK/SK
	public static final String APP_ID = "15429813";
	public static final String API_KEY = "mEMqLxA8KSG7U69GpMjwlSOU";
	public static final String SECRET_KEY = "2bqK1oVuECWry3FvNDpwHTirPlFCV5Rm";
	private String serverFilePatn;//车牌图片服务器地址
	private String path;//上传文件地址
	private boolean flag;//标记
	private Map<String,String> result = new HashMap();
	@Resource
	private Car car;
	@Resource
	private CarBiz carBiz;//调用Mybatis调用数据库
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

	
	@RequestMapping("/LicensePlateUp.action")
	public String JumpLicensePlate() {

		return "LicensePlateUpLoad";
	}
	
	/**
	 * 跳转到LED显示界面
	 * 孔大帅
	 */
	@RequestMapping("/CarAdmissionDisplay.action")
	public String JumpCarAdmissionDisplay() {
		
		return "CarAdmissionDisplay";
	}

	/**
	 * 车辆入场扫描 孔大爷
	 */
	
	@ResponseBody
	@RequestMapping(value = "/CarAdmission.action", method = RequestMethod.POST)
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
	//	String image = "C:\\Users\\Administrator\\Desktop\\timg.jpg";
		JSONObject res = client.plateLicense(path+filename, options);
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
		
		//查找该车牌是否已经有记录
		 car = carBiz.FindByCarNumber(number);
		System.out.println("找到的车记录"+car);
		
		//没记录添加一个临时车牌的记录，否则就根据想对应的记录给予车辆角色
		if(car==null) {
			
			flag = carBiz.AddCarMsg(number);
			
			if(flag) {
				 car = carBiz.FindByCarNumber(number);
				System.out.println("临时车辆记录成功");
			}
		}
		
		//获取当前时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currenime = new Date();
		String currendate = df.format(currenime);
		
		Stopcartime sct = new Stopcartime(car.getC_id(),currendate);
		
		//先查询该车是否在停车了，如果在停车了就不要重复添加数据
		List<Stopcartime> sctlist =stopcartimeBiz.FindSctByNumber(car.getC_id());
		
		System.out.println(car.getC_id()+"ID下的所有停车记录："+sctlist);
		
		for (Stopcartime stopcartime : sctlist) {
			
			if(stopcartime.getPm_id()==2) {
				
				//记录停车时间
				flag = stopcartimeBiz.AddStopBeginTime(sct);
				
				if(flag) {
					
					System.out.println("执行成功停车");
					
				}
			}
		}
		
		HttpSession session = request.getSession();
	
		session.setAttribute("Carkxj", car);
		
		 result.put("code","200");
		
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
}
