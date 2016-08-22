package com.fourfire.operator;

import org.thymeleaf.util.StringUtils;

public class Test implements TestMBean {
	public void test1() {
		System.out.println("Hello test1");
	}
	
	public String test2(String input) {
		System.out.println("input=" + input);
		if (StringUtils.isEmpty(input)) {
			return "Fourfire";
		}
		
		return "input=" + input;
	}
	
	private void test3() {
		System.out.println("Hello test3");
	}
}
