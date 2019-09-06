package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.repository.BoardMapper;

@Service("boardService")
@Transactional
public class BoardService {

	@Autowired
	BoardMapper boardMapper;

	// Spring 최신 버전에서는 autowired 를 이용한 di 보다는 생성자를 이용한 di 를 추천하고는 있음

	public List<BoardVO> getAll(BoardVO boardVO) throws Exception {
		return boardMapper.getAll(boardVO);
	}

	public List<BoardVO> getBoard(Map<String, Object> searchData) throws Exception {
		return boardMapper.getBoard(searchData);
	}
	
	public BoardVO getBoard(int bno) throws Exception {
		BoardVO boardToRead = boardMapper.getByIdx(bno);
		String contents = boardToRead.getContents();
		
		contents.replaceAll("\n", "<br>");
		boardToRead.setContents(contents);
		return boardToRead;
	}
	
	public void add(BoardVO boardVO) throws Exception {
		boardMapper.add(boardVO);
	}

	public void edit(BoardVO newBoard) throws Exception {
		BoardVO editBoard = boardMapper.getByIdx(newBoard.getBno());
		editBoard.setTitle(newBoard.getTitle());
		editBoard.setContents(newBoard.getContents());
		
		boardMapper.edit(editBoard);
	}

	public BoardVO read(int bno) throws Exception {
		BoardVO boardToCount = getBoard(bno);
		
		boardToCount.read();
		
		try {
			boardMapper.edit(boardToCount);
		}catch(Exception e){
			return boardToCount;
		}
		
		return boardToCount;
	}

	public void delByCheck(List<Integer> idxArr) throws Exception {
		int i = 0;
		for (int idx : idxArr) {
			BoardVO board = boardMapper.getByIdx(idx);
			
			board.delete();
			boardMapper.edit(board);
			if(i > 2) throw new RuntimeException();

			i++;
		}
	}

	public int getBoardListCnt() throws Exception {
		int boardListCnt = 0;
		boardListCnt = boardMapper.getCurBoardCnt();
		return boardListCnt;
	}
	
	public int getBoardListCnt(BoardVO boardVO) throws Exception {
		int boardListCnt = 0;
		boardListCnt = boardMapper.getCurBoardCnt(boardVO);
		return boardListCnt;
	}
	
	public int fileAdd(FileVO file) throws Exception {
		return boardMapper.fileAdd(file);
	}
	
	public FileVO fileDetail(int bno) throws Exception {
		return boardMapper.fileDetail(bno);
	}
	

}
