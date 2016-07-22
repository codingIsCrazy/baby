/**
 * 
 */
package com.baby.child.dao.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.spring.support.AbstractDaoSupport;
import org.springframework.stereotype.Repository;

import com.baby.child.dao.ChildInfoDao;
import com.baby.child.dto.ChildInfo;

/** 
 * @author guolei 
 * @version 创建时间：2016年5月28日 下午8:30:53 
 */
@Repository
public class ChildInfoMapper extends AbstractDaoSupport implements ChildInfoDao {
   
    /* (non-Javadoc)
     * @see com.baby.child.dao.ChildInfoDao#addChildInfo(int, com.baby.child.dto.ChildInfo)
     */
    @Override
    public void addChildInfo(ChildInfo childInfo) {
        getSession().insert(childInfo);
    }

    /* (non-Javadoc)
     * @see com.baby.child.dao.ChildInfoDao#removeChildInfo(int, com.baby.child.dto.ChildInfo)
     */
    @Override
    public void removeChildInfo(ChildInfo childInfo) {
        getSession().update(childInfo);
    }

    /* (non-Javadoc)
     * @see com.baby.child.dao.ChildInfoDao#updateChildInfo(int, com.baby.child.dto.ChildInfo)
     */
    @Override
    public void updateChildInfo(ChildInfo childInfo) {
        getSession().update(childInfo);
    }

    /* (non-Javadoc)
     * @see com.baby.child.dao.ChildInfoDao#queryChildInfoDao(long, java.util.Date)
     */
    @Override
    public List<ChildInfo> queryChildInfo(int userId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userId",userId);
        return getSession().selectList(map);
    }
}
