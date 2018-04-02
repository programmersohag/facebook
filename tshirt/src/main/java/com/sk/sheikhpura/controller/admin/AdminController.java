package com.sk.sheikhpura.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sk.sheikhpura.dao.UserDao;
import com.sk.sheikhpura.entity.UserInfo;
import com.sk.sheikhpura.model.ProductInfo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserDao dao;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}

	}

	@RequestMapping("")
	public String adminPage(Model model) {
		System.out.println("Yes!!!!!!!!!!!!!!!!");
		return "admin";
	}

	@RequestMapping("/userList")
	public String showUserList(Model model) {
		try {
			List<UserInfo> userList = dao.getUsers();
			model.addAttribute("users", userList);
		} catch (Exception e) {
			e.getMessage();
		}
		return "userList";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateUsers(@RequestAttribute("userId") String userId, Model model, UserInfo users) {
		UserInfo entity=dao.findUserById(Integer.parseInt(userId));
		if(entity!=null){
			model.addAttribute("fname", entity.getFirstName());
		}
		
		
		return null;

	}
	
	@ResponseBody
	@RequestMapping(value = "ajax/user/info", method = RequestMethod.POST)
	public UserInfo createEmployee() {
		UserInfo entity=new UserInfo();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("first_name", entity.getFirstName());
		map.put("last_name", entity.getLastName());
		map.put("user_name", entity.getUserName());
		map.put("email", entity.getEmail());
		map.put("gender", entity.getInsDate());
		
		return entity;
	}

}
