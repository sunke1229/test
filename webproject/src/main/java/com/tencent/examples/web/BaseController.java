/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.web;

import com.tencent.bk.api.login.model.BkUser;
import com.tencent.bk.core.BkConsts;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;
import com.tencent.bk.utils.http.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 所有Restful接口都要继承这个父类，保证rest的路径是以/rest开头
 */
@RequestMapping("/rest")
@SuppressWarnings({"unused"})
public abstract class BaseController {

    @Autowired
    protected HttpSession session;


    @Autowired
    protected HttpServletRequest request;


    /**
     * 读取 当前用户
     *
     * @return
     */
    protected BkUser getUser() {
        return FilterUtil.getSessionAttribute(session, BkConsts.USER_SESSION, BkUser.class);
    }

    /**
     * 取当前用户登录态token
     *
     * @return
     */
    protected String getBkToken() {
        return CookieUtil.getCookieValue(request, BkConsts.C_BK_TOKEN);
    }

    /**
     * 取用户设置的语言
     *
     * @return string
     */
    protected String getUserLang() {
        return FilterUtil.getSessionAttribute(session, BkConsts.SYS_LANGUAGE, String.class);
    }

}
