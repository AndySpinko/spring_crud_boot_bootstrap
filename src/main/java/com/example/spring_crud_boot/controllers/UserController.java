package com.example.spring_crud_boot.controllers;

import com.example.spring_crud_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;


@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/user")
	public String getUserPage(ModelMap modelMap, Principal principal) {
		modelMap.addAttribute("user", userService.loadUserByUsername(principal.getName()));
		return "userPage";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("user", userService.getUserById(id));
		return "userPage";
	}
}