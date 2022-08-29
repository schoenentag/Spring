package co.khe.prj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		return "home/home";
	}
	@RequestMapping("/home.do")
	public String home() {
		return "home/home";
	}

	/*
	 * @GetMapping("/admin.do") public String admin() { return "admin/admin"; }
	 */
	@GetMapping("/charts.do")
	public String charts() {
		return "home/chart";
	}
	/*
	 * // "/"로 설정하면 index페이지 호출
	 * 
	 * @GetMapping("/") public String Login() { return "memberLoginForm"; }
	 */
	
}
