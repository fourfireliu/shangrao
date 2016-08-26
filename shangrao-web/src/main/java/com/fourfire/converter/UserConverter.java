package com.fourfire.converter;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fourfire.entity.User;

public class UserConverter {
	public static UserDetails convertToUserDetails(User user) {
		if (user == null) {
			return null;
		}
		
		UserDetails userDetails = new UserDetails() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPassword() {
				return user.getPassword();
			}

			@Override
			public String getUsername() {
				return user.getUsername();
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}
			
		};
		System.out.println("userdetails name=" + userDetails.getUsername());
		
		return userDetails;
	}
}
