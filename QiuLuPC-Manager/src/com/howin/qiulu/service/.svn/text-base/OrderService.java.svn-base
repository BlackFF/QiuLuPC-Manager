package com.howin.qiulu.service;

import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: OrderService
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午2:02:53
 */
public interface OrderService {
	//根据id获取订单详情
	QiuluResult getOrderById(Long id);
	//根据状态获取订单详情
	QiuluResult getOrderByStatus(int pageNumber,int status);
	//更新订单送货信息
	QiuluResult updateOrder(Long id,String express,String courierNumber);
	//更新订单详情
	QiuluResult updateOrder(Long id);
	//根据时间范围获取订单
	QiuluResult getOrderByScope(String dateScope,int pageNumber);
	
	QiuluResult getOrderByDateScope(int pageNumber,long beginDate,long endDate);
	
	QiuluResult getTotalBystatus(int status);
	
	QiuluResult getOrderByPhone(String phone,int pageNumber);
	
	QiuluResult getToTalByDateScope(long beginDate,long endDate);
}
