package com.mkeeper.controller;

import com.mkeeper.entity.User;
import com.mkeeper.entity.common.PageInfo;
import com.mkeeper.entity.common.R;
import com.mkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public R addUser(@RequestBody User user){
        userService.addUser(user);
        return R.isOk();
    }

    @GetMapping("/all/{pageNum}/{pageSize}")
    public R findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return R.isOk().data(new PageInfo<>(userService.findByPage(pageNum, pageSize)));
    }

    @GetMapping("/{id}")
    public R findUserById(@PathVariable int id){
        return R.isOk().data(userService.findById(id));
    }

}
