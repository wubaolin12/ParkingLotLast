package org.great.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 百度地图
 * @author Administrator
 *孔大帅
 */
@Controller
@Scope("prototype")
@RequestMapping("/Map")
public class MapHandler {

	@RequestMapping("/map.action")
	public String JumpMap() {
		
		return "Map";
	}
}
