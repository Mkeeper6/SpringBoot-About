package com.mkeeper.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//指定配置文件，如果不指定，默认解析“application.yml”
@PropertySource("classpath:user.properties")
//前缀
@ConfigurationProperties(prefix = "company.user")
public class UserProperties {

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
        return "UserProperties {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
