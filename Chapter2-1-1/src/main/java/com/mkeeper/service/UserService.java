package com.mkeeper.service;

import com.mkeeper.entity.User;

import java.util.List;

public interface UserService {
     User findByUserId(Integer userId);

     List<User> findList();

     User addUser(User user);


     User updateUser(User user);

     boolean deleteByUserId(Integer userId);
}
