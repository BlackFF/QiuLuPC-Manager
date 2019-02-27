package com.howin.qiulu.service;

import com.howin.qiulu.pojo.Category;
import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: CategoryService
* @Description: 
* @author 吴磊
* @date 2017年2月24日下午5:41:17
 */
public interface CategoryService {
	//得到所有的商品类目
	QiuluResult getCategory();
	//存储一个商品类目
	QiuluResult saveCategory(Category category);
	//根据商品id删除一个商品类目
	QiuluResult deleteCategory(int id);
	//修改一个商品类目的信息
	QiuluResult changeCategory(Category category);
	
	QiuluResult getTop();
	
	QiuluResult getNote(int parentId);
	
	QiuluResult getCategoryById(int id);
}
