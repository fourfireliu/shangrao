package com.fourfire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fourfire.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThemeleafTestApplicationTests {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testUser() {
		long id = 1;
		String username = "liu";
		System.out.println(userDao.getUserByName(username));
	}
	

}
