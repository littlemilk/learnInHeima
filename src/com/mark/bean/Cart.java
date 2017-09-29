package com.mark.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<String, CartItem> itemMap = new HashMap<String, CartItem>(); 
	private double sumTotal;
	

	//Ìí¼Ó
	public void addItem(CartItem cartItem, String pid){
		if(getItemMap().containsKey(pid)){
			CartItem oldItem = getItemMap().get(pid);
			cartItem.setCount(cartItem.getCount() + oldItem.getCount());
		}else{
			getItemMap().put(pid, cartItem);
		}
		sumTotal += cartItem.getTotal();
	}
	//É¾³ý
	public void removeItem(String pid){
		CartItem removeItem = this.getItemMap().remove(pid);
		sumTotal -= removeItem.getTotal();
	}
	//Çå¿Õ
	public void clearCart(){
		itemMap.clear();
		sumTotal = 0.0;
	}
	
	public Collection<CartItem> getValues(){
		Collection<CartItem> values = itemMap.values();
		return values;
	}
	public Map<String, CartItem> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<String, CartItem> itemMap) {
		this.itemMap = itemMap;
	}
	public double getSumTotal() {
		return sumTotal;
	}
	public void setSumTotal(double sumTotal) {
		this.sumTotal = sumTotal;
	}
	@Override
	public String toString() {
		return "Cart [itemMap=" + itemMap + ", sumTotal=" + sumTotal + "]";
	}
	
	
}
