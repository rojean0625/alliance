package com.alliance.context;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:/mariadb.properties")
public class MariaDBConfig {
	@Value("${dataSource.driverClassName}")
	private String driverClassName;
	@Value("${dataSource.url}")
	private String url;
	@Value("${dataSource.username}")
	private String username;
	@Value("${dataSource.password}")
	private String password;
	@Value("${dataSource.initialSize}")
	private int initialSize;
	@Value("${dataSource.maxActive}")
	private int maxActive;

	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxActive(maxActive);
		return dataSource;
	}
}
