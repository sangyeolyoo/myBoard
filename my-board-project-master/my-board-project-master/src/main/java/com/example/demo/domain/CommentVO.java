package com.example.demo.domain;

public class CommentVO {
	private int c_idx;
	private int b_idx;
	private String author;
	private String contents;
	
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
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
	@Override
	public String toString() {
		return "CommentVO [c_idx=" + c_idx + ", b_idx=" + b_idx + ", author="
				+ author + ", contents=" + contents + "]";
	}
	
}
