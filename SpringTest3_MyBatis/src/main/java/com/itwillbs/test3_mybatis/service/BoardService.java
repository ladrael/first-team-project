package com.itwillbs.test3_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.test3_mybatis.mapper.MyBatisMapper;
import com.itwillbs.test3_mybatis.vo.BoardVO;

// 스프링의 서비스 클래스 역할 수행을 위한 클래스 정의 시 @Service 어노테이션을 지정
//

@Service
public class BoardService {
	
	@Autowired
	private MyBatisMapper mapper;
	
	public int registBoard(BoardVO board) {
		return mapper.insertBoard2(board); 
	}
//	public int registBoard(BoardVO board) {
//		System.out.println("BoardService - registBoard()");
//		
//		int board_num = mapper.selectMaxBoardNum(board);
//		System.out.println(board_num);
//		board.setBoard_num(board_num);
//		
//		return mapper.insertBoard(board); 
//		
//	}

	public List<BoardVO> getBoardList() {
		
		return mapper.selectBoardList();
	}
	
//	public int registBoard(BoardVO board) {
//		int insertCount = 0;
//		System.out.println("BoardService - registBoard()");
//		return insertCount;
//		

//	}


}
