package co.khe.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.khe.prj.member.service.MemberService;
import co.khe.prj.member.vo.MemberVO;

@Controller
public class MemberController {
    @Autowired
    private MemberService service; //dao를 통해 Repository에서 결과를 가져온다
    
    @RequestMapping("/memberList.do")
    public String memberList(Model model) {
    	// ★★★
    	// spring interface인 Model 객체를 활용하여 bean에서 만들어진 결과물을 view를 전달하는 역할을 한다
    	// service 객체를 호출해서 값을 가져오게 처리
    	// 처리된 결과를 model 속성인 members의 변수에 담는다. key, value 형태로 담김
    	// members의 변수는 jsp에서 사용됨
    	model.addAttribute("members", service.memberSelectList()); 
    	return "member/memberList";
    }
    @RequestMapping("/memberSelect.do")
    public String memberSelect(MemberVO vo , Model model) {
    	//결과물 출력하기 위해 Model 객체를 받음
    	model.addAttribute("member", service.memberSelect(vo));
    	return "member/memberList";
    }
    
    @RequestMapping("/memberInsert.do")
    public String memberInsert(MemberVO vo, Model model) {
    	int n = service.memberInsert(vo);
    	if(n != 0) {
    		model.addAttribute("message", "정상적으로 추가되었습니다.");
    	} else {
    		model.addAttribute("message", "멤버 추가가 실패했습니다.");
    	}
    	//추가 처리
    	return "member/memberInsert";
    }
    @RequestMapping("/memberUpdate.do")
    public String memberUpdate(MemberVO vo, Model model) {
    	int n = service.memberUpdate(vo);
    	if(n != 0) {
    		model.addAttribute("message", "정상적으로 업데이트되었습니다.");
    	} else {
    		model.addAttribute("message", "멤버 업데이트가 실패했습니다.");
    	}
    	//추가 처리
    	return "member/memberUpdate";
    }
    @RequestMapping("/memberDelete.do")
    public String memberDelete(MemberVO vo, Model model) {
    	int n = service.memberDelete(vo);
    	if(n != 0) {
    		model.addAttribute("message", "정상적으로 삭제되었습니다.");
    	} else {
    		model.addAttribute("message", "멤버 삭제가 실패했습니다.");
    	}
    	//추가 처리
    	return "member/memberDelete";
    }
    
	
	  @PostMapping("/memberLogin.do") public String memberLogin(MemberVO vo,
	  HttpSession session, Model model) { vo = service.memberSelect(vo); String
	  viewPage ="member/memberMessage"; // 로그인 실패시 이동할 페이지
	  
	  if (vo == null) { model.addAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
	  }else { session.setAttribute("id", vo.getMemberId());
	  session.setAttribute("password", vo.getMemberPassword());
	  session.setAttribute("author", vo.getMemberAuthor());
	  model.addAttribute("message", vo.getMemberName() +"님 환영합니다."); viewPage
	  ="home/home"; //redirect:home.do 
	  } return viewPage; }

    
    //ModelAndView 객체 (return값이 mv)- 사용을 권장하지 않음
    /*@PostMapping("memberLogin.do")
    public ModelAndView memberLogin(MemberVO vo, HttpSession session, ModelAndView mv) {
    	vo = service.memberSelect(vo);
    	if(vo == null) {
    		mv.setViewName("member/memberMessage"); // 실패했을때 보여줄 페이지 정의
    		mv.addObject("message", "아이디 또는 패스워드가 일치하지 않습니다."); // 넘겨줄 데이터
    	} else {
    		session.setAttribute("id", vo.getMemberId());
    		session.setAttribute("password", vo.getMemberPassword());
    		session.setAttribute("name", vo.getMemberName());
    		session.setAttribute("author", vo.getMemberAuthor());
    		mv.setViewName("home/home");
    	}
    	return mv;
    }*/
    @RequestMapping("/memberLoginForm.do")
    public String memberLoginForm() {
    	return "memberLoginForm";
    }
} 
