package com.khe.prj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khe.prj.notice.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper map;

	//전체조회
	@Override
	public List<NoticeVO> noticeListAll() {
		return map.noticeListAll();
	}

	//단건조회
	@Override
	public NoticeVO noticeListOne(NoticeVO vo) {
		return map.noticeListOne(vo);
	}

	//등록
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	//수정
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	//삭제
	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

}
