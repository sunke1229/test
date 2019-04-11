package com.tencent.bk.api.cc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * {
 * "data": [],
 * "exact": 1,
 * "flag": "bk_host_innerip|bk_host_outerip"
 * }
 */
@Data
@AllArgsConstructor
public class IpCondition {
    /**
     * ip 数组
     */
    private List<String> data;
    /**
     * 	是否根据ip精确搜索
     */
    private int exact;
    /**
     * bk_host_innerip只匹配内网ip,
     * bk_host_outerip只匹配外网ip,
     * bk_host_innerip,bk_host_outerip同时匹配
     */
    private String flag;
}
