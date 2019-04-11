package com.tencent.bk.api.cc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {
 *         "bk_biz_id": 1,
 *         "name": "api1",
 *         "id": "bacfet4kd42325venmcg",
 *         "info": "{\"condition\":[{\"bk_obj_id\":\"biz\",\"condition\":[{\"field\":\"default\",\"operator\":\"$ne\",\"value\":1}],\"fields\":[]},{\"bk_obj_id\":\"set\",\"condition\":[],\"fields\":[]},{\"bk_obj_id\":\"module\",\"condition\":[],\"fields\":[]},{\"bk_obj_id\":\"host\",\"condition\":[{\"field\":\"bk_host_innerip\",\"operator\":\"$eq\",\"value\":\"127.0.0.1\"}],\"fields\":[\"bk_host_innerip\",\"bk_host_outerip\",\"bk_agent_status\"]}]}",
 *         "create_user": "admin",
 *         "create_time": "2018-03-27T16:22:43.271+08:00",
 *         "modify_user": "admin",
 *         "last_time": "2018-03-27T16:29:26.428+08:00"
 *     }
 */
@Data
public class CustomQueryDetail {
    /**
     * 业务ID
     */
    @JsonProperty("bk_biz_id")
    private int bkBizId;
    /**
     * 	自定义api命名
     */
    private String name;
    /**
     * 	自定义api主键ID
     */
    private String id;
    /**
     * 	创建者
     */
    @JsonProperty("create_user")
    private String creator;
    /**
     * 	创建时间
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 修改者
     */
    @JsonProperty("modify_user")
    private String modifyUser;
    /**
     * 	更新时间
     */
    @JsonProperty("last_time")
    private String lastModifyTime;
    /**
     *  注意：此字段在返回后会将 info字段自定义api信息转换并填充到该对象,方便用户使用
     */
    private CustomQueryConditions conditions;
    /**
     * 自定义api信息
     */
    private String info;

}
