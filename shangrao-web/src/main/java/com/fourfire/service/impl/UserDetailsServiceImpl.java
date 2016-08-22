package com.fourfire.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fourfire.dao.UserDao;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
