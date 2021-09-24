package com.chu.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.chu.model.BoardVO;

@Mapper
public interface BoardMapper {
	
	//작가등록
	public void enroll(BoardVO board);
	
}
