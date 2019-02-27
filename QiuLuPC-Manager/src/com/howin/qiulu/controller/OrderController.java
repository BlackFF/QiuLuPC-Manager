package com.howin.qiulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.OrderService;
/**
 * 
* @Title: OrderController
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午2:10:26
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午2:10:36
	 * @description 
	 * @param id
	 * @return QiuluResult
	 */
	@RequestMapping("/get")
	@ResponseBody
	public QiuluResult getOrderById(Long id){
		QiuluResult result = orderService.getOrderById(id);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午3:45:23
	 * @description 
	 * @param pageNumber
	 * @param status
	 * @return QiuluResult
	 */
	@RequestMapping("/list")
	@ResponseBody
	public QiuluResult getOrderByStatus(@RequestParam(defaultValue="1")int pageNumber,@RequestParam(defaultValue="-1")int status){
		QiuluResult result = orderService.getOrderByStatus(pageNumber, status);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:19:18
	 * @description 
	 * @param id
	 * @param express
	 * @param courierNumber
	 * @return QiuluResult
	 */
	@RequestMapping("/send")
	@ResponseBody
	public QiuluResult send(Long id,String express,String courierNumber){
		QiuluResult result = orderService.updateOrder(id, express, courierNumber);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:31:51
	 * @description 
	 * @param id
	 * @return QiuluResult
	 */
	@RequestMapping("/cancel")
	@ResponseBody
	public QiuluResult cancelOrder(Long id){
		QiuluResult result = orderService.updateOrder(id);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月24日下午2:28:32
	 * @description 
	 * @param dateScope
	 * @param pageNumber
	 * @return QiuluResult
	 */
	@RequestMapping("/scope")
	@ResponseBody
	public QiuluResult getOrderByScope(String dateScope,@RequestParam(defaultValue="1")int pageNumber){
		QiuluResult result = orderService.getOrderByScope(dateScope, pageNumber);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日下午4:53:54
	 * @description 
	 * @param pageNumber
	 * @param beginDate
	 * @param endDate
	 * @return QiuluResult
	 */
	@RequestMapping("/dateScope")
	@ResponseBody
	public QiuluResult getOrderByDateScope(@RequestParam(defaultValue="1")int pageNumber,long beginDate,long endDate){
		QiuluResult result = orderService.getOrderByDateScope(pageNumber, beginDate, endDate);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月27日上午10:17:49
	 * @description 
	 * @param status
	 * @return QiuluResult
	 */
	@RequestMapping("/total")
	@ResponseBody
	public QiuluResult getOrderTotal(int status){
		QiuluResult result = orderService.getTotalBystatus(status);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月5日上午11:44:54
	 * @description 
	 * @param phone
	 * @param pageNumber
	 * @return QiuluResult
	 */
	@RequestMapping("/phone")
	@ResponseBody
	public QiuluResult getOrderByPhone(@RequestParam(defaultValue="")String phone,int pageNumber){
		System.out.println(phone);
		QiuluResult result = orderService.getOrderByPhone(phone, pageNumber);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月6日上午11:23:40
	 * @description 
	 * @param beginDate
	 * @param endDate
	 * @return QiuluResult
	 */
	@RequestMapping("/date")
	@ResponseBody
	public QiuluResult getOrderTotalByScope(long beginDate,long endDate){
		QiuluResult result = orderService.getToTalByDateScope(beginDate, endDate);
		return result;
	}
	
}
