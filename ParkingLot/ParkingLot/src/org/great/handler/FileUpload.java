package org.great.handler;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.great.bean.Park;
import org.great.biz.ParkBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	public String uploadPic(MultipartFile picture,Park park) {
		// 获取图片名
//		String orgFilename = picture.getOriginalFilename();
		
		//给一个图片新名称==车位号id
		String newFilename = park.getP_id()+"";
		String path = "/upload/" + newFilename;
		try {
			picture.transferTo(new File(path));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		park.setP_imgpath(path);
		int ret = parkBiz.addPicture(park);

		return "redirect:park/findPark.action";
	}
}
