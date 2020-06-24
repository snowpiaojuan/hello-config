package com.example.base_user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "usr_user")
public class UsrUser {
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密用的盐
     */
    private String salt;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 性别：0无 1男 2女
     */
    private Byte sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 省份ID
     */
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 城市ID
     */
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 是否删除。0-否（默认），1-是
     */
    @Column(name = "is_deleted")
    private Byte isDeleted;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取加密用的盐
     *
     * @return salt - 加密用的盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密用的盐
     *
     * @param salt 加密用的盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取性别：0无 1男 2女
     *
     * @return sex - 性别：0无 1男 2女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别：0无 1男 2女
     *
     * @param sex 性别：0无 1男 2女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取省份ID
     *
     * @return province_id - 省份ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份ID
     *
     * @param provinceId 省份ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取城市ID
     *
     * @return city_id - 城市ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市ID
     *
     * @param cityId 城市ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取用户备注
     *
     * @return remark - 用户备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置用户备注
     *
     * @param remark 用户备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否删除。0-否（默认），1-是
     *
     * @return is_deleted - 是否删除。0-否（默认），1-是
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除。0-否（默认），1-是
     *
     * @param isDeleted 是否删除。0-否（默认），1-是
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取修改时间
     *
     * @return updated_time - 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}