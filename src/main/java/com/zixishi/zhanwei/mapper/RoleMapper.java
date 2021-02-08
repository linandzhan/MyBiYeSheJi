package com.zixishi.zhanwei.mapper;

import com.zixishi.zhanwei.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> search();
}
