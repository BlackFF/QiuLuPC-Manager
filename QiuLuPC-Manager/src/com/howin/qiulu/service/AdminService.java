package com.howin.qiulu.service;

import com.howin.qiulu.pojo.Admin;
import com.howin.qiulu.result.QiuluResult;
/**
 * 
* @Title: AdminService
* @Description: 
* @author 吴磊
* @date 2017年2月24日下午5:37:05
 */
public interface AdminService {
	//管理员的登录验证
	QiuluResult login(Admin admin);
	//得到一个管理员的信息
	QiuluResult getAdmin(int id);
	//添加一个管理员
	QiuluResult saveAdmin(Admin admin);
}
