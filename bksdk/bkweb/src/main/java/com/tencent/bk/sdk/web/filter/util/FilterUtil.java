/*
 * Tencent Copyright (c) 2016.
 */

package com.tencent.bk.sdk.web.filter.util;

import com.google.common.collect.Lists;
import com.tencent.bk.core.BkConsts;
import com.tencent.bk.utils.bean.BeanUtil;
import com.tencent.bk.utils.http.CookieUtil;
import com.tencent.bk.utils.id.IDUtil;
import com.tencent.bk.utils.json.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collection;

/**
 * 过滤器/servlet等的工具类
 */
public class FilterUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FilterUtil.class);

    /**
     * 解析 uri pattern 字符串并返回列表 例如 /index.jsp,/info/*,/api/*
     * 返回集合 ["/index.jsp","/info/*","/api/*"]
     * 如果是空的，则返回空
     */
    public static Collection<String> parseFilterUriPattern(String uriPattern) {
        if (uriPattern == null || (uriPattern = uriPattern.trim()).length() == 0) {
            return Lists.newArrayList();
        }
        Collection<String> uriPatterns;
        if (uriPattern.contains(",")) {//用,分隔
            String[] split = StringUtils.split(uriPattern, ",");
            for (int i = 0; i < split.length; i++) {
                split[i] = StringUtils.trim(split[i]);
            }
            uriPatterns = Arrays.asList(split);
        } else if (uriPattern.contains(";")) { //用;号分隔
            String[] split = StringUtils.split(uriPattern, ";");
            for (int i = 0; i < split.length; i++) {
                split[i] = StringUtils.trim(split[i]);
            }
            uriPatterns = Arrays.asList(split);
        } else {
            uriPatterns = Lists.newArrayList(uriPattern);
        }
        return uriPatterns;
    }

    /**
     * 防CSRF攻击的判定
     */
    public static boolean checkCsrfKey(HttpServletRequest httpRequest, HttpSession httpSession) {

        String token = (String) httpSession.getAttribute(BkConsts.X_CSRF_KEY);
        if (StringUtils.isBlank(token)) {
            LOG.warn("session token is null| sid={}", httpSession.getId());
            return false;
        } else {
            String reqToken = httpRequest.getHeader(BkConsts.X_CSRF_KEY); // 取头tk:xyz
            if (!StringUtils.equals(token, reqToken)) {
                // 可能的csrf攻击，拒绝请求
                LOG.warn("token not equal| reqToken={}| sesToken={}| sid={}", reqToken, token, httpSession.getId());
                return false;
            }
        }
        return true;
    }

    /**
     * 初始化Csrf信息
     */
    public static void initCsrf(HttpServletRequest httpRequest, HttpServletResponse httpResponse, HttpSession httpSession) {
        String sKey = CookieUtil.getCookieValue(httpRequest, BkConsts.CSRF_KEY);
        if (StringUtils.isBlank(sKey)) {
            sKey = String.valueOf(csrfHashCode(IDUtil.uuid()));
            CookieUtil.addToCookie(httpResponse, BkConsts.CSRF_KEY, sKey, 7200);
        }
        httpSession.setAttribute(BkConsts.X_CSRF_KEY, sKey);
    }


    /**
     * JS脚本Hash算法
     * function(str) {
     * var hash = 8888;
     * for (var i = 0, len = str.length; i < len; ++i) hash += (hash << 5) + str.charCodeAt(i);
     * return hash & 0x7fffffff;
     * }
     */
    private static int csrfHashCode(String skey) {
        int hashCode = 8888;
        for (int i = 0; i < skey.length(); i++) {
            hashCode += (hashCode << 5) + skey.charAt(i);
        }
        return hashCode & 0x7fffffff;
    }

    /**
     * 从Session中获取指定name的指定类型的value值
     *
     * @param key    key
     * @param tClass value值类型类
     * @param <T>    类型泛型
     * @return 指定类型的值
     */
    @SuppressWarnings("unchecked")
    public static <T> T getSessionAttribute(HttpSession session, String key, Class<T> tClass) {
        Object attribute = session.getAttribute(key);
        try {
            if (attribute == null) {
                return null;
            }
            if (attribute.getClass().isAssignableFrom(tClass)) {
                return (T) attribute;
            } else if (attribute instanceof String) {
                return JsonUtil.fromJson((String) attribute, tClass);
            } else {
                return BeanUtil.map(attribute, tClass);
            }
        } catch (Throwable e) {
            return null;
        }
    }
}
