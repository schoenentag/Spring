package co.khe.review.notice.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.khe.review.notice.service.NoticeService;
import co.khe.review.notice.vo.NoticeVO;

@RestController
public class NoticeAjaxController {
	@Autowired
	private NoticeService ajaxDao;
	
	   //ist<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val);//검색
		@RequestMapping("/ajaxNoticeSearch.do")
		public List<NoticeVO> noticeSearch(@Param("key")String key, @Param("val")String val) {
			return ajaxDao.noticeSearch(key, val);
		}


}
