/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.init;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 蓝鲸关键配置项
 */
@Configuration
@Getter //lombok 会帮助生成getter方法
public class BkCoreProperties {

    /**
     * 生产/测试环境从环境变量 APP_ID 中获取，未设置环境变量(如：本地开发)时，则从配置文件中读取app.id
     */
    @Value("${APP_ID:${app.id}}")
    private String appCode;

    /**
     * 生产/测试环境会先读环境变量APP_TOKEN，，未设置环境变量(如：本地开发)时，则从配置文件中读取app.token
     */
    @Value("${APP_TOKEN:${app.token}}")
    private String appToken;

    /**
     * 蓝鲸智云开发者中心的域名，形如：http://paas.blueking.com
     * 从环境变量BK_PAAS_HOST中获取，未设置环境变量(如：本地开发)时，则从配置文件中读取bk.paas.host
     */
    @Value("${BK_PAAS_HOST:${bk.paas.host}}")
    private String paasHost;

    /**
     * 本服务的访问域名，形如正式的：http://paas.blueking.com/o/bkjava 测试的http://paas.blueking.com/t/bkjava
     * 如果是本地，则可以是http://mydev.blueking.com（配置本地HOST）
     * 读取逻辑是从环境变量BK_PAAS_HOST中获取，未设置环境变量(如：本地开发)时，则从配置文件中读取bk.paas.host，
     * 最后从配置文件中读取bk.context.pre.path
     */
    @Value("${BK_PAAS_HOST:${app.server.host:${bk.paas.host}}}${bk.context.pre.path:}")
    private String appHost;

    /**
     * 静态资源统一存放的路径，默认在static
     */
    @Value("${app.static.prefix:static}")
    private String staticPrefix;

    /**
     * 会话过滤器要过滤的uri pattern
     */
    @Value("${app.filter.login.uri-patterns:/*}")
    private String appLoginFilterUriPattern;

    /**
     * 防CSRF攻击的uri pattern  一般只要保护涉及到数据存取的接口
     */
    @Value("${app.filter.csrf.uri-patterns:/rest/*}")
    private String appCsrfFilterUriPattern;
}
