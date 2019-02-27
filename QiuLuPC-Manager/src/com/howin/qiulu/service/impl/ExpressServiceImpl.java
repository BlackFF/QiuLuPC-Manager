package com.howin.qiulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.ExpressDao;
import com.howin.qiulu.pojo.Express;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.ExpressService;

@Service
public class ExpressServiceImpl implements ExpressService {
	
	@Autowired
	ExpressDao expressDao;

	/** 
	* @Title: getAllExpress 
	* @date 2017年4月26日14:59:46
	* @author 魏吉鹏
	* @Description: TODO  查询所有快递公司
	* @return
	* @return QiuluResult
	* @throws 
	*/ 
	@Override
	public QiuluResult getAllExpress() {
		QiuluResult result = new QiuluResult();
		List<Express> list = expressDao.getAllExpress();
		if(list == null || list.size() == 0){
			result.setStatus(false);
			result.setMessage("加载快递公司失败");
		}else{
			result.setStatus(true);
			result.setObject(list);
		}
		return result;
	}
	

}