package com.donggun.springMaster.vo;

import javax.validation.constraints.Size;

/**
 * 이미지 파일 정보 VO
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */
public class FileVO {
	
	private String boardNo;		// FK
	private String fileName;	// CPK with boardNo
	private String filePath;
	@Size(max=1024000) private String fileSize;
	
	public String getboardNo() {
		return boardNo;
	}
	public void setboardNo(String boardNo) {
		this.boardNo = boardNo;
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