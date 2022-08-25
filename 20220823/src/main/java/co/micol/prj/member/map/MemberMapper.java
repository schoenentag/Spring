package co.micol.prj.member.map;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMapper {
	// 목록
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);

	// 등록
	int memberInsert(MemberVO vo);

	// 수정
	int memberUpdate(MemberVO vo);

	// 삭제
	int memberDelete(MemberVO vo);
}
