/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.bk.core.sdk.cmdb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.dto.cmdb.*;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.Api;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import com.tencent.bk.core.sdk.cmdb.protocol.*;
import com.tencent.bk.core.sdk.protocol.ESBResp;

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
public class CMDBClient extends Api {

    /**
     * 新增子网ID
     *
     * @return 子网ID
     */
    public ESBResp<Integer> addPlatId(AddPlatIdReq esbReq) {
        return invokePost("/api/c/compapi/cc/add_plat_id/", esbReq,
                new TypeReference<ESBResp<Integer>>() {
                });
    }

    /**
     * 克隆主机属性
     */
    public ESBResp<Void> cloneHostProperty(CloneHostPropertyReq esbReq) {
        return invokePost("/api/c/compapi/cc/clone_host_property/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 删除子网
     */
    public ESBResp<Void> delPlat(DelPlatReq esbReq) {
        return invokePost("/api/c/compapi/cc/del_plat/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 查询业务下Agent状态
     */
    public ESBResp<AppAgentStatusDto> getAppAgentStatus(GetAppAgentStatusReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_app_agent_status/", esbReq,
                new TypeReference<ESBResp<AppAgentStatusDto>>() {
                });
    }

    /**
     * 查询业务信息
     */
    public ESBResp<ApplicationDto> getAppById(GetAppByIdReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_app_by_id/", esbReq,
                new TypeReference<ESBResp<ApplicationDto>>() {
                });
    }

    /**
     * 查询当前指定用户有权限的业务
     */
    public ESBResp<List<ApplicationDto>> getAppByUser(GetAppByUserReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_app_by_user/", esbReq,
                new TypeReference<ESBResp<List<ApplicationDto>>>() {
                });
    }

    /**
     * 根据用户角色查询用户业务 ，注意返回的并不是完整的字段，只有部分字段有内容，详细字段见esb文档
     */
    public ESBResp<List<ApplicationDto>> getAppByRole(GetAppByRoleReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_app_by_user_role/", esbReq,
                new TypeReference<ESBResp<List<ApplicationDto>>>() {
                });
    }

