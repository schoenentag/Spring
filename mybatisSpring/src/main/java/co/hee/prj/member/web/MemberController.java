package co.hee.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.hee.prj.member.service.MemberService;
import co.hee.prj.member.vo.MemberVO;

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
    	return "member/memberSelect";
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
}
