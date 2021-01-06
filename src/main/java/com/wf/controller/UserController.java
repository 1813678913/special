package com.wf.controller;

import com.wf.entry.User;
import com.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public List<User> test() {
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
