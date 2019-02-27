package com.howin.qiulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.UserService;
/**
 * 
* @Title: UserController
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午4:34:58
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午5:05:47
	 * @description 
	 * @param pageNumber
	 * @return QiuluResult
	 */
	@RequestMapping("/list")
	@ResponseBody
	public QiuluResult getAllUser(@RequestParam(defaultValue="1")int pageNumber){
		QiuluResult result = userService.getAllUser(pageNumber);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午5:11:58
	 * @description 
	 * @param id
	 * @return QiuluResult
	 */
	@RequestMapping("/get")
	@ResponseBody
	public QiuluResult getUser(int id){
		QiuluResult result = userService.getUserById(id);
		return result;
	}
}
