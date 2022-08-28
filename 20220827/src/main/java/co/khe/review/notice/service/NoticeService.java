package co.khe.review.notice.service;

import java.util.List;
import java.util.Map;

import co.khe.review.notice.vo.NoticeVO;

public interface NoticeService {
	List<Map<String, Object>> noticeSelectList(); // 전체 조회
	NoticeVO noticeSelect(NoticeVO vo);//상세조회
	
	int noticeInsert(NoticeVO vo);//등록
	int noticeUpdate(NoticeVO vo);//수정
	int noticeDelete(NoticeVO vo);//삭제
	
	int noticeHitUpdate(NoticeVO vo);//조회수 증가
	
	List<NoticeVO> noticeSearch(String key, String val);//검색
}
