package com.example.formlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.formlogin.model.Person;

public interface IpersonRepo extends JpaRepository<Person, Integer> {
	
	Person findByUsername(String username);
	Person findBypassword(String password);

}
