package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.CommentVO;

@Repository
public interface CommentMapper {
	public int countComment() throws Exception;
	public List<CommentVO> getAll() throws Exception;
	public List<CommentVO> getComment(int idx) throws Exception;
	public CommentVO getByCidx(int c_idx) throws Exception;
	public void addComment(CommentVO comment) throws Exception;
	public int editComment(CommentVO comment) throws Exception;
	public void deleteComment(int c_idx) throws Exception;
}
