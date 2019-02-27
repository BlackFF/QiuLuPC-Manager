package com.howin.qiulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.EvaluationService;
/**
 * 
* @Title: EvaluationController
* @Description: 
* @author 吴磊
* @date 2017年3月23日上午11:04:03
 */
@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationService evaluationService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月23日上午11:04:14
	 * @description 
	 * @param pageNumber
	 * @return QiuluResult
	 */
	@ResponseBody
	@RequestMapping("/get")
	public QiuluResult getAllEvaluation(@RequestParam(defaultValue="1")int pageNumber){
		QiuluResult result = evaluationService.getAllEvaluation(pageNumber);
		return result;
	}
}
