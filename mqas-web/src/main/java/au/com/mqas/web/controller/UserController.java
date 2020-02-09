package au.com.mqas.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import au.com.mqas.logic.business.UserInfoBusiness;
import au.com.mqas.transfer.data.dto.UserDto;
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

    @GetMapping("/view/{uid}")
    public String view(@PathVariable Long uid, Model model) {

	UserDto userDto = userInfoBusiness.findUserById(uid);

	model.addAttribute("user", userDto);

	return "/user/detail";
    }

    @GetMapping("/modify/{uid}")
    public String presentUpdatePage(@PathVariable Long uid, Model model) {

	UserDto userDto = userInfoBusiness.findUserById(uid);
	
	model.addAttribute("user", userDto);

	return "user/form";
    }

    @PostMapping("/save")
    public ModelAndView updateUser(@Valid @ModelAttribute("user") UserDto user, BindingResult result,
	    RedirectAttributes redirect) {

	if (result.hasErrors()) {
	    return new ModelAndView("user/form", "formErrors", result.getAllErrors());
	}

	UserDto userDto = userInfoBusiness.saveUser(user);

	Long userId = user.getId() == null ? userDto.getId() : user.getId();

	redirect.addFlashAttribute("globalMessage", "All Good");

	return new ModelAndView("redirect:/user/view/{user.id}", "user.id", userId);
    }

    @GetMapping("/confirmRegistration")
    public String confirmRegistration(@RequestParam String token, RedirectAttributes redirect) {

	UserDto userDto = null;
	try {
	    userDto = userInfoBusiness.verifyRegistrationToken(token);
	} catch (Exception e) {
	    redirect.addFlashAttribute("errorMessage", "Token is not valid, please try again");
	    return "redirect:/loginCustom";
	}

	userInfoBusiness.enableUser(userDto);

	redirect.addFlashAttribute("message", "User is verified successfully, Please login and update your profile");
	return "redirect:/loginCustom";
    }

    @GetMapping("/create")
    public String presentCreatePage(@ModelAttribute("user") UserDto user) {
	return "/user/form";
    }

    public UserInfoBusiness getUserInfoBusiness() {
	return userInfoBusiness;
    }

    @Autowired
    public void setUserInfoBusiness(UserInfoBusiness userInfoBusiness) {
	this.userInfoBusiness = userInfoBusiness;
    }

}
