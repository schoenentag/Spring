package co.khe.review.notice.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import co.khe.review.notice.vo.NoticeVO;

public interface NoticeMapper {
	@Select("select * from notice order by notice_id desc") //권장하지 않는 방식
	List<Map<String, Object>> noticeSelectList(); // 전체 조회
	NoticeVO noticeSelect(NoticeVO vo);//상세조회
	
	int noticeInsert(NoticeVO vo);//등록
	int noticeUpdate(NoticeVO vo);//수정
	int noticeDelete(NoticeVO vo);//삭제
	
	int noticeHitUpdate(NoticeVO vo);//조회수 증가
	
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val);//검색

}
