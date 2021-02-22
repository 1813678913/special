package com.wf.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private long id;

    private String name;

    private String pwd;
    //权限
    private String lv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String createTimes;

}
