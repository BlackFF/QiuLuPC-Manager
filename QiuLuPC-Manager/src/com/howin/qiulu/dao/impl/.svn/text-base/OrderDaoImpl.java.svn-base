package com.howin.qiulu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.OrderDao;
import com.howin.qiulu.pojo.Order;
import com.howin.qiulu.pojo.OrderDetail;
/**
 * 
* @Title: OrderDaoImpl
* @Description: 
* @author 鍚寸
* @date 2017骞�2鏈�23鏃ヤ笅鍗�1:58:07
 */
@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * @author 鍚寸
	 * @date 2017骞�2鏈�23鏃ヤ笅鍗�1:58:43
	 * @description 
	 * @param id
	 * @return Order
	 */
	@Override
	public Order getOrderById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, id);
		return order;
	}
	/**
	 * 
	 * @author 鍚寸
	 * @date 2017骞�2鏈�23鏃ヤ笅鍗�2:17:20
	 * @description 
	 * @param status
	 * @return
	 */
	@Override
	public int getCountByStatus(int status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Order where status=?";
		Query query = session.createQuery(hql).setInteger(0, status);
		long count = (long) query.uniqueResult();
		return (int)count;
	}
//	/**
//	 * 
//	 * @author 鍚寸
//	 * @date 2017骞�2鏈�23鏃ヤ笅鍗�2:27:07
//	 * @description 
//	 * @param begin
//	 * @param every
//	 * @param status
//	 * @return
//	 */
//	@Override
//	public List<Order> getOrderByStatus(int begin, int every, int status) {
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "from Order where status = ?";
//		Query query = session.createQuery(hql).setInteger(0, status).setFirstResult(begin).setMaxResults(every);
//		List<Order> list = query.list();
//		return list;
//	}
	
	/**
	 * 
	 * @author 魏吉鹏
	 * @date 2017年4月27日09:49:01
	 * @description 根据状态查询订单  按照订单时间降序排列
	 * @param begin
	 * @param every
	 * @param status
	 * @return
	 */
	@Override
	public List<Order> getOrderByStatus(int begin, int every, int status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order where status = ? order by createTime desc";
		Query query = session.createQuery(hql).setInteger(0, status).setFirstResult(begin).setMaxResults(every);
		List<Order> list = query.list();
		return list;
	}
	/**
	 * 
	 * @author 鍚寸
	 * @date 2017骞�2鏈�23鏃ヤ笅鍗�3:05:08
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public List<OrderDetail> getOrderDetailByOrderId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from OrderDetail where orderId = ?";
		List<OrderDetail> list = session.createQuery(hql).setLong(0, id).list();
		return list;
	}
	/**
	 * 
	 * @author 鍚寸
	 * @date 2017骞�2鏈�23鏃ヤ笅鍗�4:20:35
	 * @description 
	 * @param order
	 */
	@Override
	public void updateOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
	}
	/**
	 * 
	 * @author 鍚寸
	 * @date 2017骞�2鏈�23鏃ヤ笅鍗�5:33:29
	 * @description 
	 * @param begin
	 * @param erery
	 * @param scope
	 * @return
	 */
	@Override
	public List<Order> getOrderByDate(int begin, int erery, String scope) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order where createTime like '%"+scope+"%'";
		List<Order> list = session.createQuery(hql).setFirstResult(begin).setMaxResults(erery).list();
		return list;
	}
	/**
	 * 
	 * @author 鍚寸
	 * @date 2017骞�2鏈�24鏃ヤ笂鍗�9:02:19
	 * @description 
	 * @param scope
	 * @return
	 */
	@Override
	public int getCountByDate(String scope) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Order where createTime like '%"+scope+"%'";
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日下午4:47:00
	 * @description 
	 * @param begin
	 * @param every
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public List<Order> getOrderDateScope(int begin, int every, Date beginDate, Date endDate) {
		Session session = sessionFactory.getCurrentSession();
		String hql= "from Order where ?<createTime and createTime<? and status = 3";
		List list = session.createQuery(hql).setDate(0, beginDate).setDate(1, endDate).setFirstResult(begin).setMaxResults(every).list();
		System.out.println(list.size());
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日下午4:47:04
	 * @description 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public int getCountByDateScope(Date beginDate, Date endDate) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Order where ?<createTime and createTime<? and status = 3";
		Query query = session.createQuery(hql).setDate(0, beginDate).setDate(1, endDate);
		long count = (long) query.uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日上午10:11:28
	 * @description 
	 * @param status
	 * @return
	 */
	@Override
	public List<Order> getOrderTotalByStatus(int status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order where status = ?";
		List list = session.createQuery(hql).setInteger(0, status).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月5日上午11:30:28
	 * @description 
	 * @param phone
	 * @return
	 */
	@Override
	public List<Order> getOrderByPhone(String phone,int begin,int erery) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order where phone = "+phone;
		List list = session.createQuery(hql).setMaxResults(erery).setFirstResult(begin).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月5日上午11:30:31
	 * @description 
	 * @param phone
	 * @return
	 */
	@Override
	public int getCountByPhone(String phone) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Order where phone = "+phone;
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月6日上午11:16:42
	 * @description 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public List<Order> getOrderByDateScope(Date beginDate, Date endDate) {
		Session session = sessionFactory.getCurrentSession();
		String hql= "from Order where ?<createTime and createTime<? and status = 3";
		List list = session.createQuery(hql).setDate(0, beginDate).setDate(1, endDate).list();
		return list;
	}
	
}
