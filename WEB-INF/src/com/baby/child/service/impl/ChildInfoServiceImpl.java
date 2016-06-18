/**
 * 
 */
package com.baby.child.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baby.child.dao.ChildInfoDao;
import com.baby.child.dto.ChildInfo;
import com.baby.child.service.ChildInfoService;

/** 
 * @author guolei 
 * @version 创建时间：2016年5月28日 下午8:25:14 
 */
@Service
public class ChildInfoServiceImpl implements ChildInfoService {
    
    @Resource
    private ChildInfoDao childInfoDao;
    
    /* (non-Javadoc)
     * @see com.baby.child.service.ChildInfoService#addChildInfo(java.util.Map)
     */
    @Override
    public void addChildInfo(ChildInfo childInfo) {
        childInfoDao.addChildInfo(childInfo);
    }

    /* (non-Javadoc)
     * @see com.baby.child.service.ChildInfoService#removeChildInfo(java.util.Map)
     */
    @Override
    public void removeChildInfo(ChildInfo childInfo) {
        childInfoDao.removeChildInfo(childInfo);
    }

    /* (non-Javadoc)
     * @see com.baby.child.service.ChildInfoService#updateChildInfo(java.util.Map)
     */
    @Override
    public void updateChildInfo(ChildInfo childInfo) {
        childInfoDao.updateChildInfo(childInfo);
    }
    
    /* (non-Javadoc)
     * @see com.baby.child.service.ChildInfoService#queryChildInfo(java.util.Date)
     */
    @Override
    public List<ChildInfo> queryChildInfo(int userId) {
        return childInfoDao.queryChildInfo(userId);
    }
}
