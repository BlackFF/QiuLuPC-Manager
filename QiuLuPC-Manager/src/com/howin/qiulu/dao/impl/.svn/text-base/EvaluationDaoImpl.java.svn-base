package com.howin.qiulu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.EvaluationDao;
import com.howin.qiulu.pojo.Evaluation;
/**
 * 
* @Title: EvaluationDaoImpl
* @Description: 
* @author 吴磊
* @date 2017年3月23日上午11:05:42
 */
@Repository
public class EvaluationDaoImpl implements EvaluationDao {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月23日上午11:05:52
	 * @description 
	 * @param begin
	 * @param every
	 * @return
	 */
	@Override
	public List<Evaluation> getAllEvaluation(int begin, int every) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Evaluation order by id desc";
		Query query = session.createQuery(hql);
		List<Evaluation> list = query.setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月23日上午11:05:47
	 * @description 
	 * @return
	 */
	@Override
	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Evaluation";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

}
