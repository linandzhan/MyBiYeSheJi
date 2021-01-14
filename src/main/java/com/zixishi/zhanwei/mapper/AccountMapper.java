package com.zixishi.zhanwei.mapper;

import com.zixishi.zhanwei.model.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    Account findOne(Long id);

    Account findByUsername(String username);
}
