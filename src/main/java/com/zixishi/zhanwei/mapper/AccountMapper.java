package com.zixishi.zhanwei.mapper;

import com.zixishi.zhanwei.model.Account;

public interface AccountMapper {
    Account findOne(Long currentUserId);
}
