package com.example.demo.domain;

public class BoardVO {	
	/** 게시글 번호 **/
	private int bno;
	/** 게시글 제목 **/
	private String title;
	/** 게시글 내용 **/
	private String contents;
	/** 게시글 작성자 **/
	private String author;
	/** 게시글 등록일 **/
	private String regdate;
	/** 게시글 삭제구분 **/
	private String delcheck;
	/** 게시글 조회수 **/
	private int readcnt;
	/** 게시글 페이징 시작 인덱스 **/
	private int startIndex;
	/** 게시글 페이징 페이지 당 게시글 수 **/
	private int cntPerPage;
	/** 게시글 조회 타입 **/
	private String searchType;
	/** 게시글 검색어 **/
	private String keyword;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDelcheck() {
		return delcheck;
	}
	public void setDelcheck(String delcheck) {
		this.delcheck = delcheck;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	
	public void read() {
		readcnt++ ;
	}
	public void isCookie(){
		readcnt--;
	}
	public void delete() {
		delcheck = "Y";
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contents="
				+ contents + ", author=" + author + ", regdate=" + regdate
				+ ", delcheck=" + delcheck + ", readcnt=" + readcnt
				+ ", startIndex=" + startIndex + ", cntPerPage=" + cntPerPage
				+ ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}

	
	
}
