package au.com.mqas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.mqas.logic.business.AccessKeyBusiness;
import au.com.mqas.transfer.data.dto.AccessKeyDto;

@Controller
@RequestMapping(value = "/token")
public class AccessTokenController {

	private AccessKeyBusiness accessKeyBusiness;

	@GetMapping("/list/{email}")
	@PreAuthorize("isAuthenticated() && #email == authentication.name")
	public String showAllTokens(final @PathVariable(value = "email") String email, final Model model) {

		List<AccessKeyDto> accessKeyDtos = accessKeyBusiness.listUserKeysByEmail(email);

		model.addAttribute("apiKeys", accessKeyDtos);

		return "token/list";
	}

	@GetMapping("/product/{prodid}")
	@PreAuthorize("isAuthenticated()")
	public String showAPIKeyOptions(@PathVariable("prodid") final Long prodId, final Model model) {

		model.addAttribute("accessLevel", accessKeyBusiness.getAccessLevelDtoById(prodId));

		return "token/accessKey";
	}

	@GetMapping("/product/buy/{prodid}")
	@PreAuthorize("isAuthenticated()")
	public String buyAPIKeyOptions(final Authentication authentication, @PathVariable("prodid") final Long prodId) {

		String username = authentication.getName();

		accessKeyBusiness.generateAPIKey(username, prodId);

		return "redirect:/token/list/" + username;
	}

	@GetMapping("/createRequest")
	public String showAPIKeyOptions(final Model model) {

		model.addAttribute("accessLevels", accessKeyBusiness.listAccessLevelDtos());

		return "token/accessKeyOptions";
	}

	public AccessKeyBusiness getAccessKeyBusiness() {
		return accessKeyBusiness;
	}

	@Autowired
	public void setAccessKeyBusiness(AccessKeyBusiness accessKeyBusiness) {
		this.accessKeyBusiness = accessKeyBusiness;
	}

}
