/*
 * Copyright (c) 2018. Tencent BlueKing
 */

package com.tencent.bk.api.cc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.Api;
import com.tencent.bk.api.cc.model.*;
import com.tencent.bk.api.cc.req.*;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import com.tencent.bk.utils.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 配置平台 API
 * 注意所有接口都有bkToken和userName参数，两个参数用途需要规范
 * bkToken用于web系统引发的接口调用是由当前登录用户触发的行为，一概要求传递bkToken
 * userName用于后台任务执行由系统触发，传递userName，此时没有用户登录态也就没有bkToken
 * 如果bkToken不为空，则优先以bkToken为准
 * <p>
 * 所有结果请根据Resp中的code来决定是否成功
 * <p>
 * 构建请求参数请用
 *
 * @see DefaultSDKClient makeBaseReqByWeb  （当前登录用户触发的行为）
 * @see DefaultSDKClient makeBaseReq    （由后台任务调用的行为）
 */
public class CCApi extends Api {

    /**
     * 新增主机到资源池
     */
    public ApiResp<Void> addHostToResource(AddHostToResourceReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/add_host_to_resource/", esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 新建业务
     */
    public ApiResp<Map<String, Object>> createBusiness(CreateBusinessReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/create_business/", esbReq, new TypeReference<ApiResp<Map<String, Object>>>() {
        });
    }

    /**
     * 添加自定义api
     */
    public ApiResp<Map<String, Object>> createCustomQuery(CreateCustomQueryReq esbReq) {
        if (esbReq.getConditionJson() == null || esbReq.getConditionJson().trim().length() == 0) {
            esbReq.setConditionJson(JsonUtil.toJson(esbReq.getConditions()));
        }
        return invokePost("/api/c/compapi/v2/cc/create_custom_query/", esbReq, new TypeReference<ApiResp<Map<String, Object>>>() {
        });
    }

    /**
     * 新建模块
     */
    public ApiResp<Map<String, Object>> createModule(CreateModuleReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/create_module/", esbReq, new TypeReference<ApiResp<Map<String, Object>>>() {
        });
    }

    /**
     * 创建集群
     */
    public ApiResp<Map<String, Object>> createSet(CreateSetReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/create_set/", esbReq, new TypeReference<ApiResp<Map<String, Object>>>() {
        });
    }

    /**
     * 删除业务
     */
    public ApiResp<Void> deleteBuiness(DeleteBusinessReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/delete_business/", esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 删除自定义api
     */
    public ApiResp<Void> deleteCustomQuery(DeleteBusinessReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/delete_custom_query/", esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 删除主机
     */
    public ApiResp<Void> deleteHost(DeleteHostReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/delete_host/", esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 删除模块
     */
    public ApiResp<Void> deleteModule(DeleteModuleReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/delete_module/", esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 删除集群
     */
    public ApiResp<Void> deleteSet(DeleteSetReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/delete_set/", esbReq, new TypeReference<ApiResp<Void>>() {
        });
    }

    /**
     * 根据自定义api获取数据
     */
    public ApiResp<CommonSearchDataList> getCustomQueryData(GetCustomQueryDataReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/get_custom_query_data/", esbReq,
                new TypeReference<ApiResp<CommonSearchDataList>>() {
                });
    }

    /**
     * 获取自定义api详情
     */
    public ApiResp<CustomQueryDetail> getCustomQueryDetail(GetCustomQueryDetailReq esbReq) {
        ApiResp<CustomQueryDetail> resp = invokePost("/api/c/compapi/v2/cc/get_custom_query_detail/", esbReq,
                new TypeReference<ApiResp<CustomQueryDetail>>() {
                });
        //将info字段解析成填充对象
        if (resp != null && resp.getData() != null) {
            resp.getData().setConditions(JsonUtil.fromJson(resp.getData().getInfo(), CustomQueryConditions.class));
        }
        return resp;
    }

    /**
     * 获取主机基础信息详情
     */
    public ApiResp<List<Property>> getHostBaseInfo(GetHostBaseInfoReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/get_host_base_info/", esbReq,
                new TypeReference<ApiResp<List<Property>>>() {
                });
    }

    /**
     * 查询业务实例拓扑
     */
    public ApiResp<List<ObjectInst>> searchBizInstTopo(SearchBizInstTopoReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/search_biz_inst_topo/", esbReq,
                new TypeReference<ApiResp<List<ObjectInst>>>() {
                });
    }

    /**
     * 查询业务
     */
    public ApiResp<CommonSearchDataList> searchBusiness(SearchBusinessReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/search_business/", esbReq,
                new TypeReference<ApiResp<CommonSearchDataList>>() {
                });
    }

    /**
     * 查询自定义api
     */
    public ApiResp<CustomQueryDetailList> searchCustomQuery(SearchCustomQueryReq esbReq) {
        ApiResp<CustomQueryDetailList> resp = invokePost("/api/c/compapi/v2/cc/search_custom_query/", esbReq,
                new TypeReference<ApiResp<CustomQueryDetailList>>() {
                });
        if (resp != null && resp.getData() != null) {
            if (resp.getData().getInfo() != null) {
                for (CustomQueryDetail customQueryDetail : resp.getData().getInfo()) {
                    CustomQueryConditions conditions = JsonUtil.fromJson(customQueryDetail.getInfo(), CustomQueryConditions.class);
                    customQueryDetail.setConditions(conditions);
                }
            }
        }
        return resp;
    }

    /**
     * 根据条件查询主机
     */
    public ApiResp<CommonSearchDataList> searchHost(SearchHostReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/search_host/", esbReq,
                new TypeReference<ApiResp<CommonSearchDataList>>() {
                });
    }

    /**
     * 查询给定模型的实例信息
     */
    public ApiResp<CommonSearchDataList> searchInstByObject(SearchInstByObjectReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/search_inst_by_object/", esbReq,
                new TypeReference<ApiResp<CommonSearchDataList>>() {
                });
    }

    /**
     * 查询模块
     */
    public ApiResp<CommonSearchDataList> searchModule(SearchModuleReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/search_module/", esbReq,
                new TypeReference<ApiResp<CommonSearchDataList>>() {
                });
    }

    /**
     * 查询集群
     */
    public ApiResp<CommonSearchDataList> searchSet(SearchSetReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/search_set/", esbReq,
                new TypeReference<ApiResp<CommonSearchDataList>>() {
                });
    }

    /**
     * 业务内主机转移模块
     */
    public ApiResp<Void> transferHostModule(TransferHostModule esbReq) {
        return invokePost("/api/c/compapi/v2/cc/transfer_host_module/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 上交主机到业务的故障机模块
     */
    public ApiResp<Void> transferHostToFaultModule(TransferHostToFaultModule esbReq) {
        return invokePost("/api/c/compapi/v2/cc/transfer_host_to_faultmodule/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 上交主机到业务的空闲机模块
     */
    public ApiResp<Void> transferHostToIdleModule(TransferHostToIdleModule esbReq) {
        return invokePost("/api/c/compapi/v2/cc/transfer_host_to_idlemodule/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 上交主机至资源池
     */
    public ApiResp<Void> transferHostToResourceModule(TransferHostToResourceModule esbReq) {
        return invokePost("/api/c/compapi/v2/cc/transfer_host_to_resourcemodule/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 资源池主机分配至业务的空闲机模块
     */
    public ApiResp<Void> transferResourceHostToIdleModule(TransferResourceHostToIdleModule esbReq) {
        return invokePost("/api/c/compapi/v2/cc/transfer_resourcehost_to_idlemodule/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 更新业务信息
     */
    public ApiResp<Void> updateBusiness(UpdateBusinessReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/update_business/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 更新自定义api
     */
    public ApiResp<Void> updateCustomQuery(UpdateCustomQueryReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/update_custom_query/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 更新主机属性
     */
    public ApiResp<Void> updateHost(UpdateHostReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/update_host/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 更新模块
     */
    public ApiResp<Void> updateModule(UpdateModuleReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/update_module/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    /**
     * 更新集群
     */
    public ApiResp<Void> updateSet(UpdateSetReq esbReq) {
        return invokePost("/api/c/compapi/v2/cc/update_set/", esbReq,
                new TypeReference<ApiResp<Void>>() {
                });
    }

    public CCApi(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        super(bkCoreProperties, language);
    }

    @Autowired
    public CCApi(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }

}
