package com.baby.user.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import util.DateUtil;
import util.JsonUtils;
import util.MD5Util;
import util.UuidUtil;

import com.baby.user.dto.User;
import com.baby.user.service.UserService;
import com.baby.util.ApiJsonUtil;
import com.baby.util.ApiMessage;
import com.baby.util.Contants;
import com.baby.util.ImageUtil;





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
	@RequestMapping(value="/userIsExist")
	@ResponseBody
	public Map<String, Object> userIsExist(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, Object> result = null;
		int apiCode = 0;
		
		String phone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("phone", phone);
		try{
			if(phone == null || "".equals(phone.trim())){
				apiCode = ApiMessage.API_USER_NAME_NOT_EMTPY_CODE;
			}else{
				User user = userService.queryUser(map);
				if(user != null){
					apiCode = ApiMessage.API_USER_EXIST_CODE;
				}
			}
			
			result = ApiJsonUtil.getApiData(apiCode, null);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
	
	}
	
	
	
	
	/**
	 * 登录
	 */
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userLogin(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> result = null;
		int apiCode = 0;
		
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("phone", phone);
		map.put("password", MD5Util.string2MD5(password));
		
		User user = null;
		try{
			if(phone == null || "".equals(phone.trim())){
				apiCode = ApiMessage.API_USER_NAME_NOT_EMTPY_CODE;
			}else if(password == null || "".equals(password.trim())){
				apiCode = ApiMessage.API_USER_PASSWORD_NOT_EMPTY_CODE;
			} else{
				user = userService.queryUser(map);
				if(user == null){
					apiCode = ApiMessage.API_USER_NOT_EXIST_CODE;
				}else{
					//更新token
					Map<String, Object> tokenMap = new HashMap<String,Object>();
					tokenMap.put("id", user.getId());
					String token = UuidUtil.getUniqueUUid();
					tokenMap.put("token",token);
					userService.updateToken(tokenMap);
					user.setToken(token);
					user.setId(0);
				}
			}
			
			result = ApiJsonUtil.getApiData(apiCode, user);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
	}
	
	
	
	/**
	 * 注册
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request,HttpServletResponse response,User user){
		Map<String, Object> result = null;
		int apiCode = 0;
		
		String phone = user.getPhone();
		String password = user.getPassword();
		String paramStr = request.getParameter("param");
		JSONObject paramJson = JsonUtils.strToJson(paramStr);
		
		try{
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("phone", user.getPhone());
			User userRe = userService.queryUser(param);
			if(phone == null || "".equals(phone.trim())){
				apiCode = ApiMessage.API_PHONE_ERROR_CODE;
			}else if(password == null || "".equals(password.trim())){
				apiCode = ApiMessage.API_USER_PASSWORD_NOT_EMPTY_CODE;
			}else if(userRe != null){
				apiCode = ApiMessage.API_USER_EXIST_CODE;
			}else{
				//获取token
				String token = UuidUtil.getUniqueUUid();
				user.setDevice(paramJson.getString("device"));
				user.setToken(token);
				user.setPassword(MD5Util.string2MD5(user.getPassword()));
				user.setCreateTime(DateUtil.getNow());
				user.setUpdateTime(DateUtil.getNow());
				//添加
				userService.addUser(user);
			}
			
			user.setId(0);
			result = ApiJsonUtil.getApiData(apiCode, user);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
	}
	
	
	/**
	 * 上传头像
	 */
	@RequestMapping(value="/uploadHeadImg",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadHeadImg(HttpServletRequest request,HttpServletResponse response,User user){
		
		MultipartHttpServletRequest multipartHttpservletRequest = (MultipartHttpServletRequest) request;
		Map<String, Object> result = new HashMap<String,Object>();
		try{
			
	        MultipartFile multipartFile = multipartHttpservletRequest.getFile("uploadFile");
	        InputStream inputStream = multipartFile.getInputStream();
	        	
	        String fileName =  multipartFile.getOriginalFilename();
	        fileName = fileName.substring(fileName.lastIndexOf("."));
	        String img = ImageUtil.getAliImgurl(inputStream,fileName,"head_img/" + DateUtil.getNowDateStr().replace("-", ""));
	        Map<String, Object> data = new HashMap<String,Object>();
	     
	        data.put("headImage", img);
	        result = ApiJsonUtil.getApiData(ApiMessage.API_SUCCESS_CODE, data);
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
		}catch (Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	
	/**
	 * 忘记密码
	 */
	
	
	
	
	/**
	 * 修改资料
	 */
	@RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUserInfo(HttpServletRequest request,HttpServletResponse reponse){
		
		Map<String, Object> result = null;
		int apiCode = 0;
		
		String name = request.getParameter("name");
		String paramStr = request.getParameter("param");
		JSONObject paramJson = JsonUtils.strToJson(paramStr);
		String device = paramJson.getString("device");
		String updateTime = DateUtil.getNow();
		String headImg = request.getParameter("headImg");
		String token = request.getParameter("token");
		
		try{
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("name", name);
			map.put("device", device);
			map.put("updateTime", updateTime);
			map.put("headImg", headImg);
			map.put("token", token);
			
			userService.updateUserByToken(map);;
			
			result = ApiJsonUtil.getApiData(apiCode, null);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
		
	}
	
	
	/**
	 * 发送短信
	 */
	@RequestMapping(value="/sendMessage")
	@ResponseBody
	public Map<String, Object> sendMessage(HttpServletRequest request,HttpServletResponse reponse){
		Map<String, Object> result = null;
		int apiCode = 0;
		
		String phone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("phone", phone);
		try{
			userService.test();
			if(phone == null || "".equals(phone.trim())){
				apiCode = ApiMessage.API_PHONE_ERROR_CODE;
			}else{
				
			}
			
			result = ApiJsonUtil.getApiData(apiCode, null);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	/**
	 * 获取我的信息
	 */
	@RequestMapping(value="/getMe")
	@ResponseBody
	public Map<String, Object> getMe(HttpServletRequest request,HttpServletResponse reponse){
		
		String token = request.getParameter("token");
		
		Map<String, Object> result = null;
		int apiCode = 0;
		
		try{
			Map<String, Object> rMap = new HashMap<String, Object>();
			//个人资料
			User user = null;
			if(token == null || "".equals(token.trim())){
				user = new User();
			}else{
				user = userService.getUserByToken(token);
				if(user == null){
					user = new User(); 
				}else{
					user.setPassword("");
					user.setId(0);
				}
			}
			rMap.put("user", user);
			
			//显示的列表：1.广场管理 2.个人资料修改 3.baby列表 4.联系方式
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
			
			//广场
			Map<String,Object> square = new HashMap<String, Object>();
			square.put("id", 0);
			square.put("img", Contants.SQUARE_IMG);
			square.put("name", "广场管理");
			list.add(square);
			
			//个人资料
			Map<String,Object> person = new HashMap<String, Object>();
			person.put("id", 0);
			person.put("img", user.getHeadImg());
			person.put("name", "个人资料");
			list.add(person);
			
			//baby列表
			
			
			
			//联系方式
			Map<String,Object> contact = new HashMap<String, Object>();
			contact.put("id", 0);
			contact.put("img", user.getHeadImg());
			contact.put("name", "13521688153");
			list.add(contact);
			
			rMap.put("list", list);
			result = ApiJsonUtil.getApiData(apiCode, rMap);
			
		}catch(Exception e){
			result = ApiJsonUtil.getServerError();
			e.printStackTrace(); 
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
