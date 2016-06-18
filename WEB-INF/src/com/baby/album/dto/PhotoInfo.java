/**
 * 
 */
package com.baby.album.dto;
/** 
 * @author guolei 
 * @version 创建时间：2016年6月1日 下午4:02:39 
 */
public class PhotoInfo {
    private int id;
    private int userId;
    private int childId;
    private String photoUrl;
    private String description;
    private String photoTime;
    private String createTime;
    private String updateTime;
    private int status;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * @return the childId
     */
    public int getChildId() {
        return childId;
    }
    /**
     * @param childId the childId to set
     */
    public void setChildId(int childId) {
        this.childId = childId;
    }
    /**
     * @return the photoUrl
     */
    public String getPhotoUrl() {
        return photoUrl;
    }
    /**
     * @param photoUrl the photoUrl to set
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the photoTime
     */
    public String getPhotoTime() {
        return photoTime;
    }
    /**
     * @param photoTime the photoTime to set
     */
    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime;
    }
    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    /**
     * @return the updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }
    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
