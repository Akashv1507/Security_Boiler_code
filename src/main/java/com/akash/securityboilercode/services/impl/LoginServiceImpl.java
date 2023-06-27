package com.akash.securityboilercode.services.impl;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.RoleList;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.entities.Role;
import com.akash.securityboilercode.model.RegisterResult;
import com.akash.securityboilercode.model.RegistrationModel;
import com.akash.securityboilercode.repository.EmployeeRepository;
import com.akash.securityboilercode.repository.RoleRepository;
import com.akash.securityboilercode.services.LoginService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

	
	private EmployeeRepository employeeRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder; 
	
	
	@Override
	public RegisterResult registerUser(RegistrationModel registrationData) {
		
		long empId = registrationData.getEmpId();
		String email= registrationData.getEmail();
		String nameString =registrationData.getName();
		String pwd= registrationData.getPassword();
		List<String> rolesStringList=registrationData.getRoles();
		
		if(email==null || email.length()==0||nameString==null || nameString.length()==0||pwd==null || pwd.length()==0||rolesStringList.size()==0) {
			return new RegisterResult("Please Send Valid Registration Details", HttpStatus.BAD_REQUEST);
		}
		
		Employee emp=new Employee();
		//hashing user entered password
		String hashedPwd = passwordEncoder.encode(pwd);
		emp.setEmpId(empId);
		emp.setEmail(email);
		emp.setName(nameString);
		emp.setPassword(hashedPwd);
		
		
		//fetching all roles from db that match with roles of registration data.
		List<Role> rolesList = rolesStringList.stream().map(stringRole->roleRepository.findByRoleName(stringRole).orElse(null)).collect(Collectors.toList());
		//Converting  roles string of registration data to List of Roles.In this case Cascade should be used.
		//List<Role> rolesList = rolesStringList.stream().map(stringRole->new Role(stringRole)).collect(Collectors.toList());
		
		for(Role role:rolesList) {
			if(role==null) {return new RegisterResult("Entered User Role Does Not Exist", HttpStatus.BAD_REQUEST);}
		}
		
		try {
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(emp);
			//setting employee to each role, enforcing two way binding
			rolesList.stream().forEach(role-> role.setRoleEmployees(employees));
			//setting roles list to employee
			emp.setEmpRoles(rolesList);	
			//saving employee
			Employee savedEmp=employeeRepository.save(emp);
			if(savedEmp.getId()>0) {
				return new RegisterResult("Employee Saved Successfully", HttpStatus.CREATED);
				
			}else {
				return new RegisterResult("Error in Saving Employee", HttpStatus.BAD_REQUEST);
			}
					
			
		} catch (Exception ex) {
			return new RegisterResult(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
	}
	/*
	 * You should include cascade="all" This happens because you have a collection
	 * in your entity, and that collection has one or more items which are not
	 * present in the database. By specifying the above options you tell hibernate
	 * to save them to the database when saving their parent.
	 */

	
}
