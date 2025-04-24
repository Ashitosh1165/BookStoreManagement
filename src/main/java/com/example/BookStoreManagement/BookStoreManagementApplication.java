package com.example.BookStoreManagement;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


import jakarta.persistence.EntityManagerFactory;


@SpringBootApplication
@EnableJpaRepositories(
	    basePackages = "com.example.BookStoreManagement.repository",
	    entityManagerFactoryRef = "tenantEntityManagerFactory",
	    transactionManagerRef = "tenantTransactionManager"
	)

@EntityScan(basePackages = "com.example.BookStoreManagement.data.model")
public class BookStoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagementApplication.class, args);
	}

//	@Bean
//	public AuditorAware<Integer> auditorAware() {
//		return new AuditorAwareImpl();
//	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean tenantEntityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(tenantDataSource());
////		em.setPackagesToScan("com.example.BookStoreManagement.data.model");
////		em.setPersistenceUnitName("tenant_pu");
//
//		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		em.setJpaVendorAdapter(vendorAdapter);
//		em.setJpaProperties(additionalProperties());
//
//		return em;
//	}
//
//	@Bean
//	public DataSource tenantDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/dbBookStore");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
//
//	@Bean
//	public PlatformTransactionManager tenantTransactionManager(
//			@Qualifier("tenantEntityManagerFactory") EntityManagerFactory emf) {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(emf);
//
//		return transactionManager;
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
//	

	
}
