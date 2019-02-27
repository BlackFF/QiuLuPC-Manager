package com.howin.qiulu.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.OrderDao;
import com.howin.qiulu.page.Page;
import com.howin.qiulu.pojo.Order;
import com.howin.qiulu.pojo.OrderDetail;
import com.howin.qiulu.pojo.custom.OrderCustom;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.OrderService;
/**
 * 
* @Title: OrderServiceImpl
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午2:03:50
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午2:04:35
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult getOrderById(Long id) {
		QiuluResult result = new QiuluResult();
		OrderCustom orderCustom = new OrderCustom();
		Order order = orderDao.getOrderById(id);
		List<OrderDetail> list = orderDao.getOrderDetailByOrderId(id);
		orderCustom.setOrder(order);
		orderCustom.setOrderDetails(list);
		result.setStatus(true);
		result.setObject(orderCustom);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午2:35:48
	 * @description 
	 * @param pageNumber
	 * @param status
	 * @return
	 */
	@Override
	public QiuluResult getOrderByStatus(int pageNumber, int status) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = orderDao.getCountByStatus(status);
		page.setTotalCount(count);
		page.setBeginPage(pageNumber);
		page.init();
		List<Order> list = orderDao.getOrderByStatus((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage(), status);
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:23:04
	 * @description 
	 * @param id
	 * @param express
	 * @param courierNumber
	 * @return
	 */
	@Override
	public QiuluResult updateOrder(Long id, String express, String courierNumber) {
		QiuluResult result = new QiuluResult();
		Order order = orderDao.getOrderById(id);
		order.setExpress(express);
		order.setCourierNumber(courierNumber);
		order.setStatus(2);
		orderDao.updateOrder(order);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:28:00
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult updateOrder(Long id) {
		QiuluResult result = new QiuluResult();
		Order order = orderDao.getOrderById(id);
		order.setStatus(4);
		order.setEndTime(new Timestamp(System.currentTimeMillis()));
		orderDao.updateOrder(order);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午5:41:00
	 * @description 
	 * @param dateScope
	 * @param pageNumber
	 * @return
	 */
	@Override
	public QiuluResult getOrderByScope(String dateScope, int pageNumber) {
		QiuluResult result = new QiuluResult();
		SimpleDateFormat format;
		Date date = new Date();
		Page page = new Page();
		int count = 0;
		String scope = "";
		if(dateScope.equals("day")){
			format = new SimpleDateFormat("yyyy-MM-dd");
			scope = format.format(date);
			count = orderDao.getCountByDate(scope);
		} else if(dateScope.equals("month")){
			format = new SimpleDateFormat("yyyy-MM");
			scope = format.format(date);
			count = orderDao.getCountByDate(scope);
		} else if(dateScope.equals("all")){
			count = orderDao.getCountByDate(scope);
		}
		page.setBeginPage(pageNumber);
		page.setTotalCount(count);
		page.init();
		List<Order> list = orderDao.getOrderByDate((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage(), scope);
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日下午4:28:23
	 * @description 
	 * @param pageNumber
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public QiuluResult getOrderByDateScope(int pageNumber, long beginDate, long endDate) {
		Date date1 = new Date(beginDate);
		Date date2 = new Date(endDate);
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		page.setBeginPage(pageNumber);
		int count = orderDao.getCountByDateScope(date1, date2);
		page.setTotalCount(count);
		page.init();
		List<Order> list = orderDao.getOrderDateScope((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage(), date1, date2);
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日上午10:09:13
	 * @description 
	 * @param status
	 * @return
	 */
	@Override
	public QiuluResult getTotalBystatus(int status) {
		QiuluResult result = new QiuluResult();
		List<Order> orders = orderDao.getOrderTotalByStatus(status);
		int totle = 0;
		for (Order order : orders) {
			totle = totle + (int)(order.getTotal()*100);
		}
		result.setObject(totle);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月5日上午11:33:45
	 * @description 
	 * @param phone
	 * @return
	 */
	@Override
	public QiuluResult getOrderByPhone(String phone,int pageNumber) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = orderDao.getCountByPhone(phone);
		page.setBeginPage(pageNumber);
		page.setTotalCount(count);
		page.init();
		List<Order> list = orderDao.getOrderByPhone(phone, (page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage());
		page.setList(list);
		result.setStatus(true);
		result.setObject(page);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月6日上午11:13:25
	 * @description 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public QiuluResult getToTalByDateScope(long beginDate, long endDate) {
		QiuluResult result = new QiuluResult();
		Date date1 = new Date(beginDate);
		Date date2 = new Date(endDate);
		List<Order> orders = orderDao.getOrderByDateScope(date1, date2);
		int totle = 0;
		for (Order order : orders) {
			totle = totle + (int)(order.getTotal()*100);
		}
		result.setObject(totle);
		return result;
	}

}
