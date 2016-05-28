package com.baby.user.dao.mappers;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.ibatis.spring.support.AbstractDaoSupport;
import org.springframework.stereotype.Repository;

import com.baby.user.dao.UserDao;
import com.baby.user.dto.User;



@Repository
public class UserMapper extends AbstractDaoSupport implements UserDao{

	@Override
	public void test() throws Exception {
		List<Map<String, Object>> list = getSession().selectList();
		for(Map<String, Object> m : list){
			System.out.println(m);
		}
	}

	@Override
	public void addUser(User user) {
		getSession().insert(user);
	}

	@Override
	public User queryUser(Map<String, Object> map) {
		return getSession().selectOne(map);
	}

	@Override
	public void updateToken(Map<String, Object> map) {
		if(map.get("id") == null && map.get("phone") == null){
			return;
		}else{
			getSession().update(map);
		}
	}

	@Override
	public User getUserByToken(String token) {
		return getSession().selectOne(token);
	}

	@Override
	public void updateUserByToken(Map<String, Object> map) {
		getSession().update(map);
	}

	

}
