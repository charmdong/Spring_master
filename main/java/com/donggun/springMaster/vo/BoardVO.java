package com.donggun.springMaster.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;
	
	@ManyToOne
	@JoinColumn(name="REG_ID")
	private UserVO user;
	
	@OneToMany(mappedBy="board")
	private List<CommentVO> commentList = new ArrayList<CommentVO>();
	
	@Lob
	private String content;
	private int likeCnt;
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
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
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		if(this.user != null) {
			this.user.getBoardList().remove(this);
		}
		
		this.user = user;
		user.getBoardList().add(this);
	}
	public List<CommentVO> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentVO> commentList) {
		this.commentList = commentList;
	}
	
}
