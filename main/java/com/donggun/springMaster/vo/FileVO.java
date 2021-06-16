package com.donggun.springMaster.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 이미지 파일 정보 VO
 * 
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */
@Entity
@Table(name = "FILE")
public class FileVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String fileNo;

	@ManyToOne
	@JoinColumn(name = "BOARD_NO")
	private BoardVO board;

	private String fileName; // CPK with boardNo
	private String filePath;
	@Size(max = 1024000)
	private String fileSize;

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		if (this.board != null) {
			this.board.getFileList().remove(this);
		}

		this.board = board;
		board.getFileList().add(this);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

}
