package com.baby.user.dao.mappers;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.ibatis.spring.support.AbstractDaoSupport;
import org.springframework.stereotype.Repository;

import com.baby.user.dao.UserDao;



@Repository
public class UserMapper extends AbstractDaoSupport implements UserDao{

	@Override
	public void test() throws Exception {
		List<Map<String, Object>> list = getSession().selectList();
		for(Map<String, Object> m : list){
			System.out.println(m);
		}
	}

	

}
