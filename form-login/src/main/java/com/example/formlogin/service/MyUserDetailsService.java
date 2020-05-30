package com.example.formlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.formlogin.model.Person;
import com.example.formlogin.repository.IpersonRepo;

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	IpersonRepo personRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person=personRepo.findByUsername(username);
		
		if(person==null) {
			throw new UsernameNotFoundException("person 404");
		}
		return new MyUserdetails(person);
			}

}
