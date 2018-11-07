package com.mkeeper;

import com.mkeeper.entity.User;
import com.mkeeper.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserRepository userRepository;


    @Before
    public void setUp() {
        // 准备，清空user表
        userRepository.deleteAll();
    }

    @Transactional
    @Test
    public void test() {
        // 插入5个用户
        userRepository.save(User.builder().userName("a").password("123").phone("110").build());
        userRepository.save(User.builder().userName("b").password("1234").phone("119").build());
        userRepository.save(User.builder().userName("c").password("12345").phone("120").build());
        userRepository.save(User.builder().userName("d").password("123456").phone("122").build());
        userRepository.save(User.builder().userName("e").password("1234567").phone("135").build());

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userRepository.findAll().size());

        // 测试findByUserName
        Assert.assertEquals("110", userRepository.findByUserName("a").getPhone());

        // 测试findByUserNameAndPhone
        Assert.assertEquals("1234", userRepository.findByUserNameAndPhone("b", "119").getPassword());


        // 删除两个用户
        userRepository.delete(userRepository.findUser("a"));
        userRepository.delete(userRepository.findUser("b"));

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userRepository.findAll().size());
    }



}