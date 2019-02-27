package com.howin.qiulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howin.qiulu.pojo.Category;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.CategoryService;
import com.howin.qiulu.service.ItemService;
/**
 * 
* @Title: CategoryController
* @Description: 类目控制层
* @author 吴磊
* @date 2017年2月22日上午9:05:28
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ItemService itemService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:05:33
	 * @description 添加类目
	 * @param category
	 * @return QiuluResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public QiuluResult saveCategory(Category category){
		QiuluResult result = categoryService.saveCategory(category);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:05:38
	 * @description 检查类目下是否有关联的商品
	 * @param categoryId
	 * @return QiuluResult
	 */
	@RequestMapping("/checkCategory")
	@ResponseBody
	public QiuluResult checkCategory(int categoryId){
		QiuluResult result = itemService.checkCategory(categoryId);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:36:26
	 * @description 删除类目
	 * @param id
	 * @return QiuluResult
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public QiuluResult deleteCategory(int id){
		if(itemService.checkCategory(id).isStatus()){
			QiuluResult result = categoryService.deleteCategory(id);
			return result;
		}
		return itemService.checkCategory(id);
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:53:33
	 * @description 编辑商品信息
	 * @param category
	 * @return QiuluResult
	 */
	@RequestMapping("/change")
	@ResponseBody
	public QiuluResult changeCategory(Category category){
		if(itemService.checkCategory(category.getId()).isStatus()){
			QiuluResult result = categoryService.changeCategory(category);
			return result;
		}
		return itemService.checkCategory(category.getId());
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月24日下午4:48:49
	 * @description 
	 * @return QiuluResult
	 */
	@RequestMapping("/get")
	@ResponseBody
	public QiuluResult getCategory(){
		QiuluResult result = categoryService.getCategory();
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日下午12:00:36
	 * @description 
	 * @return QiuluResult
	 */
	@RequestMapping("/top")
	@ResponseBody
	public QiuluResult getTop(){
		QiuluResult result = categoryService.getTop();
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日下午1:41:28
	 * @description 
	 * @param parentId
	 * @return QiuluResult
	 */
	@RequestMapping("/note")
	@ResponseBody
	public QiuluResult getNote(int parentId){
		QiuluResult result = categoryService.getNote(parentId);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月10日下午2:58:16
	 * @description 
	 * @param id
	 * @return QiuluResult
	 */
	@RequestMapping("/getById")
	@ResponseBody
	public QiuluResult getCategoryById(int id){
		return categoryService.getCategoryById(id);
	}
}
