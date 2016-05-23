package com.baby.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baby.user.service.UserService;
import com.baby.util.ApiJsonUtil;
import com.baby.util.ApiMessage;





/**
 * 用户
 * @author liujianjun
 *
 */
@Controller
@RequestMapping(value="/api/v1/userController")
public class UserController {

	final static Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	
	@Resource
	private UserService userService;
	
	
	/**
	 * 判断用户名是否存在
	 */
	@RequestMapping(value="/userIsExist",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userIsExist(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, Object> result = null;
		int apiCode = 0;
		
		String name = request.getParameter("name");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		try{
			if(name == null || "".equals(name.trim())){
				apiCode = ApiMessage.API_USER_NAME_NOT_EMTPY_CODE;
			}else{
				
			}
			
			result = ApiJsonUtil.getApiData(apiCode, null);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
	
	}
	
	
	
	
	
}
