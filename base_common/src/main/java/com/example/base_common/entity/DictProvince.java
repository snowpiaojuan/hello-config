package com.example.base_common.entity;

import com.example.base_common.common.mybatis.BaseEntity;
import lombok.Data;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Data
public class DictProvince extends BaseEntity {

    /**
     * 省份
     */
    private String name;

}