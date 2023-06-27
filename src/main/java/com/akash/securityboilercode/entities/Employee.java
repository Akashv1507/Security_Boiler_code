package com.akash.securityboilercode.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

	
	/*
	 * Reference for many to many mapping https://www.baeldung.com/jpa-many-to-many
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private long empId;
	private String email;
	private String name;
	private String password;

	
	/* @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) */
	@ManyToMany() 
	@JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> empRoles = new ArrayList<Role>();
	
	/*
	 * public void adddEmpRoles(Role empRole) {
	 * 
	 * this.empRoles.add(empRole); }
	 */
	
}
