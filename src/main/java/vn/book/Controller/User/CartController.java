package vn.book.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.book.Service.ICartService;
import vn.book.Service.IUserService;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	ICartService cartSer;
	@Autowired
	IUserService userSer;
	@GetMapping("/list")
	public String list() {
		return "user/cart";
	}
	@GetMapping("/add")
	public String add() {
		return "";
	}
	@GetMapping("/remove")
	public String remove() {
		return "user/cart";
	}
}
