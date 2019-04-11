/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.init.filter;

import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.session.web.http.SessionRepositoryFilter;

import java.util.Collection;

/**
 * 统一会话拦截器，配置希望拦截校验会话的请求，保护需要登录态的url即可
 */
@Configuration
public class SessionFilterConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(SessionFilterConfiguration.class);

    @Bean
    @DependsOn("springSessionRepositoryFilter")
    public FilterRegistrationBean mySpringSessionRepositoryFilter(@Qualifier("springSessionRepositoryFilter") SessionRepositoryFilter springSessionRepositoryFilter, BkCoreProperties bkCoreProperties) {
        FilterRegistrationBean sessionRepositoryFilterBean = new FilterRegistrationBean();
        sessionRepositoryFilterBean.setFilter(springSessionRepositoryFilter);
        sessionRepositoryFilterBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        String uriPattern = bkCoreProperties.getAppLoginFilterUriPattern();
        Collection<String> uriPatterns = FilterUtil.parseFilterUriPattern(uriPattern);
        if (uriPatterns != null) {
            sessionRepositoryFilterBean.setUrlPatterns(uriPatterns);
        }
        LOG.info("uriPatterns={}", uriPatterns);
        return sessionRepositoryFilterBean;
    }
}