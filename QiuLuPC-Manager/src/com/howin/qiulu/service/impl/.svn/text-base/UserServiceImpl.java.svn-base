package com.howin.qiulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.UserDao;
import com.howin.qiulu.page.Page;
import com.howin.qiulu.pojo.User;
import com.howin.qiulu.pojo.UserDetail;
import com.howin.qiulu.pojo.custom.UserCustom;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.UserService;
/**
 * 
* @Title: UserServiceImpl
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午4:51:48
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:53:09
	 * @description 
	 * @param pageNumber
	 * @return
	 */
	@Override
	public QiuluResult getAllUser(int pageNumber) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = userDao.getUserCount();
		page.setBeginPage(pageNumber);
		page.setTotalCount(count);
		page.init();
		List<User> list = userDao.getAllUser((page.getBeginPage()-1)*page.getEveryPage(), page.getEveryPage());
		page.setList(list);
		result.setStatus(true);
		result.setObject(page);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月23日下午4:58:14
	 * @description 
	 * @param id
	 * @return
	 */
	@Override
	public QiuluResult getUserById(int id) {
		QiuluResult result = new QiuluResult();
		UserCustom userCostom = new UserCustom();
		User user = userDao.getUserById(id);
		UserDetail userDetail = userDao.getUserDetailById(id);
		userCostom.setUser(user);
		userCostom.setUserDetail(userDetail);
		result.setObject(userCostom);
		result.setStatus(true);
		return result;
	}

}
