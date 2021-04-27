/*
 * Copyright (c) 2018 Cloud-Star, Inc. All Rights Reserved..
 */

package cn.com.jinkang.module.standard.common.constants;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;


public class BaseGridReturn {

    /**
     * 总数据条数
     */
    private long totalRows;

    /**
     * 显示数据对象
     */
    private Object data;

    /**
     * 显示数据列表
     */
    private List<?> dataList;

    public BaseGridReturn() {
    }

    public BaseGridReturn(long totalRows, List<?> dataList) {
        this.totalRows = totalRows;
        this.dataList = dataList;
    }

    public BaseGridReturn(IPage<?> page) {
        this.totalRows = page.getTotal();
        this.dataList = page.getRecords();
    }

    public BaseGridReturn(com.github.pagehelper.Page<?> page) {
        this.totalRows = page.getTotal();
        this.dataList = page.getResult();
    }

    public BaseGridReturn(Page<?> page, Object data) {
        this.totalRows = page.getTotal();
        this.data = data;
        this.dataList = page.getRecords();
    }

    /**
     * 取得总数据条擿
     *
     * @return 总数据条擿
     */
    public long getTotalRows() {
        return totalRows;
    }

    /**
     * 设置总数据条擿
     */
    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * 取得显示数据列表
     *
     * @return data
     */
    public List<?> getDataList() {
        return dataList;
    }

    /**
     * 设置显示数据列表
     */
    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
