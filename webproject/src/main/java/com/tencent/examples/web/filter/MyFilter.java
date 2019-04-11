/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.web.filter;

import com.tencent.bk.api.login.BKLoginApi;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.sdk.web.filter.BkAbstractFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 示例过滤器
 * 采用Spring的注解自动初始化这个过滤器，
 * 也可以不用注解而采用像 com.tencent.bk.core.init.bean.CoreBeanConfiguration 那种初始化方式
 */
@Order(3) // 所有业务系统开发的过滤器一定要比bkUserLoginFilter的Order（1） 要高，执行都在之后
@WebFilter(filterName = "myFilter_demo", urlPatterns = {"/*"})
public class MyFilter extends BkAbstractFilter {

    @Autowired
    public MyFilter(BKLoginApi paasClient, BkCoreProperties bkCoreProperties) {
        super(paasClient, bkCoreProperties);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(servletRequest, servletResponse);

        LOG.info("hello world| uri={}", ((HttpServletRequest) servletRequest).getRequestURI());
    }
}
