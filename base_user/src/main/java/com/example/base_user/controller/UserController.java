package com.example.base_user.controller;

import com.example.base_user.common.exception.BizException;
import com.example.base_user.common.rest.MessageCode;
import com.example.base_user.common.rest.ReturnData;
import com.example.base_user.common.utils.Md5Utils;
import com.example.base_user.entity.user.UsrUser;
import com.example.base_user.service.UsrUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vicky
 * @date 22019/5/27
 */
@Api(value = "用户管理API")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UsrUserService usrUserService;

    @ApiOperation(value = "根据用户ID查询用户信息")
    @GetMapping("/{id}")
    public ReturnData findUserById(@PathVariable Long id) {
        UsrUser usrUser = usrUserService.getUserById(id);
        return new ReturnData(usrUser);
    }

    @ApiOperation("新建用户")
    @PostMapping
    public ReturnData insertUser(@RequestBody UsrUser user) throws BizException {
        if(StringUtils.isEmpty(user.getUsername())
                || StringUtils.isEmpty(user.getPassword())){
            throw new BizException(MessageCode.PARAMS_ERROR);
        }

        try{
            String md5Password = Md5Utils.sign(user.getPassword(), null);
            user.setPassword(md5Password);
            usrUserService.insertUsrUser(user);
        }catch (Exception e){
            return new ReturnData(MessageCode.INSERT_FAIL);
        }

        return new ReturnData();
    }

    @ApiOperation("修改用户")
    @PutMapping
    public ReturnData updateUser(@RequestBody UsrUser user) throws BizException {
        if(user.getId() == null || user.getId() == 0){
            throw new BizException(MessageCode.PARAMS_ERROR);
        }

        try{
            if(StringUtils.hasText(user.getPassword())){
                String md5Password = Md5Utils.sign(user.getPassword(), null);
                user.setPassword(md5Password);
            }

            usrUserService.updatedUsrUser(user);
        }catch (Exception e){
            return new ReturnData(MessageCode.INSERT_FAIL);
        }

        return new ReturnData();
    }

    /**
     * 查询用户信息
     * @param username 用户名
     * @return
     */
    @ApiOperation("根据用户名查询用户信息")
    @GetMapping("/getByUsername")
    public ReturnData searchUsrUser( @RequestParam(value = "username", required = false) String username) {

        UsrUser usrUser = usrUserService.getValidByUsername(username);
        return new ReturnData(usrUser);
    }

    @ApiOperation("查询所有用户信息")
    @GetMapping("/list")
    public ReturnData listUsrUser() {
        List<UsrUser> list = usrUserService.selectAll();
        return new ReturnData(list);
    }

}