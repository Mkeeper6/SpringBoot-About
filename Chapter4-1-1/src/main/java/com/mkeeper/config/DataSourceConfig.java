package com.mkeeper.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean(name = "dbOneDataSource")
    @ConfigurationProperties(prefix = "datasource1")
    @Primary
    public DataSource dbOneDataSource() {
        return DataSourceBuilder.create().build();
    }




    @Bean(name = "dbTwoDataSource")
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource dbTwoDataSource() {
        return DataSourceBuilder.create().build();
    }
}