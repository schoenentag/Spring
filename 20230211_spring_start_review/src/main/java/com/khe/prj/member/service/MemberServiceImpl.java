package com.khe.prj.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khe.prj.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper map;
	
	//전체조회
	@Override
	public List<MemberVO> memberListAll() {
		return map.memberListAll();
	}
	
    //단건조회
	@Override
	public MemberVO memberListOne(MemberVO vo) {
		return map.memberListOne(vo);
	}
	
	//회원가입
	@Override
	public int signUp(MemberVO vo) {
		return map.signUp(vo);
	}
	
	//회원수정
	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	//회원권한수정
	@Override
	public int memberAuthUpdate(MemberVO vo) {
		return map.memberAuthUpdate(vo);
	}
	
	//회원검색
	@Override
	public List<MemberVO> ajaxMemberSearch(MemberVO vo) {
		return map.ajaxMemberSearch(vo);
	}

}
