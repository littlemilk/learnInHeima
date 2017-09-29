package com.mark.bean;

import java.util.List;

public class Page<T> {
	
	private List<T> list;   //商品的列表数据
	private int curPage;	//当前页
	private int sumPage;	//总页数	
	private int count;		//总数量	
	private int curSize;	//一页显示数量
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getSumPage() {
		return sumPage;
	}
	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurSize() {
		return curSize;
	}
	public void setCurSize(int curSize) {
		this.curSize = curSize;
	}
	@Override
	public String toString() {
		return "Page [list=" + list + ", curPage=" + curPage + ", sumPage=" + sumPage + ", count=" + count
				+ ", curSize=" + curSize + "]";
	}
	
	
}
