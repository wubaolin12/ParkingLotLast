package org.great.handler;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.great.bean.Park;
import org.great.biz.ParkBiz;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 鸟瞰图 孔大爷
 */
@Controller
@Scope("prototype")
@RequestMapping("/Game")
public class FilattenBird {

	
	@RequestMapping("/FlattenBird.action")
	public String JumpFlattenBird() {
		

		
		return "FlattenBird";
	}
	
}
