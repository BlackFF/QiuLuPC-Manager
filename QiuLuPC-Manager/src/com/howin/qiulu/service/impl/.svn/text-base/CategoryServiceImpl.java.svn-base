package com.howin.qiulu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.CategoryDao;
import com.howin.qiulu.dao.ItemDao;
import com.howin.qiulu.pojo.Category;
import com.howin.qiulu.pojo.custom.CategoryCustom;
import com.howin.qiulu.pojo.custom.UItreeNote;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.CategoryService;
import com.howin.qiulu.utils.NoteUtil;
/**
 * 
* @Title: CategoryServiceImpl
* @Description: 商品类目业务层
* @author 吴磊
* @date 2017年2月20日下午1:36:01
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ItemDao itemDao;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日下午1:36:53
	 * @description 得到所有类目并格式化
	 * @return
	 */
	@Override
	public QiuluResult getCategory() {
		QiuluResult result = new QiuluResult();
		List<Category> list = categoryDao.getCategory();
		List<CategoryCustom> allCategory = new ArrayList<>();
		List<UItreeNote> allNote = new ArrayList<>();
		for (Category category : list) {
			CategoryCustom categoryCustom = new CategoryCustom();
			categoryCustom.setId(category.getId());
			categoryCustom.setIsParent(category.getIsParent());
			categoryCustom.setItemParamData(category.getItemParamData());
			categoryCustom.setName(category.getName());
			categoryCustom.setParentId(category.getParentId());
			categoryCustom.setSkuParamData(category.getSkuParamData());
			//UItreeNote note = categoryCustom.getNote();
			//allNote.add(note);
			allCategory.add(categoryCustom);
		}
		
		List<UItreeNote> notes = new ArrayList<>();
		List<CategoryCustom> categoryCustoms = new ArrayList<>();
		for (Category category : allCategory) {
			if(category.getParentId() == null){
				CategoryCustom temp = (CategoryCustom) category;
//				UItreeNote note = temp.getNote();
//				notes.add(note);
				categoryCustoms.add(temp);
			}
		}
		List<CategoryCustom> categoryList = categoryList(categoryCustoms, allCategory);
		result.setObject(categoryList);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日下午3:20:14
	 * @description  递归方法
	 * @param categoryCustoms
	 * @param allCategory
	 * @return List<CategoryCustom>
	 */
	private List<CategoryCustom> categoryList(List<CategoryCustom> categoryCustoms,List<CategoryCustom> allCategory){
		for (CategoryCustom categoryCustom : categoryCustoms) {
			if(categoryCustom.getIsParent() == 0){
				continue;
			}
			List<CategoryCustom> categoryCustoms2 = new ArrayList<>();
			int i = 0;
			for(Category category : allCategory){
				if(category.getParentId() == null){
					continue;
				}
				if(category.getParentId().equals(categoryCustom.getId())){
					CategoryCustom temp = (CategoryCustom) category;
					categoryCustoms2.add(temp);
				} else {
					i++;
				}
			}
			categoryCustom.setChildren(categoryCustoms2);
			if(i == allCategory.size()){
				continue;
			} else {
				categoryList(categoryCustoms2, allCategory);
			}
		}
		return categoryCustoms;
	}
	/**
	 * 传入一个节点note返回所属的子分类
	 * @author 吴磊
	 * @date 2017年4月7日下午4:27:14
	 * @description 
	 * @param id
	 * @return List<UItreeNote>
	 */
	public List<UItreeNote> getNextNote(UItreeNote note){
		List<Category> note2 = categoryDao.getNote(note.getId());
		int flag = 0; 
		if(note2 == null || note2.size() == 0){
			return null;
		} else {
			List<UItreeNote> notes = new ArrayList<>();
			for (Category category : note2) {
				if(category.getIsParent() == 0){
					flag++;
				}
				notes.add(NoteUtil.getNote(category));
			}
			return notes;
		}
	}
	public List<UItreeNote> getListNote(List<UItreeNote> notes){
		int flag = 0;
		for (UItreeNote uItreeNote : notes) {
			List<UItreeNote> nextNote = getNextNote(uItreeNote);
			if(nextNote == null){
				flag++;
			} else {
				continue;
			}
		}
		if(flag == notes.size()){
			return notes;
		}
		return null;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日下午4:02:39
	 * @description 存储一个新的类目
	 * @return
	 */
	@Override
	public QiuluResult saveCategory(Category category) {
		QiuluResult result = new QiuluResult();
		category.setIsParent((short) 0);
		int saveCategory = categoryDao.saveCategory(category);
		if(category.getParentId() != null){
			categoryDao.updateCategory(category.getParentId());
		}
		result.setStatus(true);
		return result;
	}
//	/**
//	 * 
//	 * @author 吴磊
//	 * @date 2017年2月22日上午9:29:29
//	 * @description 根据id删除类目
//	 * @param id
//	 * @return
//	 */
//	@Override
//	public QiuluResult deleteCategory(int id) {
//		QiuluResult result = new QiuluResult();
//		int deleteCategory = 0;
//		int checkCategory = itemDao.checkCategory(id);
//		if(checkCategory == 0){
//			deleteCategory = categoryDao.deleteCategory(id);
//		} 
//		if(deleteCategory == 1){
//			result.setStatus(true);
//			result.setMessage("删除成功");
//		} else {
//			result.setStatus(false);
//			result.setMessage("删除失败");
//		}
//		return result;
//	}
	
	/**
	 * 
	 * @author 魏吉鹏
	 * @date 2017年2月20日下午4:02:39
	 * @description 删除一个类目
	 * @param 要删除的类目id
	 * @return
	 */
	public QiuluResult deleteCategory(int id){
		QiuluResult result = new QiuluResult();
		int deleteCategory = 0;
		int checkCategory = itemDao.checkCategory(id);
		if(checkCategory == 0){
			
			Category c = categoryDao.getCategoryById(id);
			
			Category parent = categoryDao.getCategoryById(c.getParentId());
			
			deleteCategory = categoryDao.deleteCategory(id);
			
			//检测父级分类是否还有其他子分类 若没有 则将其父级分类标识设为0
			if(parent != null){
				
				List<Category> list = categoryDao.getNote(parent.getId());
				
				if(list == null || list.size() == 0){
					
					parent.setIsParent((short)0);
					
					categoryDao.changeCategory(parent);
				}
			}
			
		} 
		if(deleteCategory == 1){
			result.setStatus(true);
			result.setMessage("删除成功");
		} else {
			result.setStatus(false);
			result.setMessage("删除失败");
		}
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:50:39
	 * @description 编辑商品信息
	 * @param category
	 * @return
	 */
	@Override
	public QiuluResult changeCategory(Category category) {
		QiuluResult result = new QiuluResult();
		categoryDao.changeCategory(category);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日上午11:58:43
	 * @description 
	 * @return
	 */
	@Override
	public QiuluResult getTop() {
		QiuluResult result = new QiuluResult();
		List<Category> list = categoryDao.getTop();
		result.setStatus(true);
		result.setObject(list);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日下午1:40:33
	 * @description 
	 * @param parentId
	 * @return
	 */
	@Override
	public QiuluResult getNote(int parentId) {
		QiuluResult result = new QiuluResult();
		List<Category> list = categoryDao.getNote(parentId);
		result.setStatus(true);
		result.setObject(list);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月10日下午3:01:32
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult getCategoryById(int id) {
		QiuluResult result = new QiuluResult();
		Category category = categoryDao.getCategoryById(id);
		result.setObject(category);
		result.setStatus(true);
		return result;
	}
}











