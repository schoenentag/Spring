package com.khe.prj.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khe.prj.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService dao; ////dao를 통해 Repository에서 결과를 가져온다
	
	// 회원 전체 목록
	@GetMapping("/memberListAll.do")
	public String memberListAll(Model model) {
		model.addAttribute("member", dao.memberListAll());
		return "member/memberListAll";
	}
	
	//로그인폼
	@GetMapping("/signInForm.do")
	public String signInForm() {
		return "member/signInForm";
	}

}
