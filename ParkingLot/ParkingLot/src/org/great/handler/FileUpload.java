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
 * @author 吴宝林
 *
 */
@Controller
@RequestMapping("/upload")
public class FileUpload {
	@Resource
	public ParkBiz parkBiz;

	/**
	 * 	上传图片
	 * @param picture
	 * @param park
	 * @return
	 */
	@RequestMapping("/picture")
	public ModelAndView uploadPic(MultipartFile picture,Park park,
			HttpServletRequest request,HttpServletResponse response) {
		// 获取图片名
		String orgFilename = picture.getOriginalFilename();
		
		//给一个图片新名称==车位号id
		String newFilename = park.getP_id()+ orgFilename.substring(orgFilename.lastIndexOf("."));

		//图片存放路径
		String path = "D:\\file_file\\test\\upload\\" + newFilename;
		try {
			picture.transferTo(new File(path));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		park.setP_imgpath(newFilename);
		int ret = parkBiz.addPicture(park);

		ModelAndView modelAndView = new ModelAndView("redirect:/ParkView/allList.action");//重定向
		return modelAndView;
	}
}
