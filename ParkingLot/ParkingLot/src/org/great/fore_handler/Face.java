package org.great.fore_handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Scope("prototype")
@RequestMapping("/Face")
public class Face {

	
	/**
	 *  登录成功跳转
	 */
	
	@RequestMapping("/face.do")
	public String JumpFace() {
		
		return "Fore/FaceRegiest";
	}
}
