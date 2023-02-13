package com.khe.prj.notice.service;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {

	private int noticeId; //글번호
	private String noticeWriter; //글쓴이
	private String noticeTitle; // 제목
	private String noticeSubject; // 본문
	private Date noticeDate; //날짜
	private int noticeHit; // 조회수
	private String noticeAttach; //파일
	private String noticeAttachDir; //파일경로
	
}
