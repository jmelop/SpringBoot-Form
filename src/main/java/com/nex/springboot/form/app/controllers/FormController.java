package com.nex.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.nex.springboot.form.app.editors.CountryPropertyEditor;
import com.nex.springboot.form.app.editors.NameCapitalEditor;
import com.nex.springboot.form.app.editors.RolesEditor;
import com.nex.springboot.form.app.models.domain.Country;
import com.nex.springboot.form.app.models.domain.Role;
import com.nex.springboot.form.app.models.domain.User;
import com.nex.springboot.form.app.services.CountryService;
import com.nex.springboot.form.app.services.RoleService;
import com.nex.springboot.form.app.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class FormController {

	@Autowired
	private UserValidator validator;

	@Autowired
	private CountryService countryService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RolesEditor roleEditor;

	@Autowired
	private CountryPropertyEditor countryEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "username", new NameCapitalEditor());

		binder.registerCustomEditor(Country.class, "country", countryEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);
	}

	@ModelAttribute("listRoles")
	public List<Role> listRoles() {
		return this.roleService.list();
	}

	@ModelAttribute("countryList")
	public List<Country> countryList() {
		return countryService.list();
	}

	@ModelAttribute("countries")
	public List<String> countries() {
		return Arrays.asList("Spain", "France", "Argentina", "Germany");
	}

	@ModelAttribute("listRolesString")
	public List<String> listRolesString() {
		List<String> roles = new ArrayList();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}

	@ModelAttribute("listRolesMap")
	public Map<String, String> listRolesMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrator");
		roles.put("ROLE_USER", "User");
		roles.put("ROLE_MODERATOR", "Moderator");
		return roles;
	}

	@ModelAttribute("countriesMap")
	public Map<String, String> countriesMap() {
		Map<String, String> countries = new HashMap<String, String>();
		countries.put("ES", "Spain");
		countries.put("FR", "France");
		countries.put("AR", "Argentina");
		countries.put("DE", "Germany");
		return countries;
	}

	@GetMapping("/form")
	public String form(Model model) {
		User user = new User();
		user.setId("123429");
		user.setEnable(true);
		user.setSecretValue("Test");

		model.addAttribute("title", "Users form");
		model.addAttribute("user", user);
		return "form";
	}

	@PostMapping("/form")
	public String getForm(@Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Form data");
			return "form";
		}

		return "redirect:/info";
	}

	@GetMapping("/info")
	public String info(@SessionAttribute(name = "user", required = false) User user, Model model,
			SessionStatus status) {
		
		if (user == null) {
			return "redirect:/form";
		}
		model.addAttribute("title", "Form data");

		status.setComplete();
		return "result";
	}
}