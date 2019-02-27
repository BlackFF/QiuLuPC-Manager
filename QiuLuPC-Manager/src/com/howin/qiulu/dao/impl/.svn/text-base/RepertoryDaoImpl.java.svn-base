package com.howin.qiulu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.RepertoryDao;
import com.howin.qiulu.pojo.Sku;
/**
 * 
* @Title: RepertoryDaoImpl
* @Description: 
* @author 吴磊
* @date 2017年2月23日上午11:40:11
 */
@Repository
public class RepertoryDaoImpl implements RepertoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:40:16
	 * @description 
	 * @return
	 */
	@Override
	public List<Sku> getAllRepertory(int begin,int every) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Sku";
		List<Sku> list = session.createQuery(hql).setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:40:21
	 * @description 
	 * @return
	 */
	@Override
	public List<Sku> getWarnRepertory(int begin,int every) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Sku where repertory < warnRepertory";
		List<Sku> list = session.createQuery(hql).setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:56:43
	 * @description 
	 * @param sku
	 */
	@Override
	public void updateRepertory(Sku sku) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sku);
		
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月11日下午2:04:52
	 * @description 
	 * @return
	 */
	@Override
	public int getAllCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Sku";
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int)count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月11日下午2:04:55
	 * @description 
	 * @return
	 */
	@Override
	public int getWarnCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Sku where repertory < warnRepertory";
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int)count;
	}

}
