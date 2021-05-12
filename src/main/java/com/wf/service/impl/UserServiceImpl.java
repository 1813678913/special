package com.wf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.entry.User;
import com.wf.mapper.UserMapper;
import com.wf.service.UserService;
import com.wf.utils.BaseException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

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
            throw new BaseException("该用户不存在！");
        }
        return users;
    }

    @Override
    public int register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        User users = this.getOne(queryWrapper);
        if (null != users) {
            throw new BaseException("用户名已存在！");
        }
        user.setCreateTime(new Date());
        this.save(user);
        return 1;
    }

    @Override
    public List<User> getAll(String[] time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<User> byId = userMapper.getById(time);
        Map<String, String> sevenDate = getSevenDate(time[1]);
        for (User user : byId) {
            sevenDate.put(sdf.format(user.getCreateTime()),user.getLv());
        }
        for (Map.Entry<String, String> entry : sevenDate.entrySet()) {
            System.out.println("Key:"+entry.getKey()+"value:"+entry.getValue());
        }
        return byId;
    }


    public static Map<String,String> getSevenDate(String time) throws ParseException {
        Map<String, String> map = new LinkedHashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(time);
        for (int i = 0; i < 8; i++) {
            Date date = DateUtils.addDays(parse, -i);
            String formatDate = sdf.format(date);
            map.put(formatDate,"0");
        }
        return map;
    }

    @Override
    public void add(String name) {
        User user = new User();
        user.setName(name);
        this.save(user);
    }
}
