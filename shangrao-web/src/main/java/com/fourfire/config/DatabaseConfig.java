package com.fourfire.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@MapperScan(basePackages="com.fourfire.mapper")
public class DatabaseConfig {
//	@Value("${shangrao.db.url}")
//	private String url;
//	@Value("${shangrao.db.username}")
//	private String username;
//	@Value("${shangrao.db.password}")
//	private String password;
//	
//	@Value(value = "classpath:")
//	private Resource mybatisConfigPath;
//	
//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		dataSource.setMaxTotal(20);
//		dataSource.setMaxIdle(5);
//		dataSource.setDefaultAutoCommit(true);
//		dataSource.setRemoveAbandonedOnBorrow(true);
//		dataSource.setRemoveAbandonedOnMaintenance(true);
//		dataSource.setRemoveAbandonedTimeout(60);
//		
//		return dataSource;
//	}
//	
//	@Bean(name="userSqlSessionFactory")
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//		sqlSessionFactory.setConfigLocation(mybatisConfigPath);
//		
//		return sqlSessionFactory.getObject();
//	}
	
	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String original = "ursaminor";
		String result = "$2a$10$iXOzUIwgzZFcnMGQ2pq/bOE6Dec0esjEJYX5NVsLAZGS9j3pH3jiy";
		System.out.println(encoder.matches(original, result));
	}
	
}
