package au.com.mqas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.mqas.business.UserInfoBusiness;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	private UserInfoBusiness userInfoBusiness;

	@GetMapping("/list")
	public String home(Model model) {
		model.addAttribute("users", userInfoBusiness.listAllUsers());
		return "/user/list";
	}

	@GetMapping("/delete/{uid}")
	public String home(@PathVariable Long uid) {
		
		log.info("User Id: {}", uid);
		
		userInfoBusiness.deleteUser(uid);
		
		return "redirect:/user/list";
	}

	@GetMapping("loginCustom")
	public String loginPage() {
		return "loginPage";
	}

	public UserInfoBusiness getUserInfoBusiness() {
		return userInfoBusiness;
	}

	@Autowired
	public void setUserInfoBusiness(UserInfoBusiness userInfoBusiness) {
		this.userInfoBusiness = userInfoBusiness;
	}

}
