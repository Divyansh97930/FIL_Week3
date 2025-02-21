package com.test.register.registration1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/database.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Database properties file not found", e);
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));

        return dataSource;
    }
}
