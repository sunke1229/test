package com.tencent.bk.sdk.web.filter;

import com.tencent.bk.api.login.BKLoginApi;
import com.tencent.bk.core.init.BkCoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class BkAbstractFilter implements Filter {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected BKLoginApi bkLoginApi;

    protected BkCoreProperties bkCoreProperties;

    public BkAbstractFilter(BKLoginApi bkLoginApi, BkCoreProperties bkCoreProperties) {
        this.bkLoginApi = bkLoginApi;
        this.bkCoreProperties = bkCoreProperties;
    }

    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void destroy() {

    }


    /**
     * 重新登录的跳转
     */
    protected void redirectLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // 页面请求直接登录页面
        if (request.getRequestURI().equals("")
                || request.getRequestURI().equals("/")
                || request.getRequestURI().endsWith(".jsp")
                || request.getRequestURI().endsWith(".html")
                || request.getRequestURI().endsWith(".htm")) {
            response.sendRedirect(bkLoginApi.getLoginUrl());
        } else {
            response.setStatus(401);
            response.setHeader("loginUrl", bkLoginApi.getLoginUrl());
        }
        session.invalidate();
    }

}
