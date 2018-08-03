package com.mkeeper.service.impl;

import com.mkeeper.entity.User;
import com.mkeeper.mapper.UserMapper;
import com.mkeeper.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mkeeper
 * @since 2018-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
