package com.howin.qiulu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.UserDao;
import com.howin.qiulu.pojo.User;
import com.howin.qiulu.pojo.UserDetail;
/**
 * 
* @Title: UserDaoImpl
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午4:38:24
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:46:12
	 * @description 
	 * @param begin
	 * @param every
	 * @return
	 */
	@Override
	public List<User> getAllUser(int begin,int every) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User";
		List<User> list = session.createQuery(hql).setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:45:52
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:45:56
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public UserDetail getUserDetailById(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserDetail userDetail = (UserDetail) session.get(UserDetail.class, id);
		return userDetail;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:55:06
	 * @description 
	 * @return
	 */
	@Override
	public int getUserCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from User";
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int) count;
	}

}
