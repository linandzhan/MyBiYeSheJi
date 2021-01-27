package com.zixishi.zhanwei.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    private String username;

    private String phone;

    private String avator;

    private LocalDateTime createTime;

    private String gender;
}
