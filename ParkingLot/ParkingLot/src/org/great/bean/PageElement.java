package org.great.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;

/**
 * 页面元素实体类，包含总记录数，当前页，最大页数
 * @author yf
 *
 */
public class PageElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int currentpage;
	@Value("1")
	protected int totalpage;		
	@Value("0")
	protected int cordnum;
	public PageElement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageElement(int currentpage, int totalpage, int cordnum) {
		super();
		this.currentpage = currentpage;
		this.totalpage = totalpage;
		this.cordnum = cordnum;
	}
	@Override
	public String toString() {
		return "PageElement [currentpage=" + currentpage + ", totalpage=" + totalpage + ", cordnum=" + cordnum + "]";
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getCordnum() {
		return cordnum;
	}
	public void setCordnum(int cordnum) {
		this.cordnum = cordnum;
	}
	
	
}
