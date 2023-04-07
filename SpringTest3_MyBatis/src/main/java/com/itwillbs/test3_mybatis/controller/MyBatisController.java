package com.itwillbs.test3_mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.test3_mybatis.service.BoardService;
import com.itwillbs.test3_mybatis.service.MemberService;
import com.itwillbs.test3_mybatis.vo.BoardVO;
import com.itwillbs.test3_mybatis.vo.MemberBean;
import com.itwillbs.test3_mybatis.vo.MemberVO;

@Controller
public class MyBatisController {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);
	
	/*
	
	
	*/
	@Autowired
	private BoardService BoardService;

	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/main")
	public String main() {
		
		return "main";
	}
	
	@GetMapping(value ="/login.me")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping(value="/loginPro.me")
	public String loginPro(@RequestParam String id, @RequestParam String passwd,
			HttpSession session, Model model) {
		
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		MemberVO member = memberService.checkUser(id, passwd);
		if(member == null) {
			System.out.println("로그인 실패!");
			// 디스패치 모델객체
			model.addAttribute("msg","로그인 실패!");
			return "fail_back";
		} else {
			System.out.println("로그인 성공!");
			
			
			session.setAttribute("sId", id);
			return"redirect:/main";
		// 리다이렉트 방식이고 서블릿으로 이동하므로 서블릿 주소를 제시
		}
	}
	// ################################################################################################################################
	@GetMapping(value ="/logout.me")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/main";
	}
	
	
	
	
	
	
	
	
	@GetMapping(value ="/join.me")
	public String joinForm() {
		return "join_form";
	}
	// 가입정보를 전달받을때 eamil이 없으니까 requestparam email1 , email2 을 넣거나
	// 이렇게하면 email1, email2를 하나의 문자열로 결합해서 member에 넣는다
	// VO 클래스 선에서 처리하는 방법이 있다.
	@PostMapping(value="/joinPro.me")
	public String joinPro(MemberBean member,@RequestParam String email1,@RequestParam String email2, Model model) {
		member.setEmail(email1 + "@" + email2);
		// 입력방지용으로 폼에서 req 걸어주면 null이 안넘어옴
		
		int insertCount  = memberService.registMember(member);
		
		
		if(insertCount > 0) {
			return "redirect:/main";
		}else {
			
			model.addAttribute("msg","회원가입 실패");
			
			return "fail_back";
		}
		
		
	}
	
	// ################################################################################################################################
	@PostMapping(value = "/writePro.bo")
	public String writePro(BoardVO board) {
		
//		BoardService service = new BoardService();
		int insertCount = BoardService.registBoard(board);
		
		return "redirect:/list.bo";
	}
	
	
	@GetMapping(value ="/list.bo")
	public String list(Model model) {
		List<BoardVO> boardList  = BoardService.getBoardList();
		
		model.addAttribute("boardList",boardList);
		
		
		
		return "list";
	}
	
	
	
	
	// ################################################################################################################################
	@GetMapping(value ="/write.bo")
	public String writeForm() {
		return "writeForm";
	}
	
}