    /**
     * 查询业务主机列表
     */
    public ESBResp<List<HostDto>> getAppHostList(GetAppHostListReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_app_host_list/", esbReq,
                new TypeReference<ESBResp<List<HostDto>>>() {
                });
    }

    /**
     * 查询业务列表
     */
    public ESBResp<List<ApplicationDto>> getAppList(GetAppListReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_app_list/", esbReq,
                new TypeReference<ESBResp<List<ApplicationDto>>>() {
                });
    }

    /**
     * 根据开发商ID、子网ID、主机IP获取主机信息， 注意返回的并不是完整的字段，只有部分字段有内容，详细字段见esb文档
     */
    public ESBResp<List<HostDto>> getHostByCompanyId(GetHostByCompanyIdReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_host_by_company_id/", esbReq,
                new TypeReference<ESBResp<List<HostDto>>>() {
                });
    }

    /**
     * 获取主机开发商
     */
    public ESBResp<Map<String, Map<String, CompanyDto>>> getHostCompanyId(GetHostCompanyIdReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_host_company_id/", esbReq,
                new TypeReference<ESBResp<Map<String, Map<String, CompanyDto>>>>() {
                });
    }

    /**
     * 根据主机属性的值group主机列表，注意返回的并不是完整的字段，只有部分字段有内容，详细字段见esb文档
     */
    public ESBResp<Map<String, List<HostDto>>> getHostListByField(GetHostListByFieldReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_host_list_by_field/", esbReq,
                new TypeReference<ESBResp<Map<String, List<HostDto>>>>() {
                });
    }

    /**
     * 根据IP查询主机信息
     */
    public ESBResp<Map<String, List<HostDto>>> getHostListByIp(GetHostListByIpReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_host_list_by_ip/", esbReq,
                new TypeReference<ESBResp<Map<String, List<HostDto>>>>() {
                });
    }

    /**
     * 根据 set 属性查询主机，注意返回的并不是完整的字段，只有部分字段有内容，详细字段见esb文档
     */
    public ESBResp<List<HostDto>> getHostsByProperty(GetHostsByPropertyReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_hosts_by_property/", esbReq,
                new TypeReference<ESBResp<List<HostDto>>>() {
                });
    }

    /**
     * 查询业务下IP及ProxyIP
     */
    public ESBResp<GetIpAndProxyDto> getIpAndProxyByCompany(GetIpAndProxyByCompany esbReq) {
        return invokeGet("/api/c/compapi/cc/get_ip_and_proxy_by_company/", esbReq,
                new TypeReference<ESBResp<GetIpAndProxyDto>>() {
                });
    }

    /**
     * 查询模块主机列表
     */
    public ESBResp<List<HostDto>> getModuleHostList(GetModuleHostListReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_module_host_list/", esbReq,
                new TypeReference<ESBResp<List<HostDto>>>() {
                });
    }

    /**
     * 查询业务下的所有模块
     */
    public ESBResp<List<String>> getModules(GetModulesReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_modules/", esbReq,
                new TypeReference<ESBResp<List<String>>>() {
                });
    }

    /**
     * 根据 set 属性查询模块
     */
    public ESBResp<List<String>> getModulesByProperty(GetModulesByPropertyReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_modules_by_property/", esbReq,
                new TypeReference<ESBResp<List<String>>>() {
                });
    }

    /**
     * 查询子网列表
     */
    public ESBResp<List<PlatDto>> getPlatId(GetPlatIdReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_plat_id/", esbReq,
                new TypeReference<ESBResp<List<PlatDto>>>() {
                });
    }

    /**
     * 查询进程端口
     */
    public ESBResp<List<ProcessDto>> getProcessPortByAppId(GetProcessPortByAppIdReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_process_port_by_app_id/", esbReq,
                new TypeReference<ESBResp<List<ProcessDto>>>() {
                });
    }

    /**
     * 查询属性列表
     */
    public ESBResp<List<Map<String, HostDto>>> getPropertyList(GetPropertyListReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_property_list/", esbReq,
                new TypeReference<ESBResp<List<Map<String, HostDto>>>>() {
                });
    }

    /**
     * 查询Set主机列表
     */
    public ESBResp<List<HostDto>> getSetHostList(GetSetHostListReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_set_host_list/", esbReq,
                new TypeReference<ESBResp<List<HostDto>>>() {
                });
    }

    /**
     * 获取所有 set 属性
     */
    public ESBResp<Map<String, List<PropertyValueDto>>> getSetProperty(GetSetPropertyReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_set_property/", esbReq,
                new TypeReference<ESBResp<Map<String, List<PropertyValueDto>>>>() {
                });
    }

    /**
     * 根据 set 属性获取 set
     */
    public ESBResp<List<Map<String, Object>>> getSetsByProperty(GetSetsByPropertyReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_sets_by_property/", esbReq,
                new TypeReference<ESBResp<List<Map<String, Object>>>>() {
                });
    }

    /**
     * 查询业务拓扑树
     */
    public ESBResp<TopoTreeDto> getTopoTreeByAppId(GetTopoTreeByAppIdReq esbReq) {
        return invokeGet("/api/c/compapi/cc/get_topo_tree_by_app_id/", esbReq,
                new TypeReference<ESBResp<TopoTreeDto>>() {
                });
    }

    /**
     * 更新主机gse agent proxy 状态
     */
    public ESBResp<Void> updateGseProxyStatus(UpdateGseProxyStatusReq esbReq) {
        return invokePost("/api/c/compapi/cc/update_gse_proxy_status/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 更新主机的gse agent状态
     */
    public ESBResp<Void> updateHostByAppId(UpdateHostByAppIdReq esbReq) {
        return invokePost("/api/c/compapi/cc/update_host_by_app_id/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 修改主机模块
     */
    public ESBResp<Void> updateHostModule(UpdateHostModuleReq esbReq) {
        return invokePost("/api/c/compapi/cc/update_host_module/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    /**
     * 更新主机云子网
     */
    public ESBResp<Void> updateHostPlat(UpdateHostPlatReq esbReq) {
        return invokePost("/api/c/compapi/cc/update_host_plat/", esbReq,
                new TypeReference<ESBResp<Void>>() {
                });
    }

    public CMDBClient(BkCoreProperties bkCoreProperties) {
        super(bkCoreProperties, BkEnum.Lang.chinese);
    }
}
