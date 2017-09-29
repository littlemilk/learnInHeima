package com.mark.service;

import java.sql.SQLException;
import java.util.List;

import com.mark.bean.Product;
import com.mark.dao.indexDao;

public class indexService {

	indexDao indexDao = new indexDao();
	public List<Product> findHot(int productIsHot) throws SQLException {
		return indexDao.findHot(productIsHot);
	}

	public List<Product> findNew() throws SQLException {
		return indexDao.findNew();
	}

}
