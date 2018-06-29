package com.mkeeper.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:user.properties")
@ConfigurationProperties(prefix = "company.user")
public class UserPropertiesConfig {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestPropertiesConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
