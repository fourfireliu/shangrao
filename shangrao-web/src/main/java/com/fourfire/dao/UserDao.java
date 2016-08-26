package com.fourfire.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import com.fourfire.entity.User;
import com.fourfire.mapper.UserMapper;

@Repository
public class UserDao {
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(long id) {
		try {
			return userMapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUserByName(String username) {
		System.out.println("username=" + username);
		if (StringUtils.isEmptyOrWhitespace(username)) {
			return null;
		}
		
		try {
			return userMapper.selectByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
