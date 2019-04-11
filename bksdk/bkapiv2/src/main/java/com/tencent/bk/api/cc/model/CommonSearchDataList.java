package com.tencent.bk.api.cc.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * CC通用的搜索结果数据列表对象,里面有各种字段或结构，所以用Map
 * {
 *    "count": 1,
 *    "info": [
 *         {
 *            "bk_biz_id": 1,
 *            "bk_biz_name": "esb-test"
 *         },
 *         {
 *             "biz": {
 *                  "bk_biz_id": 1,
 *                  "bk_biz_name": "test",
 *                  "bk_biz_maintainer": "admin",
 *                  "bk_biz_productor": "admin"
 *             },
 *             "host": {
 *                  "bk_host_id": 1,
 *                  "bk_host_name": "nginx-1",
 *                  "bk_host_innerip": "10.0.0.1",
 *                  "bk_cloud_id": 0
 *             },
 *             "module": {
 *                  "bk_module_name": "module-test"
 *             },
 *             "set": {
 *                  "bk_set_name": "set-test"
 *             }
 *        }
 *     ]
 *  }
 */
@Data
public class CommonSearchDataList {

    private int count;

    private List<Map<String, Object>> info;
}
