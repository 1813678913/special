package com.wf.controller;

import com.wf.entry.User;
import com.wf.service.UserService;
import com.wf.utils.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public List<User> test() {
        User user = null;
        if (null == user) {
            throw new BaseException("数据错误！！！");
        }
        List<User> users = userService.selectUser();
        return users;
    }

    /**
     * 必传 name pwd
     *
     * @param user
     * @return
     */
    @PostMapping()
    public User login(User user) {
        userService.login(user);
        return userService.login(user);
    }

    @GetMapping
    public int Register(User user) {
        userService.register(user);
        return 1;
    }

}
