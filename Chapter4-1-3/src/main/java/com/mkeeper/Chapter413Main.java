package com.mkeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class Chapter413Main {

    protected final static Logger logger = LoggerFactory.getLogger(Chapter413Main.class);

    /**
     * <p>
     * 测试 RUN<br>
     * 查看 h2 数据库控制台：http://localhost:8080/console<br>
     * 使用：JDBC URL 设置 jdbc:h2:mem:testdb 用户名 sa 密码 sa 进入，可视化查看 user 表<br>
     * 误删连接设置，开发机系统本地 ~/.h2.server.properties 文件<br>
     * <br>
     * 1、http://localhost:8080/user/test<br>
     * 2、http://localhost:8080/user/test1<br>
     * 3、http://localhost:8080/user/test2<br>
     * 4、http://localhost:8080/user/test3<br>
     * 5、http://localhost:8080/user/add<br>
     * 6、http://localhost:8080/user/selectsql<br>
     * 7、分页 size 一页显示数量  current 当前页码
     * 方式一：http://localhost:8080/user/page?size=1&current=1<br>
     * 方式二：http://localhost:8080/user/pagehelper?size=1&current=1<br>
     * </p>
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Chapter413Main.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        SpringApplication.run(app, args);
        logger.info("PortalApplication is success!");
        System.err.println("sample started. http://localhost:8080/user/test");
        System.err.println("多租户插件配置： MybatisPlusConfig.paginationInterceptor(): paginationInterceptor.setSqlParserList(sqlParserList);");
        System.err.println("SQL执行效率插件：MybatisPlusConfig.performanceInterceptor(): 不想开启可以删除这段代码");
        System.err.println("自动填充插件：application.yml： mybatis-plus:global-config:meta-object-handler: xxxx");
        System.err.println("通用枚举注入: application.yml: mybatis-plus: typeEnumsPackage:  xxPackage");
    }
}
