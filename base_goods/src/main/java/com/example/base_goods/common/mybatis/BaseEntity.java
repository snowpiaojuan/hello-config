package com.example.base_goods.common.mybatis;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Data
public abstract class BaseEntity {

    @Id
    private Long id;

}