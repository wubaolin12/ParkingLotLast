package org.great.handler;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

/**
 * UTIL父类
 * @author yf
 *
 */
@Resource
@Scope("prototype")
public class BaseUtil {
	@Value("1")
	protected int currentpage;
	@Value("1")
	protected int totalpage;	
	@Value("4")
	protected int rownum;
	@Value("0")
	protected int cordnum;
	
	//计算总页数的方法
	public int getPage(int cordnum,int rownum)
	{	
		int tatalpage=1;
	    if(cordnum%rownum==0&&cordnum!=0){
			tatalpage=cordnum/rownum;
		}else if(cordnum==0){
			tatalpage=1;
		}else{
			tatalpage=cordnum/rownum+1;
		}
		return tatalpage;
	    
	}
	
}
