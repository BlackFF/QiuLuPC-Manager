package com.howin.qiulu.dao;

import java.util.List;

import com.howin.qiulu.pojo.Category;
import com.howin.qiulu.pojo.custom.CategoryCustom;
/**
 * 
* @Title: CategoryDao
* @Description: 类目持久层接口
* @author 吴磊
* @date 2017年2月22日上午11:18:46
 */
public interface CategoryDao {
	//得到所有商品类目的列表
	List<Category> getCategory();
	//添加一节商品类目
	int saveCategory(Category category);
	//更新类目的状态
	void updateCategory(int id);
	//删除一个商品类目
	int deleteCategory(int id);
	//编辑一个商品类目
	void changeCategory(Category category);
	
	List<Category> getTop();
	
	List<Category> getNote(int parentId);
	
	Category getCategoryById(Integer id);
		
}
