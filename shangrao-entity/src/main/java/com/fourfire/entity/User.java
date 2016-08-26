package com.fourfire.entity;

import java.io.Serializable;

public class User implements Serializable {

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", status=" + status + ", gmtCreated="
				+ gmtCreated + ", gmtModified=" + gmtModified + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -755947388791453132L;
	
	private long id;
	private String username;   //用户名
	private String password;   //密码
	private int status;   //用户状态(10:有效 20:无效)
	private long gmtCreated;   //创建时间(ms)
	private long gmtModified;   //最新修改时间(ms)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getGmtCreated() {
		return gmtCreated;
	}
	public void setGmtCreated(long gmtCreated) {
		this.gmtCreated = gmtCreated;
	}
	public long getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(long gmtModified) {
		this.gmtModified = gmtModified;
	}
}
