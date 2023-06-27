package com.akash.securityboilercode.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Role {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String roleName;

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	@ManyToMany(mappedBy = "empRoles")
	private List<Employee> roleEmployees = new ArrayList<Employee>();
}
