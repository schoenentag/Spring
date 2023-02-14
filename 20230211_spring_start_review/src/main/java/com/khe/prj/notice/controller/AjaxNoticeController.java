package com.khe.prj.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khe.prj.notice.service.NoticeService;
import com.khe.prj.notice.service.NoticeVO;

@RestController
public class AjaxNoticeController {
	
	@Autowired
	private NoticeService dao;
	
	@GetMapping("/ajaxNoticeSearch.do")
	public List<NoticeVO> ajaxNoticeSearch(@RequestParam String inputType, @RequestParam String inputKeyword) {
		System.out.println("ajax controller 실행!");
		Map<String, String> param = new HashMap<>();
		
		param.put("inputType", inputKeyword);
		param.put("inputKeyword", inputKeyword);
		return dao.ajaxNoticeSearch(param);
	}

}
