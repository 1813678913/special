package com.wf.entry;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private long id;

    private String name;

    private String pwd;

    private Date createTime;

}
