/**
 * 
 */
package com.baby.child.controller;

import java.util.HashMap;
import java.util.List;
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

import util.DateUtil;

import com.baby.child.dto.ChildInfo;
import com.baby.child.service.ChildInfoService;
import com.baby.user.dto.User;
import com.baby.user.service.UserService;
import com.baby.util.ApiJsonUtil;
import com.baby.util.ApiMessage;

/** 
 * @author guolei 
 * @version 创建时间：2016年5月28日 下午8:29:33 
 */
@Controller
@RequestMapping(value="/api/v1/childInfoController")
public class ChildInfoController {
    
    final static Logger LOG = LoggerFactory.getLogger(ChildInfoController.class);
    
    @Resource
    private UserService userService;
    @Resource
    private ChildInfoService childInfoService;
     
    @RequestMapping(value="/addChildInfo", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addChildInfo(HttpServletRequest request, HttpServletResponse response, ChildInfo childInfo) {
        Map<String, Object> result = null;
        int apiCode = 0;
        result = new HashMap<String, Object>();
        try {
            String token = request.getParameter("token");
            if (token == null || token.length() <= 0) {
                apiCode = ApiMessage.API_PARAM_ERROR_CODE;
                result = ApiJsonUtil.getApiData(apiCode, null);
                return result;
            }
            User user = userService.getUserByToken(token);
            int userId = user.getId();
            childInfo.setUserId(userId);
            childInfo.setCreateTime(DateUtil.getNow());
            childInfo.setUpdateTime(DateUtil.getNow());
            result.put("list", childInfo);
            childInfoService.addChildInfo(childInfo);
            result = ApiJsonUtil.getApiData(apiCode, result);
        } catch(Exception exception) {
            result = ApiJsonUtil.getServerError();
            exception.printStackTrace(); 
        }
        return result;
    }
    
    @RequestMapping(value="/removeChildInfo", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object>  removeChildInfo(HttpServletRequest request, HttpServletResponse response, ChildInfo childInfo) {
        Map<String, Object> result = null;
        int apiCode = 0;
        result = new HashMap<String, Object>();
        try {
            String token = request.getParameter("token");
            if (token == null || token.length() <= 0) {
                apiCode = ApiMessage.API_PARAM_ERROR_CODE;
                result = ApiJsonUtil.getApiData(apiCode, null);
                return result;
            }
            User user = userService.getUserByToken(token);
            int userId = user.getId();
            childInfo.setUserId(userId);
            childInfoService.removeChildInfo(childInfo);
            result = ApiJsonUtil.getApiData(apiCode, null);
        } catch(Exception exception) {
            result = ApiJsonUtil.getServerError();
            exception.printStackTrace(); 
        }
        return result;
    }
    
    @RequestMapping(value="/updateChildInfo", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateChildInfo(HttpServletRequest request, HttpServletResponse response, ChildInfo childInfo) {
        Map<String, Object> result = null;
        int apiCode = 0;
        result = new HashMap<String, Object>();
        try {
            String token = request.getParameter("token");
            if (token == null || token.length() <= 0) {
                apiCode = ApiMessage.API_PARAM_ERROR_CODE;
                result = ApiJsonUtil.getApiData(apiCode, null);
                return result;
            }
            User user = userService.getUserByToken(token);
            int userId = user.getId();
            childInfo.setUserId(userId);
            childInfo.setUpdateTime(DateUtil.getNow());
            childInfoService.updateChildInfo(childInfo);
            result = ApiJsonUtil.getApiData(apiCode, null);
        } catch(Exception exception) {
            result = ApiJsonUtil.getServerError();
            exception.printStackTrace(); 
        }
        return result;
    }
    
    @RequestMapping(value="/queryChildInfo", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryChildInfo(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = null;
        int apiCode = 0;
        result = new HashMap<String, Object>();
        try {
            String token = request.getParameter("token");
            if (token == null || token.length() <= 0) {
                apiCode = ApiMessage.API_PARAM_ERROR_CODE;
                result = ApiJsonUtil.getApiData(apiCode, null);
                return result;
            }
            User user = userService.getUserByToken(token);
            int userId = user.getId();
            List<ChildInfo> queryChildResult = childInfoService.queryChildInfo(userId);
            Map<String, Object> queryParamMap = new HashMap<String, Object>();
            queryParamMap.put("list",queryChildResult);
            result = ApiJsonUtil.getApiData(apiCode, queryParamMap);
        } catch(Exception exception) {
            result = ApiJsonUtil.getServerError();
            exception.printStackTrace(); 
        }
        return result;
    }
}
