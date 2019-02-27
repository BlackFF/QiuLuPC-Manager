package com.howin.qiulu.dao;

import java.util.Date;
import java.util.List;

import com.howin.qiulu.pojo.Order;
import com.howin.qiulu.pojo.OrderDetail;
/**
 * 
* @Title: OrderDao
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午1:57:27
 */
public interface OrderDao {
	//根据id查询订单详情
	Order getOrderById(Long id);
	//根据订单状态查询订单总数
	int getCountByStatus(int status);
	//根据订单状态查询订单的列表
	List<Order> getOrderByStatus(int begin,int erery,int status);
	//根据订单id查询订单明细
	List<OrderDetail> getOrderDetailByOrderId(Long id);
	//更新订单的状态
	void updateOrder(Order order);
	//根据日期的范围查询订单列表
	List<Order> getOrderByDate(int begin,int erery,String scope);
	//根据日期的范围查询订单总数
	int getCountByDate(String scope);
	
	List<Order> getOrderDateScope(int begin,int erery,Date beginDate,Date endDate);
	
	int getCountByDateScope(Date beginDate,Date endDate);
	
	List<Order> getOrderTotalByStatus(int status);
	
	List<Order> getOrderByPhone(String phone,int begin,int erery);
	
	int getCountByPhone(String phone);
	
	List<Order> getOrderByDateScope(Date beginDate,Date endDate);
	
}
