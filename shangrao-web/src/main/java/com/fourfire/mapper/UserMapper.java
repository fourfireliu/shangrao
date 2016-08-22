package com.fourfire.mapper;

import com.fourfire.entity.User;

public interface UserMapper {
	User selectById(long id);
	User selectByUsername(String username);
}
