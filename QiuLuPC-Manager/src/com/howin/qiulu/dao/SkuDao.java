package com.howin.qiulu.dao;

import java.util.List;

import com.howin.qiulu.pojo.Sku;
/**
 * 
* @Title: SkuDao
* @Description: sku持久层接口
* @author 吴磊
* @date 2017年2月22日上午11:25:31
 */
import com.howin.qiulu.pojo.SkuCostum;
public interface SkuDao {
	//添加sku
	Integer saveSku(Sku sku);
	//根据id得到一个sku
	Sku getSkuById(int id);
	//修改商品的图片
	void changeSkuImage(String image,int id);
	//更新商品的状态
	void updateSku(Sku sku);
	//根据时间范围查询商品总数
	int getCountByScope(String dateScope);
	//根据时间范围查询商品列表
	List<SkuCostum> getSkuByScope(int begin,int every,String dateScope);
	
	List<Sku> getSkuByItemId(int ItemId);
	
	List<Sku> getSkuByStatus(int begin, int every,int status);
	
	int getCountByStutas(int stutas);
	
	List<Sku> searchSku(int begin, int every,String name);
	
	int searchSkuCount(String name);
	
	int getCount();
	
	List<Sku> getAllSku(int begin, int every);
	
	Sku getSku(Integer skuId);
}
