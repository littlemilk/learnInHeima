package com.mark.constant;

public class Constant {
	/**
	 * �û������״̬ 0:δ���� 1:�Ѽ���
	 */
	public final static int USER_NOT_ACTIVE =  0;
	public final static int USER_ACTIVED =  1;
	
	/*
	 * ���redis��key
	 * */
	public static final String STORE_CATEGORY_DATA = "store_category_data";
	/*
	 * ������Ʒ��1�����ţ�0��������
	 * */
	public static final int PRODUCT_IS_HOT = 1;
	public static final int PRODUCT_ISNOT_HOT = 0;
	/*
	 * һ��@ʾ����Ʒ����
	 * */
	public static final int PRODUCTS_IN_PAGE = 12;
	/*
	 * ����״̬
	 * */
	public static final int IS_NOT_PAY = 0;
	public static final int HAS_BEEN_PAID = 1;
	public static final int HAS_SENT_OUT = 2;
	public static final int HAS_FINISHED = 3;
}
