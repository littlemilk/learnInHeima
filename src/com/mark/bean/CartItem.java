package com.mark.bean;

public class CartItem {

	private Product product;
	private int count;
	private double total;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getTotal() {
		return product.getShop_price()*count;
	}
}
