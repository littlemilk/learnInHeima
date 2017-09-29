package com.mark.constant;

public class Constant {
	/**
	 * 用户激活的状态 0:未激活 1:已激活
	 */
	public final static int USER_NOT_ACTIVE =  0;
	public final static int USER_ACTIVED =  1;
	
	/*
	 * 存放redis的key
	 * */
	public static final String STORE_CATEGORY_DATA = "store_category_data";
	/*
	 * 热门商品，1：热门，0：不热门
	 * */
	public static final int PRODUCT_IS_HOT = 1;
	public static final int PRODUCT_ISNOT_HOT = 0;
	/*
	 * 一頁顯示的商品數量
	 * */
	public static final int PRODUCTS_IN_PAGE = 12;
	/*
	 * 订单状态
	 * */
	public static final int IS_NOT_PAY = 0;
	public static final int HAS_BEEN_PAID = 1;
	public static final int HAS_SENT_OUT = 2;
	public static final int HAS_FINISHED = 3;
}
