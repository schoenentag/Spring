package com.khe.prj.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		System.out.println("글번호 : "+ vo.getNoticeId());
		
		model.addAttribute("list", dao.noticeListOne(vo));
		System.out.println(dao.noticeListOne(vo));
		return "notice/noticeListOne";
	}

}
