package com.baby.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baby.user.dao.UserDao;
import com.baby.user.service.UserService;

import util.DateUtil;



@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	@Override
	public void test() throws Exception {
		userDao.test();
	}

	
}
