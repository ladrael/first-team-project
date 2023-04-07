package com.itwillbs.test3_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.test3_mybatis.vo.BoardVO;
import com.itwillbs.test3_mybatis.vo.MemberBean;
import com.itwillbs.test3_mybatis.vo.MemberVO;

public interface MyBatisMapper {
	int insertBoard(BoardVO board);

	int selectMaxBoardNum(BoardVO board);
	// ---------------------------------------------------------------------------
	
	int insertBoard2(BoardVO board);

	MemberVO selectUser(@Param("id") String id, @Param("passwd") String passwd);

	int insertMember(MemberBean member);
	
	List<BoardVO> selectBoardList();
}
