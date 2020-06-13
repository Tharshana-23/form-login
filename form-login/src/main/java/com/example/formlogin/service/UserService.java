package com.example.formlogin.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.formlogin.model.Person;
import com.example.formlogin.model.Role;
import com.example.formlogin.repository.IpersonRepo;
import com.example.formlogin.repository.IroleRepo;

@Service
public class UserService {
	@Autowired
	IpersonRepo personRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	IroleRepo roleRepo;;
	
	public Person findbyUsername(String username) {
		return personRepo.findByUsername(username);
	}
	
	public Person saveperson(Person person) {
		person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
		
	
		person.setActive(true);
		return personRepo.save(person);
	}

}
