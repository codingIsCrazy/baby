/**
 * 
 */
package com.baby.album.controller;

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

import com.baby.album.dto.PhotoInfo;
import com.baby.album.service.PhotoInfoService;
import com.baby.child.controller.ChildInfoController;
import com.baby.child.service.ChildInfoService;
import com.baby.user.dto.User;
import com.baby.user.service.UserService;
import com.baby.util.ApiJsonUtil;
import com.baby.util.ApiMessage;

/** 
 * @author guolei 
 * @version 创建时间：2016年6月1日 下午4:02:17 
 */
@Controller
@RequestMapping(value="/api/v1/photoInfoController")
public class PhotoInfoController {
    
    final static Logger LOG = LoggerFactory.getLogger(ChildInfoController.class);
    
    @Resource
    UserService userService;
    @Resource
    ChildInfoService childInfoService;
    @Resource 
    PhotoInfoService photoInfoService;
    
    @RequestMapping(value="/addPhotoInfo", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addPhotoInfo(HttpServletRequest request, HttpServletResponse response, PhotoInfo photoInfo) {
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
            photoInfo.setUserId(userId);
            photoInfo.setCreateTime(DateUtil.getNow());
            photoInfo.setUpdateTime(DateUtil.getNow());
            result.put("list", photoInfo);
            photoInfoService.addChildPhotoInfo(photoInfo);
            result = ApiJsonUtil.getApiData(apiCode, result);
        } catch(Exception e) {
            result = ApiJsonUtil.getServerError();
            e.printStackTrace();
        }
        return result;
    } 
    
    @RequestMapping(value="/findChildPhotoById", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findChildPhotoById(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = null;
        int apiCode = 0;
        result = new HashMap<String, Object>();
        try {
            String token = request.getParameter("token"); 
            String childId = request.getParameter("childId");
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            if (token == null || token.length() <= 0) {
                apiCode = ApiMessage.API_PARAM_ERROR_CODE;
                result = ApiJsonUtil.getApiData(apiCode, null);
                return result;
            }
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("childId", Integer.parseInt(childId));
            int pageCurrentNumber = Integer.parseInt(currentPage);
            int pageSizeNumber = Integer.parseInt(pageSize);
            int pageIndex = (pageCurrentNumber - 1) * pageSizeNumber;
            paramMap.put("pageIndex", pageIndex);
            paramMap.put("pageSize", Integer.parseInt(pageSize));
            List<PhotoInfo> list = photoInfoService.findChildPhotoById(paramMap);
            Map<String, Object> childParam = new HashMap<String, Object>();
            childParam.put("childId", childId);
            int allPhotoCount = photoInfoService.findChildPhotoByIdCount(childParam);
            int pageCount = (allPhotoCount % pageSizeNumber == 0) ? (allPhotoCount / pageSizeNumber) : (allPhotoCount / pageSizeNumber + 1); 
            result.put("pageCount", pageCount);
            result.put("currentPage", pageCurrentNumber);
            result.put("list", list);
            result = ApiJsonUtil.getApiData(apiCode, result);
        } catch(Exception e) {
            result = ApiJsonUtil.getServerError();
            e.printStackTrace();
        }
        return result;
    } 
}
