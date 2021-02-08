package com.zixishi.zhanwei.controller;

import com.zixishi.zhanwei.config.authorization.annotation.Authorization;
import com.zixishi.zhanwei.mapper.RoleMapper;
import com.zixishi.zhanwei.model.Role;
import com.zixishi.zhanwei.util.RestResult;
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
@Api(tags = "角色管理")
public class RoleController {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 角色列表查询
     * @return
     */
    @Authorization
    @ApiOperation(value = "角色查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @PostMapping("/role/search")
    public RestResult search() {
        List<Role> roles = roleMapper.search();
        return RestResult.success(roles);
    }

}
