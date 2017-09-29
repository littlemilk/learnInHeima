package com.mark.service;

import java.sql.SQLException;
import java.util.List;

import com.mark.bean.Category;
import com.mark.constant.Constant;
import com.mark.dao.categoryDao;
import com.mark.utils.JedisUtils;
import com.mark.utils.JsonUtils;

import redis.clients.jedis.Jedis;

public class catecoryService {

	//ͨ��redis����
	public String findFromRedis(Jedis jedis){
		if(jedis != null){
			String data = jedis.get(Constant.STORE_CATEGORY_DATA);
			return data;
		}else{
			return null;
		}
	}
	//��redis��ֵ
	public void setRedis(Jedis jedis, String data){
		if(jedis != null){
			jedis.set(Constant.STORE_CATEGORY_DATA, data);
		}
	}
	//ͨ�����ݿ����
	public String findCategoryFromBase() {
		categoryDao dao = new categoryDao();
		List<Category> list = null;
		try {
			list = dao.findCategoryFromBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data = JsonUtils.list2json(list);
		return data;
	}
	//��������
	public String findCategory()  {
		Jedis jedis = null;
		String data = null;
		try {
			jedis = JedisUtils.getJedis();
			data = findFromRedis(jedis);
			data = findCategoryFromBase();
			if(jedis == null){
				data = findCategoryFromBase();
				setRedis(jedis, data);
			} 
		}catch (Exception e) {
			//e.printStackTrace();
			data = findCategoryFromBase();
		}finally{
			JedisUtils.closeJedis(jedis);
		}
		return data;
	}


}
