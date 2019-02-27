package com.howin.qiulu.service;

import com.howin.qiulu.pojo.Item;
import com.howin.qiulu.pojo.OnSale;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: ItemService
* @Description: 
* @author 吴磊
* @date 2017年2月24日下午5:41:36
 */
public interface ItemService {
	//检查商品类目是否可以被删除
	QiuluResult checkCategory(int categoryId);
	//添加一个商品
	QiuluResult saveItem(Item item);
	//获取所有商品
	QiuluResult getAllItem(int pageNumber);
	//根据id获取单个商品
	QiuluResult getItem(int id);
	//修改商品信息
	QiuluResult updateItem(Item item);
	
	//根据Id查找一个SKU
	public Sku getSku(Integer skuId);
	
	
	boolean toaddOnSaleSku(Sku sku);
	
	boolean toaddOnSale(OnSale sale);
	
	QiuluResult endOnSaleSku(Integer skuId);
}
