package com.howin.qiulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.AdminDao;
import com.howin.qiulu.pojo.Admin;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.AdminService;
/**
 * 
* @Title: AdminServiceImpl
* @Description: 管理员业务层
* @author 吴磊
* @date 2017年2月20日上午9:53:10
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午9:54:31
	 * @description 管理员的登录验证
	 * @param admin
	 * @return
	 */
	@Override
	public QiuluResult login(Admin admin) {
		QiuluResult result = new QiuluResult();
		List<Admin> list = adminDao.getAdminByAccount(admin.getAccount());
		if(list == null || list.size() == 0){
			result.setStatus(false);
			result.setMessage("用户名不存在");
		} else {
			Admin adminResult = list.get(0);
			if(admin.getPassword().equals(adminResult.getPassword())){
				result.setStatus(true);
				result.setObject(adminResult);
			} else {
				result.setStatus(false);
				result.setMessage("密码错误");
			}
		}
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午10:53:01
	 * @description 根据id获取管理员
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult getAdmin(int id) {
		// TODO Auto-generated method stub
		QiuluResult result = new QiuluResult();
		Admin admin = adminDao.getAdminById(id);
		result.setStatus(true);
		result.setObject(admin);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月20日上午11:10:27
	 * @description 存储管理员的详细信息
	 * @param admin
	 * @return
	 */
	@Override
	public QiuluResult saveAdmin(Admin admin) {
		QiuluResult result = new QiuluResult();
		int saveAdmin = adminDao.saveAdmin(admin);
		if(saveAdmin == 1){
			result.setStatus(true);
		} else {
			result.setStatus(false);
		}
		return result;
	}

}
