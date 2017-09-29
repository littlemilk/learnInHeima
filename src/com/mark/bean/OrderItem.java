package com.mark.bean;

public class OrderItem {

	private String itemid;
	private int count;
	private double subtotal;
	
	
	//pid外键: 表示买了什么商品 ; 在java里面应该用product对象(表示包含那个商品)
	private Product product;
	//oid外键: 表示这个订单项属于哪个订单; 在java里面应该用order对象(表示属于那个订单)
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
