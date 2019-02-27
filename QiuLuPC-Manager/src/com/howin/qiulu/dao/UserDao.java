package com.howin.qiulu.dao;

import java.util.List;

import com.howin.qiulu.pojo.User;
import com.howin.qiulu.pojo.UserDetail;

/**
 * 
* @Title: UserDao
* @Description: 
* @author 吴磊
* @date 2017年2月23日下午4:35:37
 */
public interface UserDao {
	//得到所有用户信息
	List<User> getAllUser(int begin,int erery);
	//得到某一用户的信息
	User getUserById(int id);
	//得到某一用户的详细信息
	UserDetail getUserDetailById(int id);
	//的到用户的总数
	int getUserCount();
}
