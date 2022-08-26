package co.hee.prj.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	// List<NoticeVO> noticeSelectListVO(); // VO 객체를 이용해서 사용할 때
	
			// key, object
	List<Map<String, Object>> noticeSelectList(); // 전체 목록, 조인 또는 VO 객체를 만들지 않고 사용할 때
	
	NoticeVO noticeSelect(NoticeVO vo); // 한건의 정보
	
	int noticeInsert(NoticeVO vo); // 등록
	
	int noticeUpdate(NoticeVO vo); // 수정
	
	int noticeDelete(NoticeVO vo); // 삭제
	
	int noticeHitUpdate(NoticeVO vo); //조회수 증가
	
	List<NoticeVO> noticeSearch(String key, String val); // 검색
	
}
