package com.chu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chu.mapper.BoardMapper;
import com.chu.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시판 등록
	@Override
	public void enroll(BoardVO board) {
		boardMapper.enroll(board);
	}
	
	//게시판 목록
	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}
	
	//게시판 조회
	@Override
	public BoardVO getPage(int bno) {
		return boardMapper.getPage(bno);
	}
	
	//게시판 수정
	@Override
	public int modify(BoardVO board) {
		return boardMapper.modify(board);
	}

	@Override
	public int delete(int bno) {
		return boardMapper.delete(bno);
	}
	
}
