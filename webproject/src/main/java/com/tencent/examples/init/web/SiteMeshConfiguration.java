/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.init.web;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SiteMesh3 装饰器配置，如果不想用SiteMesh3，可以删除后自引入框架。
 */
@Configuration
public class SiteMeshConfiguration {

    /**
     * 定义Filter
     */
    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
        filter.setFilter(siteMeshFilter);
        return filter;
    }

    /**
     * 装饰器过滤器
     */
    public static class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

        @Override
        protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
            builder.addDecoratorPath("/*", "/WEB-INF/layouts/decorator.jsp")//对所有jsp页面进行装饰
                    .addExcludedPath("/static/*")//静态资源忽略
                    .addExcludedPath("/rest/*") //接口请求忽略
                    .addExcludedPath("/*.html") //接口请求忽略
                    ;
        }
    }
}
