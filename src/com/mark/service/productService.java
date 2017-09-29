package com.mark.service;

import java.sql.SQLException;
import java.util.List;

import com.mark.bean.Page;
import com.mark.bean.Product;
import com.mark.constant.Constant;
import com.mark.dao.productDao;

public class productService {

	public Product findById(String pid) throws SQLException {
		productDao productDao = new productDao();
		return productDao.findById(pid);
	}

	public Page<Product> findByCategoryIdAndPage(String cid, int curPage) throws Exception {
			
		productDao productDao = new productDao();
		int curSize = Constant.PRODUCTS_IN_PAGE;
		int count = productDao.countByCid(cid);
		int sumPage = 0;
		if(count % curSize == 0){
			sumPage = count / curSize;
		}else{
			sumPage = count / curSize + 1;
		}
		int b = curSize;
		int a = (curPage -1)*b;
		List<Product> list = productDao.findByCid(a, b, cid);
		
		//1. ����PageBean ��װ
		Page<Product> pageBean = new Page<Product>();
		//1.1 ��װ��ǰҳ��
		pageBean.setCurPage(curPage);
		//1.2  ��װһҳ��ʾ������
		pageBean.setCurSize(curSize);
		//1.3 ��װ������(��ѯ���ݿ� count(*))
		pageBean.setCount(count);
		//1.4 ��װ��ҳ��(���)
		pageBean.setSumPage(sumPage);
		//1.5 ��װ��Ʒ�ļ��� list
		pageBean.setList(list);
		return pageBean;
	}
	//�ؼ��ֲ�����Ʒ
	public List<Product> findByKeyword(String keyword) throws SQLException {
		productDao dao = new productDao();
		List<Product> list = dao.findByKeyword(keyword);
		return list;
	}

}
