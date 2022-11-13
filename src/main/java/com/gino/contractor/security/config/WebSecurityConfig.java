package com.gino.contractor.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/showReg","/saveCon", "/loginResult","/loginTest","/api/users/login", "/displayContractors","/index.html", "/registerUser", "/login", "/showLogin", "/login/*",
						"/contractors","/contractors/*","/showUpdate","/deleteContractor","/updateContractor","/generateReport","/createUser",
						"/location","/contractorweb/contractors/listbylocation/")
				.permitAll().antMatchers("/showCreate").hasAnyAuthority("ADMIN").anyRequest().authenticated()
				.and().csrf().disable();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}

}
