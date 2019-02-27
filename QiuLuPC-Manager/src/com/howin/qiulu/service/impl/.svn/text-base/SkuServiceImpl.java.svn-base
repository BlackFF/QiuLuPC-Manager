package com.howin.qiulu.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.howin.qiulu.dao.SkuDao;
import com.howin.qiulu.page.Page;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.pojo.SkuCostum;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.SkuService;
import com.howin.qiulu.utils.HanyuPinyinHelper;
import com.howin.qiulu.utils.JsonUtils;
import com.howin.qiulu.utils.ThumbnailsUtil;
import com.howin.qiulu.utils.UploadImageUtil;
/**
 * 
* @Title: SkuServiceImpl
* @Description: sku业务层
* @author 吴磊
* @date 2017年2月22日下午1:44:55
 */
@Service
public class SkuServiceImpl implements SkuService{

	@Autowired
	private SkuDao skuDao;
	
	
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日下午2:45:59
	 * @description sku的添加
	 * @param sku
	 * @return
	 */
	@Override
	public QiuluResult saveSku(Sku sku) {
		QiuluResult result = new QiuluResult();
		sku.setStatus(0);
		//将sku的卖点保存成拼音    多音字只保存 拼音类 输出的第一个拼音
		sku.setSellPointPinyin(HanyuPinyinHelper.toHanyuPinyin(sku.getSellPoint()));
		Integer saveSku = skuDao.saveSku(sku);
		if(saveSku != null){
			result.setStatus(true);
			result.setObject(saveSku);
		} else {
			result.setStatus(false);
		}
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月22日下午2:45:00
	 * @description 图片的上传及存储
	 * @param image
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult uploadImage(MultipartFile image,int id) {
		QiuluResult result = new QiuluResult();
		String name = UploadImageUtil.UploadPic(image);
		ThumbnailsUtil.transform(name);
		Sku sku = skuDao.getSkuById(id);
		String images = "";
		if(sku.getImage() == null || sku.getImage().length() == 0){
			List<String> list = new ArrayList<>();
			list.add(name);
			images = JsonUtils.objectToJson(list);
		} else {
			List<String> list = JsonUtils.jsonToList(sku.getImage(), String.class);
			list.add(name);
			images = JsonUtils.objectToJson(list);
		}
		skuDao.changeSkuImage(images, id);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:11:49
	 * @description 
	 * @param ImageName
	 * @return
	 */
	@Override
	public QiuluResult deleteImage(String imageName,int id) {
		QiuluResult result = new QiuluResult();
		Sku sku = skuDao.getSkuById(id);
		List<String> list = JsonUtils.jsonToList(sku.getImage(), String.class);
		for(int i = 0;i < list.size();i ++){
			if(imageName.equals(list.get(i))){
				list.remove(i);
			}
		}
		String images = JsonUtils.objectToJson(list);
		skuDao.changeSkuImage(images, id);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月24日下午3:41:51
	 * @description 
	 * @param dateScope
	 * @param pageNumber
	 * @return
	 */
	@Override
	public QiuluResult getSkuByScope(String dateScope, int pageNumber) {
		QiuluResult result = new QiuluResult();
		SimpleDateFormat format;
		Date date = new Date();
		Page page = new Page();
		int count = 0;
		String scope = "";
		if(dateScope.equals("day")){
			format = new SimpleDateFormat("yyyy-MM-dd");
			scope = format.format(date);
			count = skuDao.getCountByScope(dateScope);
		} else if(dateScope.equals("month")){
			format = new SimpleDateFormat("yyyy-MM");
			scope = format.format(date);
			count = skuDao.getCountByScope(dateScope);
		} else if(dateScope.equals("all")){
			count = skuDao.getCountByScope(dateScope);
		}
		page.setBeginPage(pageNumber);
		page.setTotalCount(count);
		page.init();
		List<SkuCostum> list = skuDao.getSkuByScope((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage(), scope);
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日上午11:28:04
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult changeStatus(int id) {
		QiuluResult result = new QiuluResult();
		Sku sku = skuDao.getSkuById(id);
		if(sku.getStatus() == 0){
			sku.setStatus(1);
		} else if(sku.getStatus() == 1){
			sku.setStatus(0);
		}
		skuDao.updateSku(sku);
		result.setObject(sku.getStatus());
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午3:45:19
	 * @description 
	 * @param sku
	 * @return
	 */
	@Override
	public QiuluResult updateSku(Sku sku) {
		QiuluResult result = new QiuluResult();
		Sku oldSku = skuDao.getSkuById(sku.getId());
		if(sku.getDeliveryPlace() != null){
			oldSku.setDeliveryPlace(sku.getDeliveryPlace());
		}
		if(sku.getParamData() != null){
			oldSku.setParamData(sku.getParamData());
		}
		if(sku.getPrice() != null){
			oldSku.setPrice(sku.getPrice());
		}
		if(sku.getSellPoint() != null){
			oldSku.setSellPoint(sku.getSellPoint());
		}
		if(sku.getWarnRepertory() != null){
			oldSku.setWarnRepertory(sku.getWarnRepertory());
		}
		skuDao.updateSku(oldSku);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日上午10:18:01
	 * @description 
	 * @return
	 */
	@Override
	public QiuluResult getSkuByStatus(int pageNumber,int status) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = skuDao.getCountByStutas(status);
		page.setBeginPage(pageNumber);
		page.setTotalCount(count);
		page.init();
		List<Sku> list = skuDao.getSkuByStatus((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage(), status);
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月24日上午11:13:09
	 * @description 
	 * @param pageNumber
	 * @param name
	 * @return
	 */
	@Override
	public QiuluResult searchSku(int pageNumber, String name) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = skuDao.searchSkuCount(name);
		page.setBeginPage(pageNumber);
		page.setTotalCount(count);
		page.init();
		List<Sku> list = skuDao.searchSku((page.getBeginPage()-1)*page.getEveryPage(),page.getEveryPage(), name);
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月31日下午2:56:24
	 * @description 
	 * @param pageNumber
	 * @return
	 */
	@Override
	public QiuluResult getAllSku(int pageNumber) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = skuDao.getCount();
		page.setTotalCount(count);
		page.setBeginPage(pageNumber);
		page.init();
		List<Sku> list = skuDao.getAllSku((page.getBeginPage()-1)*page.getEveryPage(),page.getEveryPage());
		page.setList(list);
		result.setStatus(true);
		result.setObject(page);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年4月5日下午3:27:32
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult getSkuById(int id) {
		QiuluResult result = new QiuluResult();
		Sku sku = skuDao.getSkuById(id);
		result.setStatus(true);
		result.setObject(sku);
		return result;
	}
	
}
