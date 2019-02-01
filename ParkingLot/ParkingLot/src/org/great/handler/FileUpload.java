package org.great.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.Park;
import org.great.biz.ParkBiz;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 上传图片
 * 
 * @author 吴宝林
 *
 */
@Controller
@RequestMapping("/upload")
public class FileUpload {
	@Resource
	public ParkBiz parkBiz;

	/**
	 * 上传图片
	 * 
	 * @param picture
	 * @param park
	 * @return
	 */
	@RequestMapping("/picture")
	public void uploadPic(MultipartFile file,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("-------------上传文件---------");
		
		// 获取图片名
		String orgFilename = file.getOriginalFilename();

		// 图片存放路径
		String path = "D:\\file_file\\test\\upload\\" + orgFilename;
		try {
			file.transferTo(new File(path));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ;
	}
	
	/**
	 * 上传图片
	 * 
	 * @param picture
	 * @param park
	 * @return
	 */
	@RequestMapping("/save")
	public ModelAndView savePic(Park park,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("-------------图片路径保存---------"+park.getP_id());
		int ret = parkBiz.addPicture(park);

		ModelAndView modelAndView = new ModelAndView("redirect:/ParkView/allList.action");// 重定向
		return modelAndView;
	}


	/**
	 * 上传图片
	 * 
	 * 
	 */
	@RequestMapping("/test")
	public String uploadTest() {

		return "test-upload";
	}

}
