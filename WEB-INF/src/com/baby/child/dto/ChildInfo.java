/**
 * 
 */
package com.baby.child.dto;

import java.util.Date;

/** 
 * @author guolei 
 * @version 创建时间：2016年5月28日 下午8:08:19 
 */
public class ChildInfo {
    private int id;
    private String name;
    private String nickName;
    private short sex;
    private Date birthday;
    private String icon;
    private int userId;
    private String birthdayTime;
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
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * @return the sex
     */
    public short getSex() {
        return sex;
    }
    /**
     * @param sex the sex to set
     */
    public void setSex(short sex) {
        this.sex = sex;
    }
    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }
    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }
    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * @return the birthdayTime
     */
    public String getBirthdayTime() {
        return birthdayTime;
    }
    /**
     * @param birthdayTime the birthdayTime to set
     */
    public void setBirthdayTime(String birthdayTime) {
        this.birthdayTime = birthdayTime;
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
