package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.CommentVO;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/reg", method=RequestMethod.GET)
	public @ResponseBody List<CommentVO> addComment(ModelMap model, @ModelAttribute CommentVO commentVO) throws Exception{
		System.out.println("reg");
		commentService.add(commentVO);
		
		List<CommentVO> test = commentService.getAll();
		for(CommentVO c: test )
			System.out.println(c.toString());
		
		return test;
	}
	@RequestMapping(value= "/edit", method=RequestMethod.POST)
	public @ResponseBody List<CommentVO> editComment(ModelMap model, @ModelAttribute CommentVO commentVO) throws Exception{
		System.out.println("edit");
		commentVO = commentService.getByCidx(commentVO.getC_idx(), commentVO.getContents());
		commentService.edit(commentVO);
		
		List<CommentVO> test = commentService.getAll();
		for(CommentVO c: test )
			System.out.println(c.toString());
		
		return test;
	}
	
	@RequestMapping(value= "/del", method=RequestMethod.POST)
	public @ResponseBody List<CommentVO> delComment(ModelMap model, @RequestParam("c_idx") int c_idx) throws Exception{
		System.out.println("del");
		System.out.println(c_idx);
		commentService.deleteComment(c_idx);
		
		List<CommentVO> test = commentService.getAll();
		for(CommentVO c: test )
			System.out.println(c.toString());
		
		return test;
	}
}
