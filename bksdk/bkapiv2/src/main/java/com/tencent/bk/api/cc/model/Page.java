package com.tencent.bk.api.cc.model;

import lombok.Data;

@Data
public class Page {

    /**
     * 记录开始位置
     */
    private int start;
    /**
     * 每页限制条数,最大200
     */
    private int limit;
    /**
     * 排序字段，通过在字段前面增加 -，如 "-field" 可以表示按照字段 field降序
     */
    private String sort;
}
