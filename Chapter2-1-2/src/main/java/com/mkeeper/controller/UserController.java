package com.mkeeper.controller;

import com.mkeeper.common.R;
import com.mkeeper.entity.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping("/ok")
    public R<User> ok(){
        User user  = new User();
        user.setUserId(1);
        user.setName("Mkeeper");
        user.setAge(28);

        return R.isOk().data(user);
    }

    @GetMapping("/fail")
    public R<Object> fail(){
        return R.isFail();
    }

    @GetMapping("/exception")
    public R<Object> exception(){

        return R.isFail(new Exception("失败"));
    }
}
