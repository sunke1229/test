/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.utils.http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 */
public class CookieUtil {

    /**
     * 读取Cookie指定key的值
     *
     * @param request HttpServletRequest
     * @param key Cookie Key
     * @return Cookie Value
     */
    public static String getCookieValue(HttpServletRequest request, String key) {
        String value = null;

        // cookie数组
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    value = cookie.getValue();
                    break;
                }
            }
        }

        if (null == value) {
            // Cookie属性中没有获取到，那么从Headers里面获取
            String cookieStr = request.getHeader("Cookie");
            if (cookieStr != null) {
                // 去掉所有空白字符，不限于空格
                cookieStr = cookieStr.replaceAll("\\s*", "");
                String[] cookieArr = cookieStr.split(";");

                for (String cookieItem : cookieArr) {
                    String[] cookieItemArr = cookieItem.split("=");
                    if (cookieItemArr[0].equals(key)) {
                        value = cookieItemArr[1];
                        break;
                    }
                }
            }
        }
        return value;
    }

    /**
     * 将指定key，value设置到Cookie，并设置domain为子域名共享Cookie，以及HttpOnly=false
     * @param httpResponse httpResponse
     * @param key   Cookie Key
     * @param value Cookie Value
     * @param expirySeconds 不活跃状态多少秒后过期
     */
    public static void addToCookie(HttpServletResponse httpResponse, String key, String value, int expirySeconds) {
        Cookie cookie = new Cookie(key, value);
        cookie.setHttpOnly(false);
        cookie.setMaxAge(expirySeconds);
        httpResponse.addCookie(cookie);
    }
}
