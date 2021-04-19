package com.donggun.springMaster.dto;

public class MemberVO {
	private String name;
	private String email;
	private String id;
	private String password;
	private String confirmPassword;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", email=" + email + ", id=" + id + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
}
