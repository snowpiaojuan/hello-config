package com.example.base_common.common.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper,不能被扫描到
 * @author vicky
 * @date 2019/5/27
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
