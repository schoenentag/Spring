package com.khe.prj.notice.mapper;

import java.util.List;

import com.khe.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	
	//CRUD
		List<NoticeVO> noticeListAll(); // 전체공지
		NoticeVO noticeListOne(NoticeVO vo); //단건조회
		
		int noticeInsert(NoticeVO vo); // 글등록
		int noticeUpdate(NoticeVO vo); // 글수정
		int noticeDelete(NoticeVO vo); // 글삭제
		
		// 조회수

}
