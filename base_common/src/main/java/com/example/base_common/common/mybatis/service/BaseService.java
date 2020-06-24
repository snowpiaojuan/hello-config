package com.example.base_common.common.mybatis.service;

import com.example.base_common.common.mybatis.BaseEntity;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @param <T>
 * @author vicky
 * @date 2019/5/27
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 根据主键ID查询
     * @param id
     * @return
     */
    T selectById(Long id);

    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();

    /**
     * 条件查询
     * @param t
     * @return
     */
    List<T> selectByWhere(T t);

    /**
     * 根据条件查询一条数据
     * @param t
     * @return
     */
    T selectOne(T t);

    /**
     * 根据Example查询
     * @param example
     * @return
     */
    List<T> selectByExample(Example example);

    /**
     * 根据条件分页查询
     * @param t        T
     * @param pageNo     当前页数
     * @param pageSize 每页显示条数
     * @return PageInfo
     */
    PageInfo<T> selectByWhere(T t, int pageNo, int pageSize);

    /**
     * 根据Example分页查询
     * @param t          example对象
     * @param pageNo     当前页数
     * @param pageSize 每页显示条数
     * @return PageInfo
     */
    PageInfo<T> selectByWhere(Example t, int pageNo, int pageSize);

    /**
     * 分页查询所有
     * @param pageNo     当前页数
     * @param pageSize 每页显示条数
     * @return PageInfo
     */
    PageInfo<T> selectByPage(int pageNo, int pageSize);

    /**
     * 新增数据（所有数据）
     * @param t
     * @return
     */
    Integer insert(T t);

    /**
     *  新增数据（null的属性不会保存,保存对象时某个属性不赋值,即不保存数据库该字段）
     * @param t
     * @return
     */
    Integer insertSelective(T t);

    /**
     * 主键更新数据
     * @param t
     * @return
     */
    Integer updated(T t);

    /**
     * 主键更新数据（null的属性不会保存 ,更新对象时某个属性不赋值,即不更改数据库该字段）
     * @param t
     * @return
     */
    Integer updatedSelective(T t);

    /**
     * 自定义example更新数据
     * @param t
     * @param example
     * @return
     */
    Integer updatedByExampleSelective(T t, Example example);

    /**
     * 根据主键id删除数据
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * 批量删除
     * @param ids 要删除的字段的值集合
     * @param property 要删除的字段的属性
     * @param clazz
     * @return
     */
    Integer deleteByIds(List<Object> ids, String property, Class<T> clazz);

    /**
     * 根据对象删除
     * @param t
     * @return
     */
    Integer delete(T t);

    /**
     * 根据Example删除
     * @param example
     * @return
     */
    Integer deleteByExample(Example example);

    /**
     * 根据对象统计
     * @param t
     * @return
     */
    int count(T t);
}
