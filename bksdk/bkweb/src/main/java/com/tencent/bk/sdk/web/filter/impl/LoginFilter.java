/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.sdk.web.filter.impl;

import com.tencent.bk.api.login.BKLoginApi;
import com.tencent.bk.api.login.model.BkUser;
import com.tencent.bk.api.protocol.ApiReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkConsts;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.sdk.init.CoreBeanConfiguration;
import com.tencent.bk.sdk.web.filter.BkAbstractFilter;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;
import com.tencent.bk.utils.base.BoolUtil;
import com.tencent.bk.utils.http.CookieUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <b>
 * 重要：蓝鲸业务系统用户鉴权过滤器，必须通过配置引入拦截系统核心的请求做鉴权用,并且顺序要在最前面Order=1
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
public class LoginFilter extends BkAbstractFilter {

    public LoginFilter(BKLoginApi paasClient, BkCoreProperties bkCoreProperties) {
        super(paasClient, bkCoreProperties);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String requestUri = request.getRequestURI();

        try {
            //token校验
            String bkToken = CookieUtil.getCookieValue(request, BkConsts.C_BK_TOKEN);
            if (StringUtils.isBlank(bkToken)) {
                redirectLogin(request, response, session);
                return;
            }

            //此处不做缓存，每次都向paas请求鉴权
            ApiResp<BkUser> esbResp = bkLoginApi.getUserInfo(bkLoginApi.makeBaseReqByWeb(ApiReq.class, request));
            if (esbResp == null) {
                redirectLogin(request, response, session);
                return;
            }
            if (!BoolUtil.isTrue(esbResp.getResult()) || esbResp.getCode() != 0 || esbResp.getData() == null) {
                redirectLogin(request, response, session);
                return;
            }

            BkUser bkUserDto = esbResp.getData();

            // 解决IE中iFrame里跨域的sessionid丢失问题
            response.addHeader("P3P", "CP=CAO PSA OUR");
            // 用户身份认证通过
            // 如果会话中的信息与当前认证的不相同 ，则更新会话信息。
            if (!StringUtils.equals((String) session.getAttribute(BkConsts.C_BK_TOKEN), bkToken)) {
                //将用户信息写入会话中
                FilterUtil.initCsrf(request, response, session); //防csrf
                session.setAttribute(BkConsts.C_BK_TOKEN, bkToken);
                session.setAttribute(BkConsts.USER_SESSION, bkUserDto);
                session.setAttribute(BkConsts.STATIC_VERSION, System.currentTimeMillis());
                session.setAttribute(BkConsts.APP_ID, bkCoreProperties.getAppCode());
                String appHost = bkCoreProperties.getAppHost().trim();
                String siteUrl = appHost + (appHost.endsWith("/") ? "" : "/");
                session.setAttribute(BkConsts.SITE_URL, siteUrl);
                String staticUrl = siteUrl + bkCoreProperties.getStaticPrefix() + (bkCoreProperties.getStaticPrefix().endsWith("/") ? "" : "/");
                session.setAttribute(BkConsts.STATIC_URL, staticUrl);
                session.setAttribute(BkConsts.BK_PAAS_HOST, bkCoreProperties.getPaasHost());
            }

            LOG.info("login success| uri={}| userName={}", requestUri, bkUserDto.getUsername());
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            LOG.error("login failed| uri=" + requestUri, e);
            redirectLogin(request, response, session);
        }
    }

}
