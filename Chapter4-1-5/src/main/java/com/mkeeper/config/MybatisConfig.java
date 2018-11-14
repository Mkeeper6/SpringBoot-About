package com.mkeeper.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class MybatisConfig {

    @Configuration
    @MapperScan(basePackages = {"com.mkeeper.mapper.one"},
            sqlSessionFactoryRef = "sqlSessionFactoryOne",
            sqlSessionTemplateRef = "sqlSessionTemplateOne")
    public static  class DBOne{
        @Resource
        DataSource dbOneDataSource;

        @Bean
        @Primary
        public SqlSessionFactory sqlSessionFactoryOne() throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dbOneDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/one/*.xml"));
            return factoryBean.getObject();

        }

        @Bean
        @Primary
        public SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryOne()); // 使用上面配置的Factory
            return template;
        }
    }

    @Configuration
    @MapperScan(basePackages = {"com.mkeeper.mapper.two"},
            sqlSessionFactoryRef = "sqlSessionFactoryTwo",
            sqlSessionTemplateRef ="sqlSessionTemplateTwo" )
    public static class DBTwo{
        @Resource
        DataSource dbTwoDataSource;


        @Bean
        public SqlSessionFactory sqlSessionFactoryTwo() throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dbTwoDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/two/*.xml"));
            return factoryBean.getObject();

        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplateTwo() throws Exception {
            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTwo()); // 使用上面配置的Factory
            return template;
        }
    }
}