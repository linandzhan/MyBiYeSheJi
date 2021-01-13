package com.zixishi.zhanwei.controller;

import com.zixishi.zhanwei.config.authorization.annotation.Authorization;
import com.zixishi.zhanwei.config.authorization.token.TokenManager;
import com.zixishi.zhanwei.config.authorization.token.TokenModel;
import com.zixishi.zhanwei.model.Account;
import com.zixishi.zhanwei.service.AccountService;
import com.zixishi.zhanwei.util.RestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {


    @Resource
    private AccountService accountService;
    @Resource
    private TokenManager tokenManager;


    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "登录名"), @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @PostMapping("/employee/login")
    public RestResult login(String username,String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        Account account = accountService.findByUsername(username);

        if(account == null && !account.getPassword().equals(password)) {
            return RestResult.error("密码错误或者账号未注册");
        }
        TokenModel model = tokenManager.createToken(account.getId());
        return RestResult.success(model);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    @ApiOperation(value = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public RestResult logout(Account user) {
//        tokenManager.deleteToken(user.getId());
//        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        return null;
    }

}
