package com.wf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.entry.User;
import com.wf.mapper.UserMapper;
import com.wf.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> selectUser() {
        return this.list();
    }

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        User users = this.getOne(queryWrapper);
        if (null == users) {
            return null;
        }
        return users;
    }

    @Override
    public int register(User user) {
        user.setCreateTime(new Date());
        this.save(user);
        return 1;
    }
}
