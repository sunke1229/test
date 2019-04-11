package com.tencent.bk.api.cc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 查询条件
 */
@Data
@AllArgsConstructor
public class Condition {
    /**
     * 对象的字段
     */
    private String field;
    /**
     * 操作符, $eq为相等，$neq为不等，$in为属于，$nin为不属于
     */
    private String operator;
    /**
     * 字段对应的值
     */
    private Object value;
}