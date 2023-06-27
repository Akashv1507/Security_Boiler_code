package com.akash.securityboilercode.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akash.securityboilercode.entities.Employee;
import com.akash.securityboilercode.entities.Role;
import com.akash.securityboilercode.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		String userName, password = null;
		List<Role> roles = null;
		List<GrantedAuthority> authorities = null;
		Employee emp = employeeRepository.findByEmail(email).orElse(null);
		if (emp == null) {
			throw new UsernameNotFoundException("User details not found for the user : " + email);
		} else {
			userName = emp.getEmail();
			password = emp.getPassword();
			authorities = new ArrayList<>();
			roles = emp.getEmpRoles();

			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}

		}
		return new User(userName, password, authorities);
	}
}
