package com.example.base_user.service;

import com.example.base_user.common.mybatis.service.BaseService;
import com.example.base_user.entity.user.UsrUser;

/**
 * @author vicky
 * @date 2019/5/27
 */
public interface UsrUserService extends BaseService<UsrUser> {

    /**
     * 根据主键查询
     * @param uid
     * @return
     */
    UsrUser getUserById(Long uid);

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUsrUser(UsrUser user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updatedUsrUser(UsrUser user);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    UsrUser getValidByUsername(String username);
}