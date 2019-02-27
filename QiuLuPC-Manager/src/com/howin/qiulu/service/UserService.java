package com.howin.qiulu.service;

import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: UserService
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午4:51:09
 */
public interface UserService {
	//获得所有用户列表
	QiuluResult getAllUser(int pageNumber);
	//根据ID获取某个用户的详细信息
	QiuluResult getUserById(int id);
}
