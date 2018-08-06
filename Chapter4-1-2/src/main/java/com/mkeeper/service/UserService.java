package com.mkeeper.service;

import com.github.pagehelper.Page;
import com.mkeeper.entity.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    Page<User> findByPage(int pageNum, int pageSize);

    List<User> findAll();

    User findById(int id);

    int insertList(List<User> list);
}
