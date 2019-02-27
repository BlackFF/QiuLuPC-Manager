package com.howin.qiulu.dao;

import java.util.List;

import com.howin.qiulu.pojo.Sku;
/**
 * 
* @Title: RepertoryDao
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午1:57:16
 */
public interface RepertoryDao {
	//查询所有商品的库存列表
	List<Sku> getAllRepertory(int begin,int every);
	//查询所用警戒库存的列表
	List<Sku> getWarnRepertory(int begin,int every);
	//更新库存的列表
	void updateRepertory(Sku sku);
	
	int getAllCount();
	
	int getWarnCount();
}
