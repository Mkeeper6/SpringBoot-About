package com.mkeeper.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Value("${datasource1.url}")
    private String db1Url;
    @Value("${datasource1.username}")
    private String db1UserName;
    @Value("${datasource1.password}")
    private String db1Password;
    @Value("${datasource1.driver-class-name}")
    private String db1DriverClass;

    @Value("${datasource2.url}")
    private String db2Url;
    @Value("${datasource2.username}")
    private String db2UserName;
    @Value("${datasource2.password}")
    private String db2Password;
    @Value("${datasource2.driver-class-name}")
    private String db2DriverClass;


    @Bean(name = "dbOneDataSource")
    @Primary
    public DataSource dbOneDataSource() {
        return this.bulidDataSource(db1DriverClass, db1Url, db1UserName, db1Password);
    }




    @Bean(name = "dbTwoDataSource")
    //@ConfigurationProperties(prefix = "datasource2")
    public DataSource dbTwoDataSource() {
        return this.bulidDataSource(db2DriverClass, db2Url, db2UserName, db2Password);
        //return DataSourceBuilder.create().build();
    }

    private DataSource bulidDataSource(String driverClass, String url, String username, String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}