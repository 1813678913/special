package com.wf.controller;

import com.wf.entry.User;
import com.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public List<User> test() {
        List<User> users = userService.selectUser();
        return users;
    }


}
