package com.howin.qiulu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.AdminDao;
import com.howin.qiulu.pojo.Admin;
/**
 * 
* @Title: AdminDaoImpl
* @Description: 管理员的数据持久化层
* @author 吴磊
* @date 2017年2月20日上午9:26:07
 */
@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午9:28:53
	 * @description 通过管理员账户来获取管理员
	 * @param account
	 * @return Admin
	 */
	@Override
	public List<Admin> getAdminByAccount(String account) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Admin WHERE account = ?";
		Query query = session.createQuery(hql);
		List<Admin> list = query.setString(0, account).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午10:47:42
	 * @description 根据id获取管理员
	 * @param id
	 * @return Admin
	 */
	@Override
	public Admin getAdminById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin = (Admin) session.get(Admin.class, id);
		return admin;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午11:12:36
	 * @description 添加管理员详细信息
	 * @param admin
	 * @return
	 */
	@Override
	public int saveAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE Admin SET name=?,telephone=? WHERE id=?";
		Query query = session.createQuery(hql);
		query.setString(0, admin.getName()).setString(1, admin.getTelephone()).setInteger(2, admin.getId());
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}

}
