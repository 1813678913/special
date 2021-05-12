package com.wf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wf.entry.User;

import java.text.ParseException;
import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectUser();

    User login(User user);

    int register(User user);

    List<User> getAll(String[] time) throws ParseException;

    void add(String name);
}
