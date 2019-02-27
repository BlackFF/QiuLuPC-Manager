package com.howin.qiulu.service;

import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: RepertoryService
* @Description: 
* @author 吴磊
* @date 2017年2月24日下午5:41:36
 */
public interface RepertoryService {
	//获取商品库存列表
	QiuluResult getRepertoryByType(int type,int pageNumber);
	//更新sku信息
	QiuluResult updateRepertory(int id,int repertory,int type);
}
