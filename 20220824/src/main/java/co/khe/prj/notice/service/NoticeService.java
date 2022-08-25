package co.khe.prj.notice.service;

import java.util.List;

import co.khe.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeListALL();
	NoticeVO noticeSelectList(NoticeVO vo);
	public int noticeInsert(NoticeVO vo);
	public int noticeUpdate(NoticeVO vo);
	public int noticeDelete(NoticeVO vo);

}
