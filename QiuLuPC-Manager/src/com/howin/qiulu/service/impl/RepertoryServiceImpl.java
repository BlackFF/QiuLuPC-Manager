package com.howin.qiulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.RepertoryDao;
import com.howin.qiulu.dao.SkuDao;
import com.howin.qiulu.page.Page;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.RepertoryService;
/**
 * 
* @Title: RepertoryServiceImpl
* @Description: 
* @author 吴磊
* @date 2017年2月23日上午11:42:20
 */
@Service
public class RepertoryServiceImpl implements RepertoryService{

	@Autowired
	private RepertoryDao repertoryDao;
	@Autowired
	private SkuDao skuDao;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:43:41
	 * @description 
	 * @param type
	 * @return
	 */
	@Override
	public QiuluResult getRepertoryByType(int type,int pageNumber) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		page.setBeginPage(pageNumber);
		if(type == 1){
			int count = repertoryDao.getWarnCount();
			page.setTotalCount(count);
			page.init();
			List<Sku> list = repertoryDao.getWarnRepertory((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage());
			page.setList(list);
			result.setStatus(true);
			result.setObject(page);
		} else if(type == 0){
			int count = repertoryDao.getAllCount();
			page.setTotalCount(count);
			page.init();
			List<Sku> list = repertoryDao.getAllRepertory((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage());
			page.setList(list);
			result.setStatus(true);
			result.setObject(page);
		} else {
			result.setStatus(false);
		}
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:58:39
	 * @description 
	 * @param id
	 * @param repertory
	 * @return
	 */
	@Override
	public QiuluResult updateRepertory(int id, int repertory,int type) {
		QiuluResult result = new QiuluResult();
		Sku sku = skuDao.getSkuById(id);
		int newNumber = 0;
		if(type == 1){
			newNumber = sku.getRepertory()+repertory;
		} else {
			newNumber = sku.getRepertory()-repertory;
		}
		sku.setRepertory(newNumber);
		repertoryDao.updateRepertory(sku);
		result.setStatus(true);
		return result;
	}

}
