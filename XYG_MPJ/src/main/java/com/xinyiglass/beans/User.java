package com.xinyiglass.beans;

/**
 * @author david
 *用户模型对应表中的xyg_user
 */
public class User {
	
	private int userId;
	private String userName;
	private String name;
	private String age;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", name="
				+ name + ", age=" + age + ", password=" + password + "]";
	}
	
}
