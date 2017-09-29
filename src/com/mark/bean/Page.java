package com.mark.bean;

import java.util.List;

public class Page<T> {
	
	private List<T> list;   //��Ʒ���б�����
	private int curPage;	//��ǰҳ
	private int sumPage;	//��ҳ��	
	private int count;		//������	
	private int curSize;	//һҳ��ʾ����
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
