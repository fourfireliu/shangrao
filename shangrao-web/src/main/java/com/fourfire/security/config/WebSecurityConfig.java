package com.fourfire.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	//public 
	
	//@Bean
	public LogoutSuccessHandler newLogoutSusscessHandler() {
		return new LogoutSuccessHandler() {
			
			@Override
			public void onLogoutSuccess(HttpServletRequest request,
					HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException {
				System.out.println("Hello world");
				
			}
		};
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and()
			.formLogin().loginPage("/login").permitAll().and()
			.httpBasic().and()
			.logout().permitAll().logoutSuccessHandler(newLogoutSusscessHandler());
	}
}
