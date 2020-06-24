package com.example.base_user.common.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author vicky
 * @date 2019/5/27
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnPage {
    /**
     * 当前页
     */
    private Integer curPage;
    /**
     * 每页多少
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long totalRow;
    /**
     * 排序
     */
    private String orderBy;


    public ReturnPage() {
        super();
    }

    /**
     * @param curPage   当前页
     * @param pageSize  每页记录数
     * @param totalPage 总页数
     * @param totalRow  总条数
     */
    public ReturnPage(Integer curPage, Integer pageSize, Integer totalPage, Long totalRow, String orderBy) {
        super();
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRow = totalRow;
        this.orderBy = orderBy;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}