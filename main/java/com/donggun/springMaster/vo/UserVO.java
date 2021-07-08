package com.donggun.springMaster.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 사용자 정보 VO
 * 
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */

@Entity
@Table(name = "USER")
public class UserVO {

	@Id
	@NotNull
	@NotEmpty
	@ApiModelProperty(example = "사용자 아이디")
	private String id;
	
	@NotNull
	@NotEmpty
	@Column(name="NICK_NAME")
	@ApiModelProperty(example = "사용자 닉네임")
	private String nickName;
	
	@NotNull
	@NotEmpty
	@ApiModelProperty(example = "사용자 패스워드")
	private String password;
	
	@NotNull
	@NotEmpty
	@Column(name="USER_NAME")
	@ApiModelProperty(example = "사용자 이름")
	private String userName;
	
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	private String phone;
	
	private String homepage;
	
	@Lob
	private String description;

	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	private List<BoardVO> boardList = new ArrayList<BoardVO>();

	@Column(name="ROLE_TYPE")
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Column(name="REG_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Column(name="MOD_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;

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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", nickName=" + nickName + ", password=" + password + ", userName=" + userName
				+ ", email=" + email + ", phone=" + phone + ", homepage=" + homepage + ", description=" + description
				+ ", roleType=" + roleType + ", regDate=" + regDate + ", modDate="
				+ modDate + "]";
	}
	
}