package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;

@Repository
public interface BoardMapper { // board
	List<BoardVO> getAll(BoardVO boardVO) throws Exception; // .getBoard
    List<BoardVO> getBoard(Map<String, Object> searchData) throws Exception;
    void add(BoardVO boardVO) throws Exception;
    void edit(BoardVO boardVO) throws Exception;
    BoardVO getByIdx(int bno) throws Exception;
    int getCurBoardCnt() throws Exception;
    int getCurBoardCnt(BoardVO boardVO) throws Exception;
    int fileAdd(FileVO file) throws Exception;
    FileVO fileDetail(int bno) throws Exception;
}

