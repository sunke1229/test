/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk;

import com.tencent.bk.core.BkConsts;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.protocol.IReq;
import com.tencent.bk.utils.http.CookieUtil;
import com.tencent.bk.utils.http.HttpConPoolUtil;
import com.tencent.bk.utils.json.JsonUtil;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static com.tencent.bk.core.BkConsts.HDR_BK_LANG;
import static com.tencent.bk.core.BkConsts.HDR_CONTENT_TYPE;

/**
 * 所有SDK的抽象类
 * 注意所有接口都有bkToken和userName参数，两个参数用途需要规范
 * bkToken用于web系统引发的接口调用是由当前登录用户触发的行为，一概要求传递bkToken
 * userName用于后台任务执行由系统触发，传递userName，此时没有用户登录态也就没有bkToken
 * 如果bkToken不为空，则优先以bkToken为准
 * <p>
 * 构建请求参数请用
 *
 * @see DefaultSDKClient makeBaseReqByWeb  （当前登录用户触发的行为）
 * @see DefaultSDKClient makeBaseReq    （由后台任务调用的行为）
 */
public abstract class DefaultSDKClient implements SDKClient {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected BkCoreProperties bkCoreProperties;

    private final BkEnum.Lang language;

    public DefaultSDKClient(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        this.bkCoreProperties = bkCoreProperties;
        this.language = language;
    }

    /**
     * 生成通过Web界面发过来的生成SDK调用请求构造协议基础参数
     *
     * @param reqClass 要构建返回的协议Req类
     * @param request  httpRequest对象
     * @param <T>      泛型
     * @return 如果指定的协议请求Req类有问题，请返回null
     */
    public <T extends IReq> T makeBaseReqByWeb(Class<T> reqClass, HttpServletRequest request) {
        String bkToken = CookieUtil.getCookieValue(request, BkConsts.C_BK_TOKEN);
        T esbReq = null;
        try {
            esbReq = reqClass.newInstance();
            esbReq.setBkToken(bkToken);
            esbReq.setAppCode(bkCoreProperties.getAppCode());
            esbReq.setAppSecret(bkCoreProperties.getAppToken());
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error("makeWebReq fail", e);
        }
        return esbReq;
    }

    /**
     * 针对无登录态的SDK调用请求，构建协议请求Req类基础参数
     *
     * @param reqClass 要构建返回的协议Req类
     * @param userName 要调用的身份用户名
     * @param <T>      泛型
     * @return 如果指定的协议请求Req类有问题，请返回null
     */
    public <T extends IReq> T makeBaseReq(Class<T> reqClass, String userName) {
        T esbReq = null;
        try {
            esbReq = reqClass.newInstance();
            esbReq.setUserName(userName);
            esbReq.setAppCode(bkCoreProperties.getAppCode());
            esbReq.setAppSecret(bkCoreProperties.getAppToken());
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error("makeWebReq fail", e);
        }
        return esbReq;
    }

    /**
     * 进行URL编码
     *
     * @param str str
     */
    protected String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encode failed");
        }
    }

    @SuppressWarnings("all")
    protected String urlDecode(String encodeStr) {
        try {
            return URLDecoder.decode(encodeStr, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decode failed");
        }
    }

    protected String doHttpGet(String uri, IReq params) throws IOException {
        long start = System.currentTimeMillis();
        String url;
        if (!bkCoreProperties.getPaasHost().endsWith("/") && !uri.startsWith("/")) {
            url = bkCoreProperties.getPaasHost() + "/" + uri + params.toUrlParams();
        } else {
            url = bkCoreProperties.getPaasHost() + uri + params.toUrlParams();
        }
        Header[] header = new Header[1] ;
        header[0] = new BasicHeader(HDR_BK_LANG, language.name);
        String responseBody = HttpConPoolUtil.get(url, header);
        LOG.info("doHttpGet| url={}| params={}| time={}| resp={}", uri, params, (System.currentTimeMillis() - start), responseBody);
        return responseBody;
    }

    protected <T extends IReq> String doHttpPost(String uri, T params) throws Exception {
        long start = System.currentTimeMillis();
        String url;
        if (!bkCoreProperties.getPaasHost().endsWith("/") && !uri.startsWith("/")) {
            url = bkCoreProperties.getPaasHost() + "/" + uri;
        } else {
            url = bkCoreProperties.getPaasHost() + uri;
        }
        Header[] header = new Header[2] ;
        header[0] = new BasicHeader(HDR_BK_LANG, language.name);
        header[1] = new BasicHeader(HDR_CONTENT_TYPE, "application/json");
        String responseBody = HttpConPoolUtil.post(url, "UTF-8", JsonUtil.toJson(params), header);
        LOG.info("doHttpPost, url={}| params={}| time={}| resp={}", uri, params, (System.currentTimeMillis() - start), responseBody);
        return responseBody;
    }

    /**
     * 取登录PaaS的地址，并拼接返回app的url地址，需要传入访问当前app的contextPath
     */
    public String getLoginUrl() {
        return bkCoreProperties.getPaasHost() + "/login/?app_id=" + bkCoreProperties.getAppCode() + "&c_url=" + urlEncode(bkCoreProperties.getAppHost());
    }
}
