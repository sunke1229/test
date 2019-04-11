/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.sdk.web.filter.impl;

import com.google.common.collect.Lists;
import com.tencent.bk.api.login.BKLoginApi;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.sdk.init.CoreBeanConfiguration;
import com.tencent.bk.sdk.web.filter.BkAbstractFilter;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * <b>
 * 重要：蓝鲸业务系统用户防跨站攻击过滤器，建议使用，避免被攻击
 * </b>
 * <p>
 * 注意：此为蓝鲸框架的核心类，后续会随着PaaS升级而需要做适当的逻辑代码升级
 * 所以不要在这里修改代码扩展自己的业务过滤逻辑，否则到时升级时 用户修改的代码也要再迁移一次，
 * 所以建议用户自己去实现自己的业务Filter，此类用下面的配置方式引入即可。
 * </p>
 * <p>
 * 配置方式，见
 *
 * @see CoreBeanConfiguration
 * <p>
 */
public class CsrfFilter extends BkAbstractFilter {

    public CsrfFilter(BKLoginApi bkLoginApi, BkCoreProperties bkCoreProperties) {
        super(bkLoginApi, bkCoreProperties);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String requestUri = request.getRequestURI();

        boolean safe = true;
        try {
            synchronized (session.getId().intern()) {
                // 首页访问,初始化处理
                if (requestUri.equals("/")) {
                    FilterUtil.initCsrf(request, response, session);
                    //GET|HEAD|OPTIONS|TRACE
                } else if (method(request.getMethod()) && !(safe = FilterUtil.checkCsrfKey(request, session))){
                    redirectLogin(request, response, session);
                    return;
                }
            }

            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            LOG.error("login failed| uri=" + requestUri, e);
            redirectLogin(request, response, session);
        } finally {
            LOG.info("CSRF_Filter| uri={}| safe={}", requestUri, safe);
        }
    }

    private List<String> methodPass = Lists.newArrayList("GET", "HEAD", "OPTIONS", "TRACE");

    private boolean method(String method) {
        return !methodPass.contains(method);
    }

}
