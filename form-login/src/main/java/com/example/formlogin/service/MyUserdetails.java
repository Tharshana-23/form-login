package com.example.formlogin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.formlogin.model.Person;
import com.example.formlogin.model.Role;

public class MyUserdetails implements UserDetails {
	
	private Person person;
	

	public MyUserdetails(Person person) {
		
		this.person = person;
	}

	
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role>roles=person.getRoles();
		List<SimpleGrantedAuthority>authorities =new ArrayList<>();
		
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return person.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
