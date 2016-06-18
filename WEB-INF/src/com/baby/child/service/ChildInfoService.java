/**
 * 
 */
package com.baby.child.service;

import java.util.List;
import com.baby.child.dto.ChildInfo;

/** 
 * @author guolei 
 * @version 创建时间：2016年5月28日 下午8:25:42 
 */
public interface ChildInfoService {
    
    /**
     * 添加用户孩子信息
     * @param map
     */
    void addChildInfo(ChildInfo childInfo);
    
    /**
     * 移除用户孩子信息
     * @param map
     */
    void removeChildInfo(ChildInfo childInfo);
    
    /**
     * 更新用户孩子信息
     * @param map
     */
    void updateChildInfo(ChildInfo childInfo);
    
    /**
     * 查询用户孩子信息
     * @param userId
     * @return
     */
    List<ChildInfo> queryChildInfo(int userId);
}
