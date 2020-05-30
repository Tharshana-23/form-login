package com.example.formlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.formlogin.model.Person;
import com.example.formlogin.repository.IpersonRepo;

@Controller
public class HomeController {
	@Autowired
	IpersonRepo ifrepo;
	
	@RequestMapping("/login")
	public String login() {
	return "login";
	}		
	
	@Autowired
	IpersonRepo iprepo;

	@GetMapping("/form")
	public String showform(Person person) {
		return "form";
		
	}
   @PostMapping("/update")
    public String addForm(Person person, Model model) {
   // if (result.hasErrors()) {
		//return "form";
			
	//		}
	ifrepo.save(person);
	String success_message="Success!!!Your form has been submitted.";
	model.addAttribute("message", success_message);
	return "form";}

	
}
