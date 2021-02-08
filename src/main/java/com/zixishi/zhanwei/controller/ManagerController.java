package com.zixishi.zhanwei.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zixishi.zhanwei.config.authorization.annotation.Authorization;
import com.zixishi.zhanwei.config.authorization.annotation.RequiredPermission;
import com.zixishi.zhanwei.mapper.ManagerMapper;
import com.zixishi.zhanwei.model.Manager;
import com.zixishi.zhanwei.util.Pageable;
import com.zixishi.zhanwei.util.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@Api(tags = "管理员管理")
public class ManagerController {
    @Resource
    private ManagerMapper managerMapper;

    /**
     * 批量删除
     * @param
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

    @Authorization
    @ApiOperation(value = "管理员查询")
    @RequiredPermission("/manager/search")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @PostMapping("/manager/search")
    public RestResult search(@RequestBody JSONObject jsonObject) {
        LinkedHashMap manager = (LinkedHashMap) jsonObject.get("manager");
        Manager m = new Manager();
        String username = (String) manager.get("username");
        Boolean enabled = (Boolean) manager.get("enabled");
        m.setUsername(username);
        m.setEnabled(enabled);

        Integer id = (Integer) jsonObject.get("roleId");
        Long roleId = Long.parseLong(id.toString());

        LinkedHashMap pageable = (LinkedHashMap) jsonObject.get("pageable");
        Pageable p = new Pageable();
        p.setPage((Integer) pageable.get("page"));
        p.setSize((Integer) pageable.get("size"));
        return null;
    }
}
