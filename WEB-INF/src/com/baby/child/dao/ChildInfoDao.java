/**
 * 
 */
package com.baby.child.dao;

import java.util.List;

import com.baby.child.dto.ChildInfo;

/** 
 * @author guolei 
 * @version 创建时间：2016年5月28日 下午8:30:01 
 */
public interface ChildInfoDao {
    
    /**
     * 添加孩子信息
     * @param map
     */
    void addChildInfo(ChildInfo childInfo);
    
    /**
     * 移除用户对应的孩子信息
     * @param map
     */
    void removeChildInfo(ChildInfo childInfo);
    
    /**
     * 更新用户对应的孩子信息
     * @param map
     */
    void updateChildInfo(ChildInfo childInfo);
    
    /**
     * 查询孩子信息
     * @param userId
     * @return
     */
    List<ChildInfo> queryChildInfo(int userId);
}
