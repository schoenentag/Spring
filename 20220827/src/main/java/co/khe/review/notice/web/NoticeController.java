package co.khe.review.notice.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.khe.review.notice.service.NoticeService;
import co.khe.review.notice.vo.NoticeVO;
@Controller
public class NoticeController {
	@Autowired
	private NoticeService dao;
	
	@Autowired
	private ServletContext servletContext; //파일처리를 위한 서블릿 컨텍스트
	
	//List<Map<String, Object>> noticeSelectList(); // 전체 조회
	@RequestMapping("/noticeSelectList.do")
	public String noticeSelectList(NoticeVO vo, Model model) {
		model.addAttribute("notices", dao.noticeSelectList());
		return "notice/noticeSelectList";
	}
	
	//NoticeVO noticeSelect(NoticeVO vo);//상세조회
	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("notices", dao.noticeSelect(vo));
		dao.noticeHitUpdate(vo); //조회수 증가
		return "notice/noticeSelect";
	}
	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	//int noticeInsert(NoticeVO vo);//등록
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, Model model, @RequestParam("file") MultipartFile file) {
		
		//파일 업로드 처리
		String saveFolder= servletContext.getRealPath("/fileUpload");
		File sfile = new File(saveFolder); //물리적 저장 위치
		String ofileName = file.getOriginalFilename(); //넘어온 파일명
		if(!ofileName.isEmpty()) {
			String sfileName = UUID.randomUUID().toString()+ofileName.substring(ofileName.lastIndexOf("."));
			vo.setNoticeAttach(ofileName);
			vo.setNoticeAttachDir(saveFolder+File.separator+sfileName);
		}
		
		dao.noticeInsert(vo);
		System.out.println(vo.getNoticeWrite());
		System.out.println(vo.getNoticeDate());

		return "redirect:noticeSelectList.do";
	}
	
	//int noticeUpdate(NoticeVO vo);//수정
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo) {
	    return "";	
	}
	
	//int noticeDelete(NoticeVO vo);//삭제
	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		return "";
	}
	
 
	

}
