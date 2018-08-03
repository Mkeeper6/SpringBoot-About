package com.mkeeper.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mkeeper.entity.User;
import com.mkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mkeeper
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("save/name={name}&age={age}")
    public String save(@PathVariable String name, @PathVariable int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.insert(user);
        return "succ";
    }

    @GetMapping("get/name={name}")
    public User get(@PathVariable String name) {
        // sql 条件构造器
        EntityWrapper<User> ew = new EntityWrapper<>();
        ew.eq("name", name);
        User user = userService.selectOne(ew);
        return user;
    }
}