package com.fourfire.authenticate.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationManager implements AuthenticationManager {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		//authentication.getPrincipal()
		// TODO Auto-generated method stub
		return null;
	}

}
