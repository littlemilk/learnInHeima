package com.mark.bean;

public class OrderItem {

	private String itemid;
	private int count;
	private double subtotal;
	
	
	//pid���: ��ʾ����ʲô��Ʒ ; ��java����Ӧ����product����(��ʾ�����Ǹ���Ʒ)
	private Product product;
	//oid���: ��ʾ��������������ĸ�����; ��java����Ӧ����order����(��ʾ�����Ǹ�����)
	private Order order;
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
