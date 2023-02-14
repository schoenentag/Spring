package com.khe.prj.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	
	//CRUD
	List<NoticeVO> noticeListAll(); // 전체공지
	NoticeVO noticeListOne(NoticeVO vo); //단건조회
	
	int noticeInsert(NoticeVO vo); // 글등록
	int noticeUpdate(NoticeVO vo); // 글수정
	int noticeDelete(NoticeVO vo); // 글삭제
	
	int noticeViewCnt(NoticeVO vo); //조회수
	
	List<NoticeVO> ajaxNoticeSearch(Map<String,String> searchMap); //검색
	
}
