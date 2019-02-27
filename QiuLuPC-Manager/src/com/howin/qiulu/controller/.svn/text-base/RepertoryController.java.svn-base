package com.howin.qiulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.RepertoryService;
/**
 * 
* @Title: RepertoryController
* @Description: 
* @author 吴磊
* @date 2017年2月23日上午11:49:51
 */
@Controller
public class RepertoryController {

	@Autowired
	private RepertoryService repertoryService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日上午11:52:05
	 * @description 
	 * @param type
	 * @return QiuluResult
	 */
	@RequestMapping("/repertory")
	@ResponseBody
	public QiuluResult getRepertory(int type,@RequestParam(defaultValue="1")int pageNumber){
		QiuluResult result = repertoryService.getRepertoryByType(type,pageNumber);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午12:04:30
	 * @description 
	 * @param id
	 * @param repertory
	 * @return QiuluResult
	 */
	@RequestMapping("/repertory/update")
	@ResponseBody
	public QiuluResult updateRepertory(int id,int repertory,int type){
		QiuluResult result = repertoryService.updateRepertory(id, repertory,type);
		return result;
	}
}
