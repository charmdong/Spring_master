package com.donggun.springMaster.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 사용자 정보 VO
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */
public class UserVO {
	
	@NotNull @NotEmpty private String id;		// PK, FK
	@NotNull @NotEmpty private String nickName;
	@NotNull @NotEmpty private String password;
	@NotNull @NotEmpty private String name;
	@Email private String email;
	@NotNull @NotEmpty private String phone;
	private String homepage;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
