package com.itwillbs.test3_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.test3_mybatis.mapper.MyBatisMapper;
import com.itwillbs.test3_mybatis.vo.MemberBean;
import com.itwillbs.test3_mybatis.vo.MemberVO;

@Service
public class MemberService {
	
	
	@Autowired
	private MyBatisMapper mapper;
	
	public MemberVO checkUser(String id ,String passwd) {
		System.out.println("checkUser()");
		
		
		return mapper.selectUser(id,passwd);
	}

	public int registMember(MemberBean member) {
		System.out.println("insertMember()");
		
		return mapper.insertMember(member);
	}

}
