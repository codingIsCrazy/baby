/**
 * 
 */
package com.baby.album.service;

import java.util.List;
import java.util.Map;

import com.baby.album.dto.PhotoInfo;

/** 
 * @author guolei 
 * @version 创建时间：2016年6月1日 下午4:03:15 
 */
public interface PhotoInfoService {
    /**
     * 添加孩子照片信息
     * @param photoInfo
     */
    void addChildPhotoInfo(PhotoInfo photoInfo);
    
    /**
     * 查询特定的孩子照片的总数并返回
     * @param map
     * @return
     */
    int findChildPhotoByIdCount(Map<String, Object> map);
    
    /**
     * 查询特定的孩子照片并返回
     * @param map
     */
    List<PhotoInfo> findChildPhotoById(Map<String, Object> map);
}
