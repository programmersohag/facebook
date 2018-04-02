package com.sk.sheikhpura.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserListController {

	@RequestMapping(value="register", method=RequestMethod.GET)
	public String viewRegistration(){
		
		return "register";
	}
}
