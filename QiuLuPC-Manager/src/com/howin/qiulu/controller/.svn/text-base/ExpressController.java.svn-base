package com.howin.qiulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.ExpressService;

@Controller
@RequestMapping("/express")
public class ExpressController {
	
	@Autowired
	ExpressService expressService;
	
	
	@RequestMapping("/getAllExpressCompany")
	@ResponseBody
	public QiuluResult getAllExpressCompany(){
		QiuluResult result = expressService.getAllExpress();
		return result;
	}

}
