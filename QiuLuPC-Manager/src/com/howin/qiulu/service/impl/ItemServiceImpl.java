package com.howin.qiulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.CategoryDao;
import com.howin.qiulu.dao.ItemDao;
import com.howin.qiulu.dao.SkuDao;
import com.howin.qiulu.page.Page;
import com.howin.qiulu.pojo.Category;
import com.howin.qiulu.pojo.Item;
import com.howin.qiulu.pojo.OnSale;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.pojo.custom.ItemCustom;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.ItemService;

/**
 * 
 * @Title: ItemServiceImpl
 * @Description: 商品业务层
 * @author 吴磊
 * @date 2017年2月22日上午9:01:20
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private SkuDao skuDao;
	@Autowired
	private CategoryDao categoryDao;

	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午9:01:38
	 * @description 检查类目下是否有关联的商品
	 * @param categoryId
	 * @return
	 */
	@Override
	public QiuluResult checkCategory(int categoryId) {
		QiuluResult result = new QiuluResult();
		int checkCategory = itemDao.checkCategory(categoryId);
		Category category = categoryDao.getCategoryById(categoryId);
		if (checkCategory == 0) {
			result.setStatus(true);
			if(category.getIsParent() == 1){
				result.setStatus(false);
				result.setMessage("此类目下有子目录");
				return result;
			}
		} else {
			result.setStatus(false);
			result.setMessage("此类目下存在关联的商品");
		}
		return result;
	}

	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日上午10:13:13
	 * @description
	 * @param item
	 * @return
	 */
	@Override
	public QiuluResult saveItem(Item item) {
		QiuluResult result = new QiuluResult();
		Integer saveItem = itemDao.saveItem(item);
		if (saveItem == null) {
			result.setStatus(false);
			result.setMessage("添加失败");
		} else {
			result.setStatus(true);
			result.setObject(saveItem);
		}
		return result;
	}

	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午2:00:43
	 * @description
	 * @return
	 */
	@Override
	public QiuluResult getAllItem(int pageNumber) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = itemDao.getCount();
		page.setTotalCount(count);
		page.setBeginPage(pageNumber);
		page.init();
		List<Item> allItem = itemDao.getAllItem((page.getBeginPage() - 1) * page.getEveryPage(), page.getEveryPage());
		page.setList(allItem);
		result.setStatus(true);
		result.setObject(page);
		return result;
	}

	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午2:13:11
	 * @description
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult getItem(int id) {
		QiuluResult result = new QiuluResult();
		ItemCustom itemCustom = new ItemCustom();
		Item item = itemDao.getItemById(id);
		List<Sku> list = skuDao.getSkuByItemId(id);
		itemCustom.setItem(item);
		itemCustom.setSkus(list);
		result.setStatus(true);
		result.setObject(itemCustom);
		return result;
	}

	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午2:59:58
	 * @description
	 * @param item
	 * @return
	 */
	@Override
	public QiuluResult updateItem(Item item) {
		QiuluResult result = new QiuluResult();
		Item oldItem = itemDao.getItemById(item.getId());
		if (item.getName() != null) {
			oldItem.setName(item.getName());
		}
		if (item.getParamData() != null) {
			oldItem.setParamData(item.getParamData());
		}
		if (item.getItemDetail() != null) {
			oldItem.setItemDetail(item.getItemDetail());
		}
		itemDao.updateItem(oldItem);
		result.setStatus(true);
		return result;
	}

	@Override
	public Sku getSku(Integer skuId) {
		Sku sku = skuDao.getSku(skuId);
		return sku;
	}

	@Override
	public boolean toaddOnSaleSku(Sku sku) {
		boolean b =itemDao.toaddOnSaleSku(sku);
		return b;
	}

	@Override
	public boolean toaddOnSale(OnSale sale) {
		boolean b =itemDao.toaddOnSale(sale);
		return b;
	}

	@Override
	public QiuluResult endOnSaleSku(Integer skuId) {
		QiuluResult result = new QiuluResult();
		Integer saveItem = itemDao.endOnSaleSku(skuId);
		if (saveItem == null) {
			result.setStatus(false);
			result.setMessage("添加失败");
		} else {
			result.setStatus(true);
			result.setObject(saveItem);
		}
		return result;
	}

}
