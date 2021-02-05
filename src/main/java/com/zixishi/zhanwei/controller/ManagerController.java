package com.zixishi.zhanwei.controller;

import com.zixishi.zhanwei.config.authorization.annotation.Authorization;
import com.zixishi.zhanwei.mapper.ManagerMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "管理员管理")
public class ManagerController {
    @Resource
    private ManagerMapper managerMapper;

    /**
     * 批量删除
     * @param ids
     */
    @Authorization
    @ApiOperation(value = "批量修改管理员账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @PostMapping("/manager/batchEnabled")
    public void batchEnabled() {
        List<Long> idList = new ArrayList<>();
        idList.add(2L);
        idList.add(3L);
        managerMapper.batchEnabled(idList);
    }
}
