package com.chu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chu.mapper.BoardMapper;
import com.chu.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void enroll(BoardVO board) {
		boardMapper.enroll(board);
	}

}
