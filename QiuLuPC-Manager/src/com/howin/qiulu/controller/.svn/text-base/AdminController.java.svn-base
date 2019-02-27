package com.howin.qiulu.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howin.qiulu.pojo.Admin;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.AdminService;
/**
 * 
* @Title: AdminController
* @Description: 管理员控制层
* @author 吴磊
* @date 2017年2月20日上午9:50:50
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午9:56:11
	 * @description 请求登录，并返回登录结果
	 * @param admin
	 * @return QiuluResult
	 */
	@RequestMapping("/login")
	@ResponseBody
	public QiuluResult login(Admin admin,HttpSession session){
		QiuluResult result = adminService.login(admin);
		if(result.isStatus()){
			Admin adminResult = (Admin)result.getObject();
			adminResult.setPassword(null);
			//session.invalidate();
			session.setAttribute("admin",adminResult);
			result.setObject(null);
		}
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午10:59:21
	 * @description 得到管理员的信息
	 * @param session
	 * @return QiuluResult
	 */
	@RequestMapping("/getAdmin")
	@ResponseBody
	public QiuluResult getAdmin(HttpSession session){
		Admin admin = (Admin) session.getAttribute("admin");
		QiuluResult result = adminService.getAdmin(admin.getId());
		admin = (Admin) result.getObject();
		admin.setPassword(null);
		result.setObject(admin);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午11:03:57
	 * @description 更新管理员的信息
	 * @param admin
	 * @param session
	 * @return QiuluResult
	 */
	@RequestMapping("/saveAdmin")
	@ResponseBody
	public QiuluResult saveAdmin(Admin admin,HttpSession session){
		Admin sessionAdmin = (Admin)session.getAttribute("admin");
		admin.setId(sessionAdmin.getId());
		QiuluResult result = adminService.saveAdmin(admin);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月3日下午5:12:12
	 * @description 
	 * @param session
	 * @return QiuluResult
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public QiuluResult invalidateAdmin(HttpSession session){
		session.invalidate();
		QiuluResult result = new QiuluResult();
		result.setStatus(true);
		return result;
	}
}
