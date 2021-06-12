package com.donggun.springMaster.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 사용자 정보 VO
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */

@Entity
@Table(name="USER")
public class UserVO {
	
	@Id @NotNull @NotEmpty private String id;
	@NotNull @NotEmpty private String nickName;
	@NotNull @NotEmpty private String password;
	@NotNull @NotEmpty private String userName;
	@Email private String email;
	@NotNull @NotEmpty private String phone;
	private String homepage;
	private String description;
	
	@OneToMany(mappedBy="user")
	private List<BoardVO> boardList = new ArrayList<BoardVO>();
	
	@NotNull @NotEmpty
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@NotNull @NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@NotNull @NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public List<BoardVO> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
}