package com.codingdojo.dojosninjas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.codingdojo.dojosninjas.models.Stash;
import com.codingdojo.dojosninjas.models.User;
import com.codingdojo.dojosninjas.services.StashService;

@Controller
public class StashController {
	@Autowired
	private StashService stashService;
	
	@GetMapping("/home")
	public String stashAll(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/";
		}
//		query for all stashes; display all stashes
		model.addAttribute("stashes", stashService.findAll());
		return "show_all_stashes";
	}
	
	@GetMapping("/stashes/{id}")
	public String stashShow(@PathVariable("id") Long stashId, Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/";
		}		
//		do query for stash by id
//		display stash on the page
		model.addAttribute("stash", stashService.findById(stashId));
		return "show_one_stash";
	}	
		
	@GetMapping("/stashes/{id}/edit")
	public String stashEdit(@PathVariable("id") Long stashId, Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/";
		}
//		do query for the stash by id
//		display stash for editing on the page
		model.addAttribute("stash", stashService.findById(stashId));
		return "edit_stash";
	}
	
	@PostMapping("/stashes/{id}/edit")
	public String stashUpdate(@Valid @ModelAttribute("stash") Stash stash, BindingResult res, HttpSession session) {
		if (res.hasErrors()){
			return "edit_stash";
		}
				
		stash.setUser((User)session.getAttribute("user"));
		stashService.update(stash);
		return "redirect:/home";
	}
	
	@GetMapping("/stashes/new")
	public String stashNew(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/";
		}
// 		send blank stash object to page/form
		model.addAttribute("stash", new Stash());
		return "add_stash";
	}
	
	@PostMapping("/stashes/new")
	public String stashCreate(@Valid @ModelAttribute("stash") Stash stash, BindingResult res, HttpSession session) {
		if (res.hasErrors()) {
			return "add_stash";
		}
		stash.setUser((User)session.getAttribute("user"));
		stashService.create(stash);
		return "redirect:/home";
	}
	
	@PostMapping("/stashes/delete/{id}")
	public String deleteStash(@PathVariable("id") Long stashId) {
		stashService.deleteById(stashId);
		return "redirect:/home";
	}

}
