package com.howin.qiulu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.ExpressDao;
import com.howin.qiulu.pojo.Express;

@Repository
public class ExpressDaoImpl implements ExpressDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/** 
	* @Title: getAllExpress 
	* @date 2017年4月26日 下午2:50:45 
	* @author 魏吉鹏
	* @Description: TODO  查询所有快递公司
	* @return
	* @return List<Express>
	* @throws 
	*/ 
	public List<Express> getAllExpress(){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Express";
		List<Express> list = session.createQuery(hql).list();
		return list;
	}

}