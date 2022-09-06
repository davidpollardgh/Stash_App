package com.codingdojo.dojosninjas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.LoginUser;
import com.codingdojo.dojosninjas.models.User;
import com.codingdojo.dojosninjas.services.UserService;

@Controller
public class RootController
{
	@Autowired
	private UserService userService;

	@GetMapping("")
	public String login_register( Model model )
	{
		model.addAttribute("userRegister", new User());
		model.addAttribute("userLogin", new LoginUser());
		return "login_registration";
	}

	@PostMapping("/register")
	public String register	(
		@Valid @ModelAttribute("userRegister") User form_user,
		BindingResult res,
		Model model
	)
	{
		if(res.hasErrors())
		{
			model.addAttribute("userLogin",new LoginUser());
			return "login_registration";
		}
		
		User db_user=userService.register(form_user,res);
		
		if(db_user==null)
		{
			model.addAttribute("userLogin",new LoginUser());	
			return "login_registration";
		}
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login	(
		@Valid @ModelAttribute("userLogin") LoginUser loginUser,
		BindingResult res,
		Model model,
		HttpSession session
	)
	{
		if(res.hasErrors())
		{
			model.addAttribute("userRegister",new User());
			return "login_registration";
		}
		
		User db_user=userService.login(loginUser,res);
		
		if(db_user==null)
		{
			model.addAttribute("userRegister",new User());
			return "login_registration";
		}
		
		session.setAttribute("user",db_user);
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		userService.logout(session);
		return "redirect:/";
	}
};