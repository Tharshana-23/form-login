package com.example.formlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.formlogin.model.Role;

public interface IroleRepo extends JpaRepository<Role, Integer> {

	Role findByRole(String role);
}
