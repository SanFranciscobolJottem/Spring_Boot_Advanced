package com.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
		  .inMemoryAuthentication()
		    .withUser("sfjuser") 
		    .password("pass")
		    .roles("USER")
		   .and()
             .withUser("sfjadmin")
             .password("pass")
             .roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}	
	
}
