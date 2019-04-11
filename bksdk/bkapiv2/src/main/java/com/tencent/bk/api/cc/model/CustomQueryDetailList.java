package com.tencent.bk.api.cc.model;

import lombok.Data;

import java.util.List;

/**
 * {
 *         "count": 1,
 *         "info": [
 *             {
 *                 "bk_biz_id": 1,
 *                 "id": "bacfet4kd42325venmcg",
 *                 "name": "api1",
 *                 "info": "{\"condition\":[{\"bk_obj_id\":\"biz\",\"condition\":[{\"field\":\"default\",\"operator\":\"$ne\",\"value\":1}],\"fields\":[]},{\"bk_obj_id\":\"set\",\"condition\":[],\"fields\":[]},{\"bk_obj_id\":\"module\",\"condition\":[],\"fields\":[]},{\"bk_obj_id\":\"host\",\"condition\":[{\"field\":\"bk_host_innerip\",\"operator\":\"$eq\",\"value\":\"127.0.0.1\"}],\"fields\":[\"bk_host_innerip\",\"bk_host_outerip\",\"bk_agent_status\"]}]}",
 *                 "create_user": "admin",
 *                 "create_time": "2018-03-27T16:22:43.271+08:00",
 *                 "modify_user": "admin",
 *                 "last_time": "2018-03-27T16:29:26.428+08:00"
 *             }
 *         ]
 *  }
 */
@Data
public class CustomQueryDetailList {

    /**
     * 记录条数
     */
    private int count;
    /**
     * 自定义api数据
     */
    private List<CustomQueryDetail> info;

}
