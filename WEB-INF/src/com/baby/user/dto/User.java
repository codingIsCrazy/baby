package com.baby.user.dto;


/**
 * 用户
 * @author liujianjun
 *
 */
public class User {

	
	
	public String id;
	public String name;
	public String password;
	/**状态**/
	public String status;
	
	public static String STATUS_NORMAL = "normal";
	
	/**来源**/
	public String source;
	/**创建时间**/
	public Long createDate;
	/**token**/
	public String token;
	
	/**头像地址**/
	public String headImage;
	
	/**email**/
	public String email;
	
	/**搜索类型**/
	public int searchType;
	
	public int jobType ;
	
	public int sex;
	
	public static int SEARCH_TYPE_BING = 1;
	public static int SEARCH_TYPE_GOOGLE = 2;
	public static int SEARCH_TYPE_BAIDU = 3;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public int getJobType() {
		return jobType;
	}
	public void setJobType(int jobType) {
		this.jobType = jobType;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
	
}
