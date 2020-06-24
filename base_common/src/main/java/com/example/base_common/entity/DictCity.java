package com.example.base_common.entity;

import com.example.base_common.common.mybatis.BaseEntity;
import lombok.Data;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Data
public class DictCity extends BaseEntity {

    /**
     * 城市
     */
    private String name;

    /**
     * 省份id，province.id
     */
    private Integer provinceId;

}