package com.donggun.springMaster.vo;

import java.util.Date;

/**
 * 사용자 로그인시 세션에 담을 사용자 정보 객체
 * @author donggun.Chung
 * @since 2021.05.05.
 * @version 1.0
 */

public class LoginVO {	
	String 	id;
	String 	name;
	boolean isAdmin;
	Date 	LoginDate;
	
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
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getLoginDate() {
		return LoginDate;
	}
	public void setLoginDate(Date loginDate) {
		LoginDate = loginDate;
	}
	
	
}
