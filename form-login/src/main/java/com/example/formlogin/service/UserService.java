package com.example.formlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.formlogin.model.Person;
import com.example.formlogin.repository.IpersonRepo;

@Service
public class UserService {
	@Autowired
	IpersonRepo personRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Person findbyUsername(String username) {
		return personRepo.findByUsername(username);
	}
	
	public Person saveperson(Person person) {
		person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
		return personRepo.save(person);
	}

}
