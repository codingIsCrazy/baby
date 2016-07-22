/**
 * 
 */
package com.baby.album.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baby.album.dao.PhotoInfoDao;
import com.baby.album.dto.PhotoInfo;
import com.baby.album.service.PhotoInfoService;

/** 
 * @author guolei 
 * @version 创建时间：2016年6月1日 下午4:04:19 
 */
@Service
public class PhotoInfoServiceImpl implements PhotoInfoService {
    
    @Resource
    private PhotoInfoDao photoInfoDao;
    
    /* (non-Javadoc)
     * @see com.baby.album.service.PhotoInfoService#addPhotoInfo(com.baby.album.dto.PhotoInfo)
     */
    @Override
    public void addChildPhotoInfo(PhotoInfo photoInfo) {
        photoInfoDao.addChildPhotoInfo(photoInfo);
    }
    
    /* (non-Javadoc)
     * @see com.baby.album.service.PhotoInfoService#findChildPhotoByIdCount(java.util.Map)
     */
    @Override
    public int findChildPhotoByIdCount(Map<String, Object> map) {
        return photoInfoDao.findChildPhotoByIdCount(map);
    }

    /* (non-Javadoc)
     * @see com.baby.album.service.PhotoInfoService#findChildPhotoById(java.util.Map)
     */
    @Override
    public List<PhotoInfo> findChildPhotoById(Map<String, Object> map) {
        return photoInfoDao.findChildPhotoById(map);
    }
}
