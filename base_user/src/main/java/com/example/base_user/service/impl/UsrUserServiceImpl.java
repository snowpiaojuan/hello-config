package com.example.base_user.service.impl;

import com.example.base_user.common.constants.Constants;
import com.example.base_user.common.mybatis.service.impl.BaseServiceImpl;
import com.example.base_user.entity.user.UsrUser;
import com.example.base_user.mapper.UsrUserMapper;
import com.example.base_user.service.UsrUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Service
public class UsrUserServiceImpl extends BaseServiceImpl<UsrUser> implements UsrUserService {

    @Autowired
    private UsrUserMapper usrUserMapper;

    /**
     * 根据主键查询
     * @param uid
     * @return
     */
    @Override
    public UsrUser getUserById(Long uid){
        return this.selectById(uid);
    }

    /**
     * 插入用户
     * @param user
     * @return
     */
    @Override
    public int insertUsrUser(UsrUser user){
       return this.insertSelective(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public int updatedUsrUser(UsrUser user){
        return this.updatedSelective(user);
    }

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    @Override
    public UsrUser getValidByUsername(String username) {
        UsrUser usrUser = new UsrUser();
        usrUser.setUsername(username);
        usrUser.setIsDeleted(Constants.NO);
        return this.selectOne(usrUser);
    }

}