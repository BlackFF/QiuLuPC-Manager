package com.howin.qiulu.service;

import org.springframework.web.multipart.MultipartFile;

import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: SkuService
* @Description: 
* @author 吴磊
* @date 2017年2月24日下午5:41:36
 */
public interface SkuService {
	//存储一个sku
	QiuluResult saveSku(Sku sku);
	//上传图片
	QiuluResult uploadImage(MultipartFile image,int id);
	//删除图片
	QiuluResult deleteImage(String imageName,int id);
	//根据时间范围获取sku列表
	QiuluResult getSkuByScope(String dateScope,int pageNumber);
	//修改sku状态
	QiuluResult changeStatus(int id);
	//更新一个sku
	QiuluResult updateSku(Sku sku);
	
	QiuluResult getSkuByStatus(int pageNumber,int status);
	
	QiuluResult searchSku(int pageNumber,String name);
	
	QiuluResult getAllSku(int pageNumber);
	
	QiuluResult getSkuById(int id);
	
}
