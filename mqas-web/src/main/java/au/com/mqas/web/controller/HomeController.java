package au.com.mqas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({ "", "index", "home" })
    public String home(Model model) {
//	model.addAttribute("users", )
	return "index";
    }

    @GetMapping("loginCustom")
    public String loginPage() {
	return "loginPage";
    }

}
