package co.hee.prj.notice.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import co.hee.prj.notice.service.NoticeVO;

// noticeService와 동일
public interface NoticeMapper {
	@Select("select * from notice") // mapper.xml 에서 설정 안해줘도 됨(ibatis를 쓸때는 권장하지 않는 방식)
	// List Map 구조 사용할때 컬럼명 대문자로 써야함
	List<Map<String, Object>> noticeSelectList(); // 전체 목록, 조인 또는 VO 객체를 만들지 않고 사용할 때

	NoticeVO noticeSelect(NoticeVO vo); // 한건의 정보

	int noticeInsert(NoticeVO vo); // 등록

	int noticeUpdate(NoticeVO vo); // 수정

	int noticeDelete(NoticeVO vo); // 삭제

	// 전달 인자가 두개 이상이면 @Param 써줘야함 => Mapper에서 인식하기 위함
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val); // 검색
}
