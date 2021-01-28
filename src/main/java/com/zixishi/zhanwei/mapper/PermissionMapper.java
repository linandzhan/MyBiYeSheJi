package com.zixishi.zhanwei.mapper;

import org.mapstruct.Mapper;

import java.util.Set;
@Mapper
public interface PermissionMapper {
    Boolean findByPath(String path);

    Set<String> findByUser(long id);
}
