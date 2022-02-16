package com.nex.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nex.springboot.form.app.models.domain.User;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Users form");
		return "form";
	}
	
	@PostMapping("/form")
	public String getForm(User user, Model model) {

		model.addAttribute("title", "Form data");
		model.addAttribute("user", user);
		
		return "result";
	}
}