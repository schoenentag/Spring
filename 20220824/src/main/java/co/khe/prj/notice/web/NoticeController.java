package co.khe.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.khe.prj.notice.service.NoticeService;
import co.khe.prj.notice.vo.NoticeVO;
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("/noticeListALL.do")
	public String noticeListALL(Model model) {
		model.addAttribute("notices", service.noticeListALL());
		return "notice/noticeList";
	}
	// ModelAndView에 담기
	/*
	 * public ModelAndView noticeListALL(ModelAndView mv) {
	 * mv.addObject("notice", service.noticeListALL()); //결과를 담고
	 * mv.setViewName("notice/noticeList"); return mv; } //view 선택
	 */
	
	@RequestMapping("/noticeSelectList.do")
	 public String noticeSelectList(NoticeVO vo, Model model) {
	 model.addAttribute("notices", service.noticeSelectList(vo));
	 return "notice/noticeList"; // dispatcherServlet -> view Resolve -> 해당 view를 보여줌
	 }
	 
	//POST로 전달받음
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile mFile) {
		service.noticeInsert(vo); //글 등록
		//아직 file 부분 처리안됨(file업로드를 위해서는 라이브러리 설치 필요)
		//등록이 되면 글 목록으로 돌아감
		System.out.println(vo.getNotice_writer());
		return "redirect:noticeListALL.do"; // dispatcherServlet -> redirect: keyword -> to move Handler Mapper -> controller 
	}
	
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo, Model model) {
		int n = service.noticeUpdate(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 수정되었습니다");
		}else {
			model.addAttribute("message", "수정이 되지 않았습니다.");			
		}
		return "notice/noticeUpdate";
	}
	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo, Model model) {
		int n = service.noticeDelete(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 삭제되었습니다");
		}else {
			model.addAttribute("message", "삭제가 되지 않았습니다.");			
		}
		return "notice/noticeDelete";
	}
	@RequestMapping("noticeForm.do")
	public String noticeForm() {
		return "notice/noticeForm";
	}

}
