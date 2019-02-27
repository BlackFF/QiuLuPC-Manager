package com.howin.qiulu.dao;

import java.util.List;

import com.howin.qiulu.pojo.Item;
import com.howin.qiulu.pojo.OnSale;
import com.howin.qiulu.pojo.Sku;
/**
 * 
* @Title: ItemDao
* @Description: 商品持久层接口
* @author 吴磊
* @date 2017年2月22日上午11:24:58
 */
public interface ItemDao {
	//检查商品类目下的商品数量
	int checkCategory(int categoryId);
	//添加一个商品
	Integer saveItem(Item item);
	//获取所有商品
	List<Item> getAllItem(int begin,int erery);
	//根据商品id获取单个商品
	Item getItemById(int id);
	//得到商品总数
	int getCount();
	//更新商品信息
	void updateItem(Item item);
	
	
	boolean toaddOnSaleSku(Sku sku);
	
	boolean toaddOnSale(OnSale sale);
	
	
	Integer endOnSaleSku(Integer skuId);
	
}
