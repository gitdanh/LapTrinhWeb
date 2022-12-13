package vn.book.Controller.Web;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import vn.book.Entity.User;
import vn.book.Model.UserModel;
import vn.book.Service.IUserService;
import vn.book.Service.Impl.UserSecurityService;
import vn.book.Util.MailConstructor;
import vn.book.Util.SecurityUtility;

@Controller
@RequestMapping
public class AccountController {
	@Autowired
	IUserService userSer;
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	MailConstructor mailConstructor;
	@Autowired
	UserSecurityService userSecurityService;
	@Autowired 
	Cloudinary cloudinary;

	@RequestMapping("login")
	public String login(ModelMap model) {
		return "web/login";
	}

	@RequestMapping("register")
	public String registerForm(ModelMap model) {
		model.addAttribute("userModel", new UserModel());
		return "web/userRegister";
	}

	@PostMapping("register")
	public String registerPost(HttpServletRequest request, @Valid @ModelAttribute("userModel") UserModel user,
			ModelMap model, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "web/userRegister";
		}
		model.addAttribute("email", user.getEmail());
		model.addAttribute("username", user.getUsername());

		if (userSer.findByUsername(user.getUsername()) != null) {
			model.addAttribute("usernameExists", true);

			return "web/userRegister";
		}

		if (userSer.findByEmail(user.getEmail()) != null) {
			model.addAttribute("emailExists", true);

			return "web/userRegister";
		}
		HttpSession session = request.getSession();
		Random rand = new Random();
		int otpvalue = rand.nextInt(125560);
		String otp = Integer.toString(otpvalue);

		session.setAttribute("otp", otp);
		session.setAttribute("username", user.getUsername());
		session.setAttribute("email", user.getEmail());
		/*
		 * user.setRole("USER"); User userEntity = new User();
		 * 
		 * BeanUtils.copyProperties(user, userEntity);
		 * 
		 * String password = SecurityUtility.randomPassword();
		 * 
		 * 
		 * userEntity.setPassword(password); userSer.save(userEntity);
		 */

		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), user.getEmail(),
				otp);

		mailSender.send(email);

		model.addAttribute("emailSent", "true");
		return "web/verify";
	}

	@PostMapping("verifyRegister")
	public String verifyOTP(@ModelAttribute("otp") String otp, HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		String trueOtp = (String) session.getAttribute("otp");
		String username = (String) session.getAttribute("username");
		String email = (String) session.getAttribute("email");
		User userEntity = new User();
		userEntity.setUsername(username);
		userEntity.setEmail(email);
		userEntity.setRole("USER");
		Date date = new Date(System.currentTimeMillis());
		userEntity.setCreateAt(date);
		// user.setUsername(userEntity.getUsername());
		System.out.print(username);
		if (otp.equals(trueOtp)) {
			userSer.save(userEntity);
			UserModel user = new UserModel();
			BeanUtils.copyProperties(userEntity, user);
			model.addAttribute("user", user);
			return "web/informationRegister";
		}
		model.addAttribute("message", "Opt không đúng");
		return "web/verify";

	}

	
	 
	@PostMapping("newuserinfo")
	public String updateUserInfo(@ModelAttribute("user") UserModel user,
								@ModelAttribute("confirmPassword") String confirmPass,
				ModelMap model) throws Exception {
			User currentUser = userSer.findById(user.getUserId()).get();
			
			if(currentUser == null) {
				throw new Exception ("User not found");
			}
			
			/*check email already exists*/
			if (userSer.findByEmail(user.getEmail())!=null) {
				if(userSer.findByEmail(user.getEmail()).getUserId() != currentUser.getUserId()) {
					model.addAttribute("emailExists", true);
					return "web/informationRegister";
				}
			}
			
			/*check username already exists*/
			if (userSer.findByUsername(user.getUsername())!=null) {
				if(userSer.findByUsername(user.getUsername()).getUserId() != currentUser.getUserId()) {
					model.addAttribute("usernameExists", true);
					return "web/informationRegister";
				}
			}
			
//			update password
			if (user.getPassword() != null && !user.getPassword().isEmpty() && !user.getPassword().equals("")){
				BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
				if(confirmPass.equals(user.getPassword())) {
					currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
				} else {
					model.addAttribute("incorrectConfirmPassword", true);
					return "web/informationRegister";
				}
			}
			
			BeanUtils.copyProperties(user, currentUser);
			
			if(!user.getAvatarFile().isEmpty()) {
				try {
					Map r = this.cloudinary.uploader().upload(user.getAvatarFile().getBytes(),
							ObjectUtils.asMap("resource_type", "auto"));
					String img = (String) r.get("secure_url");
					currentUser.setAvatar(img);
				} catch (Exception e) {
					e.printStackTrace();
					String message = "Error: Cannot upload file";
					model.addAttribute("message", message);
					return "web/informationRegister";
				}
				
			}
			
			userSer.save(currentUser);
			
			UserDetails userDetails = userSecurityService.loadUserByUsername(currentUser.getUsername());

			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
					userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "web/registerSuccess";
		}
}
