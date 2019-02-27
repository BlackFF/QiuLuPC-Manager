package com.howin.qiulu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import com.howin.qiulu.dao.ItemDao;
import com.howin.qiulu.dao.OrderDao;
import com.howin.qiulu.pojo.Category;
import com.howin.qiulu.pojo.Order;
import com.howin.qiulu.pojo.OrderDetail;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.pojo.custom.OrderCustom;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.CategoryService;
import com.howin.qiulu.service.ItemService;
import com.howin.qiulu.service.OrderService;
import com.howin.qiulu.service.RepertoryService;
import com.howin.qiulu.service.SkuService;
import com.howin.qiulu.utils.JsonUtils;

@ContextConfiguration(locations={"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml","classpath:applicationContext-trans.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private SkuService skuService;
	@Autowired
	private RepertoryService repertoryService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDao orderDao;
	@Test
	public void test(){
		/*Category category = new Category();
		String name = "sdasd";
		category.setName(name);
		category.setParentId(5);
		category.setIsParent((short) 0);
		category.setItemParamData("sdad");
		category.setSkuParamData("sdasdw");
		QiuluResult saveCategory = categoryService.saveCategory(category);*/
		//itemService.checkCategory(3);
		/*List<String> list = new ArrayList<>();
		list.add("sdasd");
		list.add("ddd");
		String objectToJson = JsonUtils.objectToJson(list);
		System.out.println(objectToJson);*/
		/*QiuluResult result = skuService.deleteImage("cc380f4b-f760-4de1-a2ce-ed9b6c482a29.jpg", 4);
		System.out.println(result.isStatus());*/
		/*QiuluResult result = repertoryService.getRepertoryByType(0);
		List<Sku> list = (List<Sku>) result.getObject();
		for (Sku sku : list) {
			System.out.println(sku.getId());
		}*/
//		Long id = 10168785973l;
//		QiuluResult result = orderService.getOrderById(id);
//		OrderCustom orderCustom = (OrderCustom) result.getObject();
//		String objectToJson = JsonUtils.objectToJson(orderCustom);
//		System.out.println(objectToJson);
//		QiuluResult result = orderService.getOrderByStatus(1, 0);
//		String objectToJson = JsonUtils.objectToJson(result);
//		System.out.println(objectToJson);
//		QiuluResult orderByScope = orderService.getOrderByScope("month", 1);
//		String objectToJson = JsonUtils.objectToJson(orderByScope);
//		System.out.println(objectToJson);
//		skuService.getSkuByScope("sd", 2);
//		QiuluResult result = skuService.getSkuByScope("month", 1);
//		JsonUtils.objectToJson(result);
//		System.out.println(JsonUtils.objectToJson(result));
		String md5DigestAsHex = DigestUtils.md5DigestAsHex("1135".getBytes());
		System.out.println(md5DigestAsHex);
	/*	Date date1 = new Date(1488902400000l);
		Date date2 = new Date(1490198400000l);
		System.out.println(date1);
		QiuluResult result = orderService.getOrderByDateScope(1, 1488902400000l, 1490198400000l);
		List<Order> list = (List<Order>) result.getObject();
		for (Order order : list) {
			System.out.println(order.getCreateTime());
		}*/
		
	}
}
