package com.mkeeper.mapper;

import com.github.pagehelper.Page;
import com.mkeeper.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();

    /**
     * 分页查询数据
     * @return
     */
    Page<User> findByPage();

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertList(List<User> list);
}