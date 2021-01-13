package com.zixishi.zhanwei.service;

import com.zixishi.zhanwei.model.Account;

public interface AccountService {
    Account findByUsername(String username);
}
