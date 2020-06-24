package com.example.base_user.controller.vo;

import lombok.Data;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Data
public class LoginVo {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户ID
     */
    private Long id;

}
