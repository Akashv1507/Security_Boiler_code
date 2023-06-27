package com.akash.securityboilercode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.securityboilercode.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	 public Optional<Role> findByRoleName(String roleName);
}
