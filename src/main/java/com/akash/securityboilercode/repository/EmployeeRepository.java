package com.akash.securityboilercode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.entities.Role;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 public Optional<Employee> findByEmail(String email);
}
