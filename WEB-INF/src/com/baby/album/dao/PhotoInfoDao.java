/**
 * 
 */
package com.baby.album.dao;

import java.util.List;
import java.util.Map;

import com.baby.album.dto.PhotoInfo;

/** 
 * @author guolei 
 * @version 创建时间：2016年6月1日 下午4:00:27 
 */
public interface PhotoInfoDao {
    /**
     * 添加孩子照片信息
     * @param photoInfo
     */
    void addChildPhotoInfo(PhotoInfo photoInfo);
    
    /**
     * 查询指定的孩子照片的全部数量
     * @param map
     * @return
     */
    int findChildPhotoByIdCount(Map<String, Object> map);
    
    /**
     * 查询指定的孩子照片
     * @param map
     */
    List<PhotoInfo> findChildPhotoById(Map<String, Object> map);
}
