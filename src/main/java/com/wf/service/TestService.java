package com.wf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wf.entry.User;

import java.util.List;

public interface TestService extends IService<User> {

    List<User> AllUser(String name);


}
