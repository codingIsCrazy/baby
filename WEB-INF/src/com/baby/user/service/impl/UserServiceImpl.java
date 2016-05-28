package com.baby.user.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baby.user.dao.UserDao;
import com.baby.user.dto.User;
import com.baby.user.service.UserService;




@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	@Override
	public void test() throws Exception {
		userDao.test();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User queryUser(Map<String, Object> map) {
		return userDao.queryUser(map);
	}

	@Override
	public void updateToken(Map<String, Object> map) {
		userDao.updateToken(map);
	}

	@Override
	public User getUserByToken(String token) {
		return userDao.getUserByToken(token);
	}

	@Override
	public void updateUserByToken(Map<String, Object> map) {
		userDao.updateUserByToken(map);
	}

	
}
