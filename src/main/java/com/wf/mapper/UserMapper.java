package com.wf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wf.entry.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getById(@Param("times") String[] time);
}
