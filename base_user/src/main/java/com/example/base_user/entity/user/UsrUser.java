package com.example.base_user.entity.user;

import com.example.base_user.common.mybatis.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Api(value = "用户信息对象")
@Data
@Table(name = "usr_user")
public class UsrUser extends BaseEntity {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 加密用的盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 性别：0无 1男 2女
     */
    @ApiModelProperty(value = "性别：0无 1男 2女")
    private Byte sex;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 用户所在省份ID
     */
    @ApiModelProperty(value = "用户所在省份ID")
    private Integer provinceId;

    /**
     * 用户所在城市ID
     */
    @ApiModelProperty(value = "用户所在城市ID")
    private Integer cityId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除。0-否（默认），1-是
     */
    @ApiModelProperty(value = "是否删除。0-否（默认），1-是")
    private Byte isDeleted;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "用户添加时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:ss:mm", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "用户最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:ss:mm", timezone = "GMT+8")
    private Date updatedTime;

}