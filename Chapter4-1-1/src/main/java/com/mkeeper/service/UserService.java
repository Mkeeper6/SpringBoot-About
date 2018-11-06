package com.mkeeper.service;

import com.mkeeper.entity.User;

public interface UserService {

    /**
     * 新增一个用户
     */
    Integer create(User user);

    /**
     * 根据Name删除一个用户
     */
    void deleteByName(String userName);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 先清空数据
     * 再新增数据
     * 要求再一个事物中执行
     */
    void clearAdd(User user);
}
