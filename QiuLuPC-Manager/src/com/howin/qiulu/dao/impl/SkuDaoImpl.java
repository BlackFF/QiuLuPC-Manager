package com.howin.qiulu.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.SkuDao;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.pojo.SkuCostum;
/**
 * 
* @Title: SkuDaoImpl
* @Description: 
* @author 吴磊
* @date 2017年2月22日上午10:32:11
 */
@Repository
public class SkuDaoImpl implements SkuDao {

	@Autowired
	private SessionFactory sessionFaction;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午9:06:53
	 * @description 
	 * @param sku
	 * @return
	 */
	@Override
	public Integer saveSku(Sku sku) {
		Session session = sessionFaction.getCurrentSession();
		Integer save = null;
		save = (Integer) session.save(sku);
		return save;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午9:07:01
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public Sku getSkuById(int id) {
		Session session = sessionFaction.getCurrentSession();
		Sku sku = (Sku) session.get(Sku.class, id);
		return sku;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午9:07:09
	 * @description 
	 * @param image
	 * @param id
	 */
	@Override
	public void changeSkuImage(String image, int id) {
		Session session = sessionFaction.getCurrentSession();
		Sku sku = (Sku) session.get(Sku.class, id);
		sku.setImage(image);
		session.update(sku);
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午9:07:14
	 * @description 
	 * @param sku
	 */
	@Override
	public void updateSku(Sku sku) {
		Session session = sessionFaction.getCurrentSession();
		session.update(sku);
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月24日下午3:44:52
	 * @description 
	 * @param dateScope
	 * @return
	 */
	@Override
	public int getCountByScope(String scope) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "select count(*) from SkuCostum s where s.id.createTime like '%"+scope+"%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月24日下午3:45:04
	 * @description 
	 * @param begin
	 * @param erery
	 * @param dateScope
	 * @return
	 */
	@Override
	public List<SkuCostum> getSkuByScope(int begin, int every, String dateScope) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "from SkuCostum s where s.id.createTime like '%"+dateScope+"%'";
		List<SkuCostum> list = session.createQuery(hql).setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午2:19:59
	 * @description 
	 * @param ItemId
	 * @return
	 */
	@Override
	public List<Sku> getSkuByItemId(int ItemId) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "from Sku where itemId=?";
		List<Sku> list = session.createQuery(hql).setInteger(0, ItemId).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日上午10:10:39
	 * @description 
	 * @param status
	 * @return
	 */
	@Override
	public List<Sku> getSkuByStatus(int begin, int every,int status) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "from Sku where status="+status;
		List<Sku> list = session.createQuery(hql).setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日上午10:20:24
	 * @description 
	 * @param stutas
	 * @return
	 */
	@Override
	public int getCountByStutas(int status) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "select count(*) from Sku s where status="+status;
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日上午11:07:06
	 * @description 
	 * @param begin
	 * @param every
	 * @param name
	 * @return
	 */
	@Override
	public List<Sku> searchSku(int begin, int every, String name) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "from Sku where sellPoint like '%"+name+"%'";
		List list = session.createQuery(hql).setFirstResult(begin).setMaxResults(every).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日上午11:07:09
	 * @description 
	 * @param name
	 * @return
	 */
	@Override
	public int searchSkuCount(String name) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "select count(*) from Sku where sellPoint like '%"+name+"%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月31日下午2:59:34
	 * @description 
	 * @return
	 */
	@Override
	public int getCount() {
		Session session = sessionFaction.getCurrentSession();
		String hql = "select count(*) from Sku";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月31日下午3:00:02
	 * @description 
	 * @param begin
	 * @param every
	 * @return
	 */
	@Override
	public List<Sku> getAllSku(int begin, int every) {
		Session session = sessionFaction.getCurrentSession();
		String hql = "FROM Sku order by id desc";
		List list = session.createQuery(hql).setMaxResults(every).setFirstResult(begin).list();
		return list;
	}
	
	/**
	 * 根据SkuID查找一件SKu
	 */
	@Override
	public Sku getSku(Integer skuId) {
		Session session = sessionFaction.openSession();
		Sku sku =(Sku) session.createQuery("from Sku s where s.id=:i").setParameter("i", skuId).uniqueResult();
		session.close();
		return sku;
	}

}
