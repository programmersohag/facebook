package com.sk.sheikhpura.controller.user;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.sheikhpura.dao.UserDao;
import com.sk.sheikhpura.entity.UserInfo;

@Controller
public class UserInfoController {

	@Autowired
	private UserDao dao;

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String getAllUsers(ModelMap model) {
		model.addAttribute("list", dao.getUsers());
		return "home";

	}

	@RequestMapping(value = "/create_account", method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		model.addAttribute("userInfo", new UserInfo());
		return "register";

	}
	@RequestMapping(value = "/create_account", method = RequestMethod.POST)
	public String createUpdate(@Valid UserInfo info, BindingResult result) {
		//model.addAttribute("list", dao.getUsers());
		if(result.hasErrors()){
			return "register";
		}
		info.setActive(true);
		info.setInsDate(new Date());
		info.setUserName("Sohag");
		dao.saveOrUpdateUser(info);
		
		return "register";
		
	}
}
