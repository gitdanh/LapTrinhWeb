package vn.book.Controller.Vendor;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import vn.book.Entity.Book;
import vn.book.Entity.Category;
import vn.book.Model.BookModel;
import vn.book.Service.IBookService;

@Controller
@RequestMapping("vendor/product")
public class ProductController {
	@Autowired
	IBookService bookSer;
	@Autowired 
	Cloudinary cloudinary;
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Book> books = bookSer.findAll();
		model.addAttribute("books", books);
		return "vendor/listBook";
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("book") BookModel book,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("vendor/addOrEdit");
		}
		String message = "";
		Book bookEntity = new Book();
		
		BeanUtils.copyProperties(book, bookEntity);
		Category cateEntity = new Category();
		cateEntity.setCategoryId(book.getCategoryId());
		bookEntity.setCategory(cateEntity);
		
		if(!book.getImageFile().isEmpty()) {
			try {
				Map r = this.cloudinary.uploader().upload(book.getImageFile().getBytes(),
						ObjectUtils.asMap("resource_type", "auto"));
				String img = (String) r.get("secure_url");
				bookEntity.setImage(img);
			} catch (Exception e) {
				e.printStackTrace();
				message = "Error: Cannot upload file";
				model.addAttribute("message", message);
				return new ModelAndView("forward:/vendor/product", model);
			}
			
		}
		bookSer.save(bookEntity);
		
		
		if(book.getIsEdit()==true) {
			message = "Cập nhật thành công";
		}else {
			message = "Thêm thành công";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forward:/vendor/product", model);
	}
}
