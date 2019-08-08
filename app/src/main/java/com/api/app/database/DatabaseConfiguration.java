package com.api.app.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DatabaseConfiguration {
	@Bean()
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		dataSource.setUrl("jdbc:mysql://localhost:3307/app?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); 
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        vendorAdapter.setPrepareConnection(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("app");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.api.app.model");
        factory.setDataSource(dataSource());

        return factory;
    }
    
    Properties additionalProperties() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.hbm2ddl.auto", "update");
    	return properties;
    }
}