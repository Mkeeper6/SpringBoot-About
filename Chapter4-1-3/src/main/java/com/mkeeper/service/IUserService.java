package com.mkeeper.service;

import com.baomidou.mybatisplus.service.IService;
import com.mkeeper.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    boolean deleteAll();

    public List<User> selectListBySQL();
}