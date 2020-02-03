package au.com.mqas.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import au.com.mqas.logic.business.UserInfoBusiness;
import au.com.mqas.transfer.data.dto.LoginUserDto;
import au.com.mqas.transfer.data.dto.UserDto;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserInfoBusiness userInfoBusiness;

    @GetMapping({ "", "index", "home" })
    public String home(Model model) {
	return "index";
    }

    @GetMapping("/loginCustom")
    public String loginPage() {
	return "loginPage";
    }

    @GetMapping("/register")
    public String registrationPage(@ModelAttribute("loginUser") LoginUserDto loginUser) {
	return "signup";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("loginUser") @Valid LoginUserDto loginUser, BindingResult result, RedirectAttributes redirect) {

	if(result.hasErrors()) {
	    return "signup";
	}
	
	/* UserDto userDto = */userInfoBusiness.registerUser(loginUser);

	redirect.addFlashAttribute("globalMessage",
		"User Registered. An email will be send to your email account. Please check the instruction for furture shits");
	return "redirect:/register";
    }

    public UserInfoBusiness getUserInfoBusiness() {
	return userInfoBusiness;
    }

    @Autowired
    public void setUserInfoBusiness(UserInfoBusiness userInfoBusiness) {
	this.userInfoBusiness = userInfoBusiness;
    }

}
