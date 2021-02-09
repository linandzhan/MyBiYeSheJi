package com.zixishi.zhanwei.mapper;

import com.zixishi.zhanwei.model.Manager;
import com.zixishi.zhanwei.util.Pageable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ManagerMapper {
    void batchEnabled(@Param(value = "idList") List<Long> idList);

    List<Manager> search(Long roleId, Manager manager, Pageable pageable);

    Long count(Long roleId, Manager manager, Pageable pageable);

    void disable(Long id);

    void enable(Long id);
}
