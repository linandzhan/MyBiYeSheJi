package com.zixishi.zhanwei.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ManagerMapper {
    void batchEnabled(@Param(value = "idList") List<Long> idList);
}
