package co.khe.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String main(Locale locale, Model model) {
		return "user/home/home";
	}
	
	@RequestMapping("/main.do")
	public String main() {
		return"main/main";
	}
	@GetMapping("/userHome.do")
	public String user() {
		return "user/home/home";
	}
	@GetMapping("/about.do")
	public String about() {
		return "user/home/about";
	}
	@GetMapping("/courses.do")
	public String courses() {
		return "user/home/courses";
	}
	@GetMapping("/contact.do")
	public String contact() {
		return "user/home/contact";
	}
}
