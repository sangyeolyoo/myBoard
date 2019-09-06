package com.example.demo.domain;


public class FileVO {
	/** 파일 번호 **/
	private int fno;
	/** 게시글 번호 **/
	private int bno;
	/** 파일 이름 **/
	private String fileName;
	/** 파일 오리지널 이름 **/
	private String fileOriName;
	/** 파일 주소 **/
	private String fileUrl;
		
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOriName() {
		return fileOriName;
	}
	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	@Override
	public String toString() {
		return "FileVO [fno=" + fno + ", bno=" + bno + ", fileName=" + fileName
				+ ", fileOriName=" + fileOriName + ", fileUrl=" + fileUrl + "]";
	}
}
