package com.fourfire.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fourfire.encrypt.EncryptPropertyPlaceholderConfigurer;

/**
 * 数据库相关配置
 * 
 * @author liuyi
 * @date 2016-08-25
 */
@Configuration
@MapperScan(basePackages="com.fourfire.mapper")
public class DatabaseConfig {
	@Value("${datasource.username}")
	private String username;
	@Value("${datasource.password}")
	private String password;
	@Value("${datasource.driver-class-name}")
	private String driverClassName;
	@Value("${datasource.url}")
	private String url;
	@Value("${datasource.max-idle}")
	private int maxIdle;
	@Value("${datasource.max-total}")
	private int maxTotal;
	@Value("${datasource.timeout}")
	private int removeAbandonedTimeout;
	@Value(value = "classpath:mybatis-config.xml")
	private Resource mybatisConfigPath;
	@Value(value = "classpath:com/fourfire/mapper/*Mapper.xml")
	private Resource[] mapperLocationPath;
 	
	@Bean
	public static ClassPathResource resource() {
		return new ClassPathResource("application.properties");
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer configurer = new EncryptPropertyPlaceholderConfigurer();
		configurer.setLocation(resource());
		
		return configurer;
	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMaxTotal(maxTotal);
		dataSource.setDefaultAutoCommit(true);
		dataSource.setRemoveAbandonedOnBorrow(true);
		dataSource.setRemoveAbandonedOnMaintenance(true);
		dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
		
		return dataSource;
	}
	
	@Bean(name="userSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(mybatisConfigPath);
		sqlSessionFactory.setMapperLocations(mapperLocationPath);
		
		return sqlSessionFactory.getObject();
	}
	
	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String original = "ursaminor";
		String result = "$2a$10$iXOzUIwgzZFcnMGQ2pq/bOE6Dec0esjEJYX5NVsLAZGS9j3pH3jiy";
		System.out.println(encoder.matches(original, result));
	}
	
}
