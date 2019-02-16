package org.great.fore_handler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.util.CookieUtils;
import org.great.util.JedisClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 鸟瞰图 孔大爷
 */
@Controller
@Scope("prototype")
@RequestMapping("/fore")
public class ForeBirdMap {
	
	

	@RequestMapping("/birdmap.do")
	public String JumpBirdMap(HttpServletRequest request) {
		
		//request.setAttribute("",);
		
		return "Fore/ForeMap";
	}
}
