//package com.example.BookStoreManagement.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//@SuppressWarnings("serial")
//@Component
//public class LocationDataSourceMap extends HashMap<Object, Object> implements ApplicationContextAware {
//
//	private ApplicationContext applicationContext;
//	 private Map<String, HikariDataSource> dataSourceCache = new HashMap<>();
//	 
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//	}
//
//	@Override
//	 public synchronized Object get(Object key) {
//	 Object value = super.get(key);
//
//		if (value == null) {
//
//			
//				HikariDataSource dataSource = new HikariDataSource();
//				dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//				dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dbBookStore");
//				dataSource.setUsername("root");
//				dataSource.setPassword("root");
//				dataSource.setPoolName("connection");
//
//				// HikariCP settings
//				// Maximum number of actual connection in the pool
//				dataSource.setMaximumPoolSize(150);
//
//				// Minimum number of idle connections in the pool
//				dataSource.setMinimumIdle(10);
//
//				// Maximum waiting time for a connection from the pool
//				dataSource.setConnectionTimeout(20000);
//
//				// Maximum time that a connection is allowed to sit idle in the pool
//				dataSource.setIdleTimeout(300000);
//				value = dataSource;
//				super.put(key, value);
////			}
//		}
//		return value;
//	}
//
//}
