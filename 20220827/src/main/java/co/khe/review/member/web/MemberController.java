package co.khe.review.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.khe.review.member.service.MemberService;
import co.khe.review.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService dao; //dao에 있는 객체를 가져온다.
	
	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) {
		model.addAttribute("members", dao.memberSelectList());
		return "member/memberSelectList";
	}
	
	@RequestMapping("/memberSelect.do")
	public String memberSelect(MemberVO vo, Model model) {
		model.addAttribute("member", dao.memberSelect(vo));
		return "member/memberSelect";
	}
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) {
		int n = dao.memberInsert(vo);
		if(n != 0) {
			model.addAttribute("message", "회원가입이 완료되었습니다.");
		} else {
			model.addAttribute("message", "회원가입에 실패했습니다.");
		}
		return "member/memberInsert";
	}
	//memberUpdate, memberDelete는 추가로 작성해야함
	
	// Login From으로 이동
	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	//로그인 처리
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO vo, Model model, HttpSession session) {
		vo = dao.memberSelect(vo);
		if (vo == null) {
			model.addAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}else {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("password", vo.getMemberPassword());
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("message", vo.getMemberName()+"님 환영합니다.");
		}
		return "member/memberMessage";
	}
	

}
