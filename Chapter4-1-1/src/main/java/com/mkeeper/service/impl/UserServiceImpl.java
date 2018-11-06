package com.mkeeper.service.impl;

import com.mkeeper.entity.User;
import com.mkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(User user) {
        return jdbcTemplate.update("insert into T_USER(USER_NAME, PASSWORD, PHONE) values (?, ?, ?)",
                user.getUserName(), user.getPassword(), user.getPhone());
    }

    @Override
    public void deleteByName(String userName) {
        jdbcTemplate.update("delete from T_USER where USER_Name = ?", userName);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from T_USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from T_USER");
    }

    @Transactional
    @Override
    public void clearAdd(User user) {
        this.deleteAllUsers();
        this.create(user);
    }
}
