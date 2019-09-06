package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.CommentVO;
import com.example.demo.repository.CommentMapper;

@Service("commentService")
@Transactional
public class CommentService {
	@Autowired
	CommentMapper commentMapper;

	public List<CommentVO> getAll() throws Exception{
		return commentMapper.getAll();
	}
	
	public List<CommentVO> getComment(int idx) throws Exception{
		return commentMapper.getComment(idx);
	}

	public void add(CommentVO commentVO) throws Exception{
		commentMapper.addComment(commentVO);	
	}
	
	public int edit(CommentVO commentVO) throws Exception {
		return commentMapper.editComment(commentVO);
	}
	
	public void deleteComment(int c_idx) throws Exception {
		commentMapper.deleteComment(c_idx);
	}
	public CommentVO getByCidx(int c_idx, String contents) throws Exception{
		CommentVO commentVO = new CommentVO();
		commentVO = commentMapper.getByCidx(c_idx);
		System.out.println("se:"+commentVO.toString());
		commentVO.setC_idx(c_idx);
		commentVO.setContents(contents);
		return commentVO; 
	}

}
