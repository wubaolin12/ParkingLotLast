package org.great.fore_handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Scope("prototype")
@RequestMapping("/Face")
public class Face {

	
	/**
	 *  登录成功跳转到人脸识别
	 *  孔大帅
	 */
	
	@RequestMapping("/face.do")
	public String JumpFace() {
		
		return "Fore/FaceRegiest";
	}
	
	@RequestMapping("/forefacelogin.do")
	public String JumpFaceLogin() {
		
		return "Fore/FaceLogin";
	}
}
