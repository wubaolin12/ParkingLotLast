package com.alipay.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/testdemo")
public class TestController {

	
	    @RequestMapping(value = "/test1")
	    public String test1(){

	        return "error/success1";
	    }
	    
	    @RequestMapping("/test2.action")
	    public String test2() {
	    	
	    	return "NewFile";
	    }
}
