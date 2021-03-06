package com.baby.user.service;

import java.util.Map;

import com.baby.user.dto.User;



public interface UserService {

	public void test() throws Exception;
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	
	/**
	 * 查询用户
	 */
	public User  queryUser(Map<String, Object> map);
	
	/**
	 * 更新token
	 */
	public void updateToken(Map<String, Object> map);
	
	/**
	 * 获取用户通过token
	 */
	public User getUserByToken(String token);
	
	/**
	 * 更细用户资料
	 */
	public void updateUserByToken(Map<String, Object> map);
}
