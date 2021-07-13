package com.donggun.springMaster.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 게시글 정보 VO
 * 
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */
@Entity
@Table(name = "BOARD")
public class BoardVO {

	@Id
	@Column(name="BOARD_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@NotEmpty
	private String boardNo; // PK

	@Column(name="REG_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Column(name="MOD_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;

	@ManyToOne
	@JoinColumn(name = "REG_ID")
	private UserVO user;

	@OneToMany(mappedBy = "board", fetch=FetchType.EAGER)
	@JsonBackReference
	private List<CommentVO> commentList = new ArrayList<CommentVO>();

	@OneToMany(mappedBy = "board", fetch=FetchType.EAGER)
	@JsonBackReference
	private List<FileVO> fileList = new ArrayList<FileVO>();

	@Lob
	private String content;
	
	@Column(name="LIKE_CNT")
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
		if (this.user != null) {
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

	public List<FileVO> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileVO> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", regDate=" + regDate + ", modDate=" + modDate + ", user=" + user
				+ ", commentList=" + commentList + ", fileList=" + fileList + ", content=" + content + ", likeCnt="
				+ likeCnt + "]";
	}

}
