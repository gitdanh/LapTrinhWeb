package vn.book.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.book.Entity.Book;
import vn.book.Entity.Store;
import vn.book.Entity.User;
import vn.book.Service.IBookService;
import vn.book.Service.IStoreService;
import vn.book.Service.IUserService;

@Controller
@RequestMapping("user")
public class RouteUserController {
	IBookService bookService;
	IStoreService storeService;
	@Autowired
	IUserService userService;
	@RequestMapping("")
	public String homePage() {
		return "user/index";
	}
	@Autowired
	public void setBookService(IBookService bookService){
        this.bookService=bookService;
    }
	@Autowired
	public void setStoreService(IStoreService storeService){
        this.storeService=storeService;
    }
	@GetMapping( "list")
	public String search(ModelMap model, @RequestParam(name="name",required = false) String name)
	{
		List<Book> list = null;
		if(StringUtils.hasText(name))
		{
			list = bookService.findBybookNameContaining(name);
		} else {
			list= bookService.findAll();
		}
		model.addAttribute("books",list);
		return "user/bookList";
	}
	@GetMapping("listShop")
	public String searchShop(ModelMap model, @RequestParam(name="name",required = false) String name)
	{
		List<Store> list = null;
		if(StringUtils.hasText(name))
		{
			list = storeService.findBystoreNameContaining(name);
		} else {
			list= storeService.findAll();
		}
		model.addAttribute("stores",list);
		return "user/storeList";
	}
	
	//@PutMapping("updateInfo")
//	public User updateInfo(User user)
//	{
//		userService.updateUser(null);
//	}
	
}
