/**
 * 
 */
package com.baby.album.dao.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.spring.support.AbstractDaoSupport;
import org.springframework.stereotype.Repository;

import com.baby.album.dao.PhotoInfoDao;
import com.baby.album.dto.PhotoInfo;

/** 
 * @author guolei 
 * @version 创建时间：2016年6月1日 下午4:01:02 
 */
@Repository
public class PhotoInfoMapper extends AbstractDaoSupport implements PhotoInfoDao {
    
    /* (non-Javadoc)
     * @see com.baby.album.dao.PhotoInfoDao#addPhotoInfo(com.baby.album.dto.PhotoInfo)
     */
    @Override
    public void addChildPhotoInfo(PhotoInfo photoInfo) {
        getSession().insert(photoInfo);
    }
    
    /* (non-Javadoc)
     * @see com.baby.album.dao.PhotoInfoDao#findChildPhotoByIdCount(java.util.Map)
     */
    @Override
    public int findChildPhotoByIdCount(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return getSession().selectOne(map);
    } 

    /* (non-Javadoc)
     * @see com.baby.album.dao.PhotoInfoDao#findChildPhotoById(java.util.Map)
     */
    @Override
    public List<PhotoInfo> findChildPhotoById(Map<String, Object> map) {
        return getSession().selectList(map);
    }
}
