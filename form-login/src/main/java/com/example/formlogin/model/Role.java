package com.example.formlogin.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	

	
		
	
	public Role( String role) {
		
		
		this.role = role;
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String role;
	
	@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER)
	private Collection<Person> persons;
	
	
	public Collection<Person> getPersons() {
		return persons;
	}
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", persons=" + persons + "]";
	}
	
	
	

}
