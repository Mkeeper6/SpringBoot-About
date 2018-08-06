package com.mkeeper.mapper;

import com.baomidou.mybatisplus.annotations.SqlParser;
import com.mkeeper.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface UserMapper extends SuperMapper<User> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    /**
     * 注解 @SqlParser(filter = true) 过滤多租户解析
     */
    @SqlParser(filter = true)
    @Select("select test_id as id, name, age, test_type from user")
    List<User> selectListBySQL();

}