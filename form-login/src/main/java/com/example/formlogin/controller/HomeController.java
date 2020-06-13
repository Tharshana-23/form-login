package com.example.formlogin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.formlogin.model.Person;
import com.example.formlogin.repository.IpersonRepo;
import com.example.formlogin.service.UserService;

@Controller
public class HomeController {
	@Autowired
	IpersonRepo ifrepo;
	
	@Autowired
	UserService service;
	
	@RequestMapping({"/login"})
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
    public String addForm(@Valid Person person,BindingResult result, Model model) throws Exception {
	 String p=person.getEmail();
	 if(p==null) {
		 throw new Exception("Email id is already exist");
	 }
	   
    if (result.hasErrors()) {
		return "form";
			
			}
	service.saveperson(person);
	String success_message="Success!!!Your form has been submitted.";
	model.addAttribute("successMessage", success_message);
	return "form";}

   
	
}
