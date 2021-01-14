package com.zixishi.zhanwei.controller;

import com.zixishi.zhanwei.config.authorization.annotation.Authorization;
import com.zixishi.zhanwei.config.authorization.annotation.CurrentUser;
import com.zixishi.zhanwei.config.authorization.annotation.RequiredPermission;
import com.zixishi.zhanwei.config.authorization.token.TokenManager;
import com.zixishi.zhanwei.config.authorization.token.TokenModel;
import com.zixishi.zhanwei.model.Account;
import com.zixishi.zhanwei.service.AccountService;
import com.zixishi.zhanwei.util.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "账号管理")
public class AccountController {


    @Resource
    private AccountService accountService;
    @Resource
    private TokenManager tokenManager;


    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "登录名"), @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @PostMapping("/account/login")
    public RestResult login(String username,String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        Account account = accountService.findByUsername(username);

        if(account == null && !account.getPassword().equals(password)) {
            return RestResult.error("密码错误或者账号未注册");
        }
        TokenModel model = tokenManager.createToken(account.getId());
        model.setToken(account.getId()+"_"+model.getToken());
        return RestResult.success(model);
    }



    @Authorization
    @ApiOperation(value = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @PostMapping("/account/logout")
    @RequiredPermission("/account/logout")
    public RestResult logout(@CurrentUser Account user) {
        tokenManager.deleteToken(user.getId());
//        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        return RestResult.success("退出成功");
    }



    @Authorization
    @ApiOperation(value = "修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @RequiredPermission("/account/update")
    @PostMapping("/account/update")
    public RestResult update(@CurrentUser Account user) {
        System.out.println(user);
//        tokenManager.deleteToken(user.getId());
//        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        return RestResult.success("修改成功");
    }



    @Authorization
    @ApiOperation(value = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @RequiredPermission("/account/delete")
    @PostMapping("/account/delete")
    public RestResult delete(Account user) {
//        tokenManager.deleteToken(user.getId());
//        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        return RestResult.success("删除成功");
    }

    @Authorization
    @ApiOperation(value = "新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @PostMapping("/account/save")
    @RequiredPermission("/account/save")
    public RestResult save(Account user) {
//        tokenManager.deleteToken(user.getId());
//        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        return RestResult.success("新增成功");
    }


    @Authorization
    @ApiOperation(value = "搜索用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    @RequiredPermission("/account/search")
    @PostMapping("/account/search")
    public RestResult search(Account user) {
//        tokenManager.deleteToken(user.getId());
//        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        return RestResult.success("搜索成功");
    }


}
