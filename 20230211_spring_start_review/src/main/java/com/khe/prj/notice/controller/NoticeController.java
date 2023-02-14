package com.khe.prj.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.khe.prj.notice.service.NoticeService;
import com.khe.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService dao;
	
	@GetMapping("/noticeListAll.do")
	public String noticeListAll(Model model) {
		
		model.addAttribute("list", dao.noticeListAll());
		return "notice/noticeListAll";
	}
	@GetMapping("/noticeListOne.do")
	public String noticeListOne(NoticeVO vo, Model model) {
		//@RequestParam("noticeId") 
		dao.noticeViewCnt(vo); //조회수 증가
		model.addAttribute("list", dao.noticeListOne(vo));
		return "notice/noticeListOne";
	}
	
	@GetMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return"notice/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo) {
		dao.noticeInsert(vo);
		return "redirect:/noticeListAll.do";
	}
	
	@GetMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		dao.noticeDelete(vo);
		return "redirect:/noticeListAll.do";
	}
}
