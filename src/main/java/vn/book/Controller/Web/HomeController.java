package vn.book.Controller.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.book.Entity.Book;
import vn.book.Entity.Store;
import vn.book.Service.IBookService;
import vn.book.Service.IStoreService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping("home")
public class HomeController {
	IBookService bookService;
	IStoreService storeService;
	@RequestMapping("")
	public String homePage() {
		return "web/index";
	}
	
//	@GetMapping("index")
//	public String index() {
//		return "web/index";
//	}
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
		return "web/bookList";
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
		return "web/storeList";
	}
	@GetMapping("listByPage")
	public String searchByPage(ModelMap model, @RequestParam(name="name",required = false)   String name, 
			@RequestParam("page") Optional<Integer> page,@RequestParam("size")Optional<Integer> size)
	{
		int count = (int) bookService.count();
		int cur = page.orElse(1);
		int pageSize = size.orElse(3);
		Pageable pageable = PageRequest.of(cur-1, pageSize,Sort.by("bookName"));
		Page<Book> res=null;
		if(StringUtils.hasText(name)) {
			res=bookService.findBybookNameContaining(name, pageable);
			model.addAttribute("name",name);
			
		}else
		{
			res=bookService.findAll(pageable);
		}
		int sumP= res.getTotalPages();
		if(sumP>0) {
			int start = Math.max(1, cur-2);
			int end = Math.min(cur+2, sumP);
			if(sumP>count) {
				if(end == sumP) {start=end-count;}
				else if (start==1) {end=start+count;}
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers",pageNumbers);
		}
		model.addAttribute("bookPage",res);
		return "web/bookList";
	}
	@GetMapping("storeListByPage")
	public String searchStoreByPage(ModelMap model, @RequestParam(name="name",required = false)   String name, 
			@RequestParam("page") Optional<Integer> page,@RequestParam("size")Optional<Integer> size)
	{
		int count = (int) storeService.count();
		int cur = page.orElse(1);
		int pageSize = size.orElse(3);
		Pageable pageable = PageRequest.of(cur-1, pageSize,Sort.by("storeName"));
		Page<Store> res=null;
		if(StringUtils.hasText(name)) {
			res=storeService.findBystoreNameContaining(name, pageable);
			model.addAttribute("name",name);
			
		}else
		{
			res=storeService.findAll(pageable);
		}
		int sumP= res.getTotalPages();
		if(sumP>0) {
			int start = Math.max(1, cur-2);
			int end = Math.min(cur+2, sumP);
			if(sumP>count) {
				if(end == sumP) {start=end-count;}
				else if (start==1) {end=start+count;}
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers",pageNumbers);
		}
		model.addAttribute("storePage",res);
		return "web/storeList";
	}
}
