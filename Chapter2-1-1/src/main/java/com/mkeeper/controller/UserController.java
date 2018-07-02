package com.mkeeper.controller;

import com.mkeeper.entity.User;
import com.mkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User findByUserId(@PathVariable Integer userId){
        return userService.findByUserId(userId);
    }

    @GetMapping
    public List<User> findList(){
        return userService.findList();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }


    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteByUserId(@PathVariable Integer userId){
        return userService.deleteByUserId(userId);
    }
}
