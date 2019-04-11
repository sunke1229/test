/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.sdk.init;

import com.tencent.bk.api.login.BKLoginApi;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.sdk.web.filter.impl.CsrfFilter;
import com.tencent.bk.sdk.web.filter.impl.LoginFilter;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * 用于创建系统必要的Bean， 不能缺少。
 */
@Configuration
public class CoreBeanConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CoreBeanConfiguration.class);

    /**
     * 创建Paas SDK客户端，一般是用于身份认证使用，在系统中可以注入使用。
     *
     * @param bkCoreProperties 配置对象，通过Spring PropertyConfigure 加载的并通过@Configuration注解自动预置关键核心系统常量
     */
    @Bean
    public BKLoginApi bkLoginApi(@Autowired BkCoreProperties bkCoreProperties) {
        return new BKLoginApi(bkCoreProperties);
    }
    /**
     * 防CSRF攻击保护数据的过滤器，强烈建议开启
     *
     * @param bkLoginApi 依赖PaasClient
     * @param bkCoreProperties   配置对象
     * @return 过滤器
     */
    @Bean
    public FilterRegistrationBean blueKingCsrfFilter(@Autowired BKLoginApi bkLoginApi, @Autowired BkCoreProperties bkCoreProperties) {

        FilterRegistrationBean csrfFilterBean = new FilterRegistrationBean();
        csrfFilterBean.setOrder(0); //设置比会话拦截器1还前，排除恶意的跨站攻击，保护内部系统调用
        csrfFilterBean.setFilter(new CsrfFilter(bkLoginApi, bkCoreProperties));

        String uriPattern = bkCoreProperties.getAppCsrfFilterUriPattern();
        Collection<String> uriPatterns = FilterUtil.parseFilterUriPattern(uriPattern);
        if (uriPatterns != null)
            csrfFilterBean.setUrlPatterns(uriPatterns);
        LOG.info("uriPatterns={}", uriPatterns);

        return csrfFilterBean;
    }

    /**
     * 初始化蓝鲸PaaS平台账户登录过滤器，不可删除，否则无法正常登录
     *
     * @param bkLoginApi 依赖PaasClient
     * @param bkCoreProperties   配置对象
     * @return 过滤器
     */
    @Bean
    public FilterRegistrationBean blueKingUserLoginFilter(@Autowired BKLoginApi bkLoginApi, @Autowired BkCoreProperties bkCoreProperties) {

        FilterRegistrationBean loginFilterBean = new FilterRegistrationBean();
        loginFilterBean.setOrder(1); //这个过滤器一定要在业务系统的其他业务类拦截器的前面，否则可能依赖的User会话对象得不到，这个对象只会在这个过滤器执行
        loginFilterBean.setFilter(new LoginFilter(bkLoginApi, bkCoreProperties));

        String uriPattern = bkCoreProperties.getAppLoginFilterUriPattern();
        Collection<String> uriPatterns = FilterUtil.parseFilterUriPattern(uriPattern);
        if (uriPatterns != null) {
            loginFilterBean.setUrlPatterns(uriPatterns);
        }
        LOG.info("uriPatterns={}", uriPatterns);

        return loginFilterBean;
    }
}
