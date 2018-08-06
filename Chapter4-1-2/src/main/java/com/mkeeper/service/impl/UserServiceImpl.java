package com.mkeeper.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mkeeper.entity.User;
import com.mkeeper.mapper.UserMapper;
import com.mkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {

        return userMapper.insertSelective(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public Page<User> findByPage(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        //只要这里设置，就物理分页，返回对应分页数据
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.findByPage();
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAllUser();
    }


    @Override
    public User findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertList(List<User> list) {
        return userMapper.insertList(list);
    }
}
