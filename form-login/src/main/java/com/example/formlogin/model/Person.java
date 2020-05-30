package com.example.formlogin.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;




@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinTable(name="person_role",
	                joinColumns= { @JoinColumn (name="person_id",referencedColumnName="id")},
	                 inverseJoinColumns= {@JoinColumn (name="role_id", referencedColumnName="id")})
	private Set<Role> roles=new HashSet<>();
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
	

}
