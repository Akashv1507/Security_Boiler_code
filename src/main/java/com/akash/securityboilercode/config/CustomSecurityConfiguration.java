
package com.akash.securityboilercode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfiguration {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		/**
		 * Below is the custom security configurations, /error must be permitall(),if
		 * dont define controller methods of permitall()
		 */




		  http.authorizeHttpRequests( (requests) ->
		  requests.requestMatchers("/notices").permitAll()
		  .requestMatchers("/admin/**").hasRole("ADMIN") .anyRequest().authenticated())
		  .formLogin(form->form.defaultSuccessUrl("/home"))
		  .httpBasic(Customizer.withDefaults()) .csrf((csrf) -> csrf.disable());

		  return http.build();



		/*
		 * http.authorizeHttpRequests( (requests) ->
		 * requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards",
		 * "/contact").authenticated() .requestMatchers("/notices",
		 * "/error","/registration").permitAll())
		 * .formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		 * return http.build();
		 */



		 /* Configuration to deny all the requests*/


		  /*http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
		  .formLogin(Customizer.withDefaults()) .httpBasic(Customizer.withDefaults());
		  return http.build();*/


			/* Configuration to permit all the requests */



			/*
			 * http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
			 * .formLogin(Customizer.withDefaults())
			 * .httpBasic(Customizer.withDefaults()).csrf((csrf) -> csrf.disable()); return
			 * http.build();
			 */



			/*
			 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
			 * Exception { http.csrf().disable() .authorizeHttpRequests((authorize) ->
			 * authorize.anyRequest().authenticated() ).formLogin( form -> form
			 * .loginPage("/login") .loginProcessingUrl("/login")
			 * .defaultSuccessUrl("/welcome") .permitAll() ).logout( logout -> logout
			 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) .permitAll() );
			 * return http.build(); }
			 */


	}

	@Bean
	   public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
