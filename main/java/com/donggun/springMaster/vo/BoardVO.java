package com.donggun.springMaster.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 게시글 정보 VO
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */
@Entity
@Table(name="BOARD")
public class BoardVO {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @NotNull @NotEmpty private String boardNo;	// PK
	@NotNull @NotEmpty private String regId; 	// FK
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Lob
	private String content;
	private int likeCnt;
	
	public String getboardNo() {
		return boardNo;
	}
	public void setboardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	
}
