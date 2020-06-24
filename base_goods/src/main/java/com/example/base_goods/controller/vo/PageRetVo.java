package com.example.base_goods.controller.vo;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @author vicky
 * @date 2019/5/27
 */
public class PageRetVo<T> implements Serializable {

    /**
     * 总记录数
     */
    private Long totalNum;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 数据集
     */
    private List<T> dataResult = new ArrayList<>();

    public PageRetVo(PageInfo<T> pageInfo) {
        this.currentPage = pageInfo.getPageNum();
        this.totalNum = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
        this.dataResult = pageInfo.getList();
    }

    public PageRetVo(Long totalNum, Integer totalPage, Integer currentPage, List<T> dataResult) {
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.dataResult = dataResult;
        this.currentPage = currentPage;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getDataResult() {
        return dataResult;
    }

    public void setDataResult(List<T> dataResult) {
        this.dataResult = dataResult;
    }
}