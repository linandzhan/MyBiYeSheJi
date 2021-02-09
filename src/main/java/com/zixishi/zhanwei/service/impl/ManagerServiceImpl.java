package com.zixishi.zhanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.zixishi.zhanwei.dto.ListDTO;
import com.zixishi.zhanwei.mapper.ManagerMapper;
import com.zixishi.zhanwei.model.Manager;
import com.zixishi.zhanwei.service.ManagerService;
import com.zixishi.zhanwei.util.Pageable;
import com.zixishi.zhanwei.util.RestResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    ManagerMapper managerMapper;


    @Override
    public RestResult search(Long roleId, Manager manager, Pageable pageable) {
        if(manager.getEnabled() != null) {
            System.out.println("sss");
        }
        //需要用分页插件，进行分页查询
        List<Manager> list =  PageHelper.startPage(pageable.getPage(),pageable.getSize()).doSelectPage(()->managerMapper.search(roleId, manager, pageable));
        Long total = managerMapper.count(roleId, manager, pageable);
        ListDTO listDTO = new ListDTO();
        listDTO.setItems(list);
        listDTO.setTotal(total);
        return RestResult.success(listDTO);
    }
}
