package com.wf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.entry.User;
import com.wf.mapper.UserMapper;
import com.wf.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> selectUser() {
        return this.list();
    }

}
