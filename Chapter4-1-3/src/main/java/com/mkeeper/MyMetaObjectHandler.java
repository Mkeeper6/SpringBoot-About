package com.mkeeper;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

/**
 *  注入公共字段自动填充,任选注入方式即可
 */
//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    protected final static Logger logger = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("新增的时候干点不可描述的事情");
        //sample usage
        Object testType = this.getFieldValByName("testType", metaObject);
        System.out.println("testType=" + testType);
        if (testType == null) {
            //测试实体没有的字段，配置在公共填充，不应该set到实体里面
            this.setFieldValByName("testType1", 3, metaObject);
            this.setFieldValByName("testType", 3, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("更新的时候干点不可描述的事情");
        //sample usage
        //测试实体没有的字段，配置在公共填充，不应该set到实体里面
        this.setFieldValByName("lastUpdatedDt1", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("lastUpdatedDt", new Timestamp(System.currentTimeMillis()), metaObject);
    }
}
