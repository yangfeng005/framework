package com.jp.framework.common.util;

import java.io.Serializable;

/**
 * @author xingyu.lu
 * @create 2018-03-22 09:33
 **/
public class Page<T> implements Serializable {
    private static final long serialVersionUID = -5315029048023321610L;
    //当前页
    private Integer pageNo;
    //页面大小
    private Integer pageSize;
    //总页数
    private Integer totalPages;
    //总条数
    private Long total;

    public static <T> Page<T> obtainPage(com.github.pagehelper.PageInfo page) {
        Page<T> paging = new Page<>();
        paging.setPageNo(page.getPageNum())
                .setPageSize(page.getPageSize())
                .setTotalPages(page.getPages())
                .setTotal(page.getTotal());
        return paging;
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public Page setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Page setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Page setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public Page setTotal(Long total) {
        this.total = total;
        return this;
    }
}
