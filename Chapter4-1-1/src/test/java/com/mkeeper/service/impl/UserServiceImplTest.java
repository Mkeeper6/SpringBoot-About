package com.mkeeper.service.impl;

import com.mkeeper.entity.User;
import com.mkeeper.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Before
    public void setUp() {
        // 准备，清空user表
        userService.deleteAllUsers();
    }

    @Test
    public void test() {
        // 插入5个用户
        userService.create(User.builder().userName("a").password("123").phone("110").build());
        userService.create(User.builder().userName("b").password("1234").phone("119").build());
        userService.create(User.builder().userName("c").password("12345").phone("120").build());
        userService.create(User.builder().userName("d").password("123456").phone("122").build());
        userService.create(User.builder().userName("e").password("1234567").phone("135").build());

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());

        // 删除两个用户
        userService.deleteByName("a");
        userService.deleteByName("e");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }

    @Test
    public void transactionalTest(){
        // 插入5个用户
        userService.create(User.builder().userName("a").password("123").phone("110").build());
        userService.create(User.builder().userName("b").password("1234").phone("119").build());
        userService.create(User.builder().userName("c").password("12345").phone("120").build());
        userService.create(User.builder().userName("d").password("123456").phone("122").build());
        userService.create(User.builder().userName("e").password("1234567").phone("135").build());

        User otherUser = User.builder().userName("f").password("12345678").phone("911").build();

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());

        userService.clearAdd(otherUser);
        userService.create(User.builder().userName("a").password("123").phone("110").build());

        // 查数据库，应该有2个用户
        Assert.assertEquals(2, userService.getAllUsers().intValue());

        UserService mockService = mock(UserServiceImpl.class);

        when(mockService.create(otherUser)).thenThrow(new RuntimeException());

        mockService.clearAdd(otherUser);

        // 查数据库，应该有2个用户
        Assert.assertEquals(2, userService.getAllUsers().intValue());
    }

}