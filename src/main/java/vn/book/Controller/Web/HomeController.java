package vn.book.Controller.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		return "redirect:/home";
	}
	
	@GetMapping("home")
	public String index() {
		return "web/index";
	}
	
	
}
