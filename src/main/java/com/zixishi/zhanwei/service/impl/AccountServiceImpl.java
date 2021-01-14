package com.zixishi.zhanwei.service.impl;

import com.zixishi.zhanwei.mapper.AccountMapper;
import com.zixishi.zhanwei.model.Account;
import com.zixishi.zhanwei.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {
        return accountMapper.findByUsername(username);
    }

    @Override
    public Account get(long id) {
        return null;
    }
}
