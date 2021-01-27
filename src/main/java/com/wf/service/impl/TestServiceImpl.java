package com.wf.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.entry.User;
import com.wf.mapper.UserMapper;
import com.wf.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends ServiceImpl<UserMapper, User> implements TestService {

//    @Autowired
//    private TestMapper testMapper;

    @Override
    public List<User> AllUser(String name) {
        // List<User> users = testMapper.allUser();
        if (name != "张三") {
            return null;
        }
        List<User> list = this.list();
        return list;

    }
}
