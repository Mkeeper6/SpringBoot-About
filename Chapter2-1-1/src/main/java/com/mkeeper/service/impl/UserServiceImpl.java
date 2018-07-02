package com.mkeeper.service.impl;

import com.mkeeper.dao.UserDao;
import com.mkeeper.entity.User;
import com.mkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public List<User> findList() {
        return userDao.findList();
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteByUserId(Integer userId) {
        return userDao.deleteByUserId(userId);
    }
}
