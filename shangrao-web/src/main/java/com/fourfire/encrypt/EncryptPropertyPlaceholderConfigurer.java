package com.fourfire.encrypt;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import com.fourfire.util.EncryptUtil;

/**
 * 暴露的配置项解密
 * 
 * @author liuyi
 * @date 2016-08-25
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private String[] propertyNames = {"datasource.username", "datasource.password"};
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProperty(propertyName)) {
			return EncryptUtil.getDecryptString(propertyValue);
		}
		
		return propertyValue;
	}
	
	private boolean isEncryptProperty(String propertyName) {
		for (String name : propertyNames) {
			if (name.equalsIgnoreCase(propertyName)) {
				return true;
			}
		}
		
		return false;
	}
}
