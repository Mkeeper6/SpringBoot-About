package com.mkeeper.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mkeeper.entity.User;
import com.mkeeper.mapper.UserMapper;
import com.mkeeper.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    public List<User> selectListBySQL() {
        return baseMapper.selectListBySQL();
    }

}