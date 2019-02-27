package com.howin.qiulu.page;

import java.util.List;
/**
 * 
* @Title: Page
* @Description: 分页类
* @author 吴磊
* @date 2017年2月23日下午1:52:34
 */
public class Page {
	
	private int everyPage = 10;
	
	private int totalCount;
	
	private int totalPage;
	
	private int beginPage = 1;
	
	private boolean hasPrePage;
	
	private boolean hasNextPage;
	
	private List list;
	
	public void init(){
		int totalPage = totalCount % everyPage == 0 ? totalCount / everyPage : totalCount / everyPage +1;
		this.setTotalPage(totalPage);
		this.setHasPrePage(beginPage > 1);
		this.setHasNextPage(beginPage < totalPage);
		if(!(this.getBeginPage() >0&&this.beginPage <= this.totalPage && this.totalCount!=0)){
			this.beginPage = 1;
			if(this.totalPage == 0){
				return;
			}
			this.init();
		}
	}
	
	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [everyPage=" + everyPage + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", beginPage=" + beginPage
				+ ", hasPrePage=" + hasPrePage + ", hasNextPage=" + hasNextPage
				+ ", list=" + list + "]";
	}
	
	
}