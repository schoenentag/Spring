package co.khe.review.member.map;

import java.util.List;

import co.khe.review.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList(); //전체조회
	MemberVO memberSelect(MemberVO vo); //단건조회
	int memberInsert(MemberVO vo); //등록(mapper에서 로그인 체크)
	int memberUpdate(MemberVO vo); //수정
	int memberDelete(MemberVO vo); //삭제

}
