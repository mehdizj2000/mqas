package au.com.mqas.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import au.com.mqas.logic.business.UserInfoBusiness;
import au.com.mqas.transfer.data.dto.ForgotPassDto;
import au.com.mqas.transfer.data.dto.LoginUserDto;

@Controller
@RequestMapping("/")
public class HomeController {

	private PasswordEncoder passwordEncoder;

	private UserInfoBusiness userInfoBusiness;

	@GetMapping({ "", "index", "home" })
	public String home(Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "loginPage";
	}

	@GetMapping("/register")
	public String registrationPage(@ModelAttribute("loginUser") LoginUserDto loginUser) {
		return "signup";
	}

	@PostMapping("/register")
	public String registerNewUser(@ModelAttribute("loginUser") @Valid LoginUserDto loginUser, BindingResult result,
			RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "signup";
		}

		loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));

		/* UserDto userDto = */userInfoBusiness.registerUser(loginUser);

		redirect.addFlashAttribute("globalMessage",
				"User Registered. An email will be send to your email account. Please check the instruction for furture shits");
		return "redirect:/register";
	}

	@GetMapping("/forgotPassword")
	public String resetPassword(@ModelAttribute("forgotPass") ForgotPassDto forgotPass) {
		return "resetPasswordInfo";
	}

	@PostMapping("/forgotPassword")
	public ModelAndView prepareResetPassword(@ModelAttribute("forgotPass") @Valid ForgotPassDto forgotPass,
			BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return new ModelAndView("resetPasswordInfo", "formErrors", result.getFieldErrors());
		}

		try {
			userInfoBusiness.validateUserInfoForResetPassword(forgotPass);
		} catch (Exception e) {
			return new ModelAndView("resetPasswordInfo", "error", "email or birthday are not found. Please try again");
		}

		redirect.addFlashAttribute("globalMessage",
				"Reset Password token will be sent to your email address. Please follow the instruction for furthure shits");

		return new ModelAndView("redirect:/resetPasswordInfo");
	}

	public UserInfoBusiness getUserInfoBusiness() {
		return userInfoBusiness;
	}

	@Autowired
	public void setUserInfoBusiness(UserInfoBusiness userInfoBusiness) {
		this.userInfoBusiness = userInfoBusiness;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
