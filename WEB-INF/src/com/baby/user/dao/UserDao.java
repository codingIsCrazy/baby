package com.baby.user.dao;

import java.util.List;
import java.util.Map;

import com.baby.user.dto.User;


public interface UserDao {

	
	public void test() throws Exception;
	
	/**
	 * 添加用户
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
	
	/**
	 * 查询用户
	 */
	public List<User> queryUserByLike(String content);
	
}
