package com.mkeeper.controller.logging;

import com.mkeeper.common.R;
import com.mkeeper.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class AopLogController {

    @PostMapping("/user")
    public R addUser(@RequestBody User user){

        return R.isOk().data(user);
    }
}
