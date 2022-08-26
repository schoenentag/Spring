package co.hee.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.hee.prj.notice.service.NoticeService;
import co.hee.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	@Autowired
	private ServletContext servletContext; // context path(webapp)를 찾음
	
	// 이름은 동일하게 하기를 권장
	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("n", ns.noticeSelect(vo));
		ns.noticeHitUpdate(vo); //조회수 증가
		return "notice/noticeSelect";
	}
	
	// 하나의 정보 보여줌
	@GetMapping("/noticeSelectList.do")
	public String noticeSelectList(NoticeVO vo, Model model) {
		model.addAttribute("notices", ns.noticeSelectList());
		return "notice/noticeSelectList";
	}
	
	// 등록
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		// 파일 업로드 처리
		String saveFolder = servletContext.getRealPath("/fileUpload"); // 파일 저장할 폴더 변수명
		File sfile = new File(saveFolder); // 물리적 저장 위치
		String ofileName = file.getOriginalFilename(); // 넘어온 파일명
		if(!ofileName.isEmpty()) {
			String sfileName = UUID.randomUUID().toString() + ofileName.substring(ofileName.lastIndexOf(".")); // 파일명 충돌방치를 위한 변경 파일명
			file.transferTo(new File(sfile, sfileName)); // 파일 전송, 물리적 위치에 저장
			vo.setNoticeAttach(ofileName);
			vo.setNoticeAttachDir(saveFolder + File.separator + sfileName); // ex) fileUpload/111.txt
			// File.separator(파일의 경로를 분리해주는 메소드) == //
		}
		ns.noticeInsert(vo);
		return "redirect:noticeSelectList.do";
	}
	
	// 수정
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo) {
//		vo.setNoticeWriter("관리자");
//		vo.setNoticeId(2);
		ns.noticeUpdate(vo);
		return "redirect:noticeSelectList.do";
	}
	
	// 검색
	@RequestMapping("/noticeSearch.do")
	// @RequestParam("key") String key, @RequestParam("val") String val 추가해야함
	public String noticeSearch(NoticeVO vo, String key, String val, Model model) { 
//		key = "1"; // title
//		val = "스프링"; // 제목에 스프링이 있는 데이터 찾음
//		key = "3"; // writer
//		val = "박승리"; // 작성자 이름이 박승리인 데이터 찾음
		model.addAttribute("notices", ns.noticeSearch(key, val));
		return "notice/noticeSearch";
	}
	
	// 등록 폼 호출
	@GetMapping("/noticeForm.do")
	public String noticeInsertForm() {
		
		return "notice/noticeForm";
	}
	
	// ajax test 페이지 호출
	// produces = "application/text; charset=UTF-8" => 한글 깨짐 처리
	@RequestMapping(value = "/ajaxNoticeSelect.do", produces = "application/text; charset=UTF-8")
	@ResponseBody // 호출한 페이지로 결과를 돌려보냄
	public String ajaxNoticeSelect(HttpServletResponse response) {
		String message = "ajax 테스트";
		return message; // 콘솔에 출력될 내용
	}
	
	@GetMapping("/ajaxTest.do")
	public String ajaxTest() {
		return "notice/ajaxTest";
	}
}
