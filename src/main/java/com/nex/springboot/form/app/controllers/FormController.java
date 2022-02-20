package com.nex.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.nex.springboot.form.app.models.domain.User;

@Controller
@SessionAttributes("user")
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		User user = new User();
		user.setId("123429");
		model.addAttribute("title", "Users form");
		model.addAttribute("user", user);
		return "form";
	}
	
	@PostMapping("/form")
	public String getForm(@Valid User user, BindingResult result, Model model, SessionStatus status) {
		
		model.addAttribute("title", "Form data");
		
		if(result.hasErrors()) {
			
			return "form";
		}

		model.addAttribute("user", user);
		status.setComplete();
		return "result";
	}
}