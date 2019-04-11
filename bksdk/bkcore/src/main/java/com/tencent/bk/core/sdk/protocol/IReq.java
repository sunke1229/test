package com.tencent.bk.core.sdk.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

public interface IReq {
    
    void setBkToken(String bkToken);

    void setUserName(String userName);

    void setAppSecret(String appToken);

    void setAppCode(String appCode);

    /**
     * 生成urlParams
     */
    default String toUrlParams() {
        StringBuilder urlString = new StringBuilder(512);
        char c = '?';
        Class<?> aClass = getClass();
        while (aClass != null) {
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {

                String key;
                JsonProperty annotation = field.getAnnotation(JsonProperty.class);
                if (annotation != null) {
                    key = annotation.value();
                } else {
                    key = field.getName();
                }
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                    try {
                        Object b = field.get(this);
                        if (b != null) {
                            urlString.append(c).append(key).append('=').append(urlEncode(b.toString()));
                        }
                    } catch (IllegalAccessException ignored) {
                    } finally {
                        field.setAccessible(false);
                    }
                }
                if (c == '?') {
                    c = '&';
                }
            }
            aClass = aClass.getSuperclass();
        }
        return urlString.toString();
    }


    /**
     * 进行URL编码
     */
    default String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encode failed");
        }
    }

}
