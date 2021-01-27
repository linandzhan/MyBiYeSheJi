package com.zixishi.zhanwei.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Manager {

    private Long id;

    private String name;


    private LocalDateTime createTime;

    private String phone;

    private Boolean enabled;

    private String avator;
}
