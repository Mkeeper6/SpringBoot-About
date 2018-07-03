package com.mkeeper.controller;

import com.mkeeper.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    // 入口：处理相应URL

    //@Autowired
    //private UserService userService;

    @GetMapping("/{userId}")
    public User findByUserId(@PathVariable Integer userId){
        // 处理“/users/{userId}”的Get请求，获取user信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return null;//userService.findByUserId(userId);
    }

    @GetMapping("/")
    public List<User> findList(){
        // 处理“/users/”的Get请求，获取用户列表信息
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        return null;//userService.findList();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        // 处理"/users/"的POST请求，用来创建User
        // 除了@RequestBody绑定参数之外，还可以通过@RequestParam从页面中传递参数
        return null;//userService.addUser(user);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        return null;//.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteByUserId(@PathVariable Integer userId){
        // 处理"/users/{id}"的DELETE请求，用来删除User
        return true;//userService.deleteByUserId(userId);
    }
}
