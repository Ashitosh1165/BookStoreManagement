package com.example.BookStoreManagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.BookStoreManagement.data.model")
@EnableJpaRepositories(basePackages = "com.example.BookStoreManagement.repository")
public class BookStoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagementApplication.class, args);
	}

//	@Bean
//	public DataSource tenantDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/dbBookStore");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
//
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//
//	Properties additionalProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		properties.setProperty("spring.datasource.hikari.connection-timeout", "300000");
//		properties.setProperty("spring.datasource.hikari.minimum-idle", "5");
//		properties.setProperty("spring.datasource.hikari.maximum-pool-size", "150");
//		properties.setProperty("spring.datasource.hikari.idle-timeout", "300000");
//		properties.setProperty("spring.datasource.hikari.max-lifetime", "1200000");
//		properties.setProperty("spring.datasource.hikari.auto-commit", "true");
//		properties.setProperty("spring.jpa.hibernate.ddl-auto", "update");
//		return properties;
//	}

	

	
}
