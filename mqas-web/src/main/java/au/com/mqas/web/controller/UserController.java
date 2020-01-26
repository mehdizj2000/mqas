package au.com.mqas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.mqas.business.UserInfoBusiness;
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

	return "/user/update";
    }

    @PostMapping("/modify/{uid}")
    public String updateUser(@PathVariable Long uid, UserDto user, Model model) {

	UserDto userDto = userInfoBusiness.updateUser(uid, user);

	model.addAttribute("user", userDto);

	return "/user/update";
    }

    @GetMapping("/create")
    public String presentCreatePage(Model model) {

	model.addAttribute("user", new UserDto());

	return "/user/create";
    }

    @PostMapping("/create")
    public String createNewUser(UserDto user, Model model) {

	UserDto userDto = userInfoBusiness.updateUser(null, user);

	model.addAttribute("user", userDto);

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
