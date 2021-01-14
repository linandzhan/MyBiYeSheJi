package com.zixishi.zhanwei.mapper;

import java.util.Set;

public interface PermissionMapper {
    Boolean findByPath(String path);

    Set<String> findByUser(long id);
}
