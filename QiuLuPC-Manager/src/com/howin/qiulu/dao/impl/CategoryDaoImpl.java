package com.howin.qiulu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howin.qiulu.dao.CategoryDao;
import com.howin.qiulu.pojo.Category;
/**
 * 
* @Title: CategoryDaoImpl
* @Description: 商品类目数据持久化层
* @author 吴磊
* @date 2017年2月20日上午11:53:29
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日下午12:01:56
	 * @description 获取所有类目
	 * @return
	 */
	@Override
	public List<Category> getCategory() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Category";
		List<Category> list = session.createQuery(hql).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日下午3:59:12
	 * @description 添加新类目
	 * @param category
	 * @return
	 */
	@Override
	public int saveCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(category.getName());
		session.save(category);
		return 0;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日下午4:20:50
	 * @description 更新类目
	 * @param category
	 */
	@Override
	public void updateCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, id);
		category.setIsParent((short) 1);
		session.save(category);
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:22:42
	 * @description 根据id删除类目
	 * @param id
	 * @return
	 */
	@Override
	public int deleteCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, id);
		if(category.getIsParent() == 0){
			session.delete(category);
			return 1;
		} else {
			return 0;
		}
	}
//	/**
//	 * 
//	 * @author 吴磊
//	 * @date 2017年2月22日上午9:40:17
//	 * @description 修改类目信息
//	 * @param category
//	 * @return
//	 */
//	@Override
//	public void changeCategory(Category category) {
//		Session session = sessionFactory.getCurrentSession();
//		Category oldCategory = (Category) session.get(Category.class, category.getId());
//		if(category.getItemParamData() != null){
//			oldCategory.setItemParamData(category.getItemParamData());
//		}
//		if(category.getName() != null){
//			oldCategory.setName(category.getName());
//		}
//		if(category.getSkuParamData() != null){
//			oldCategory.setSkuParamData(category.getSkuParamData());
//		}
//		session.update(oldCategory);
//	}
	/**
	 * 
	 * @author 魏吉鹏
	 * @date 2017年4月22日14:13:07
	 * @description 修改类目信息
	 * @param category
	 * @return
	 * 加入  修改  父级分类标记位
	 */
	@Override
	public void changeCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		Category oldCategory = (Category) session.get(Category.class, category.getId());
		if(category.getItemParamData() != null){
			oldCategory.setItemParamData(category.getItemParamData());
		}
		if(category.getName() != null){
			oldCategory.setName(category.getName());
		}
		if(category.getSkuParamData() != null){
			oldCategory.setSkuParamData(category.getSkuParamData());
		}
		if(category.getIsParent() != null){
			oldCategory.setIsParent(category.getIsParent());
		}
		session.update(oldCategory);
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日上午11:55:41
	 * @description 
	 * @return
	 */
	@Override
	public List<Category> getTop() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Category where parentId is null";
		List list = session.createQuery(hql).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日下午1:35:29
	 * @description 
	 * @param parentId
	 * @return
	 */
	@Override
	public List<Category> getNote(int parentId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Category where parentId=?";
		List list = session.createQuery(hql).setInteger(0, parentId).list();
		return list;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月10日下午2:59:41
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public Category getCategoryById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		if(id==null){
			id=0;
		}
		Category category = (Category) session.get(Category.class, id);
		return category;
	}

}
