package com.tencent.bk.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.api.protocol.ApiReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.DefaultSDKClient;
import com.tencent.bk.core.sdk.protocol.IReq;
import com.tencent.bk.utils.json.JsonUtil;

public abstract class Api extends DefaultSDKClient {

    public Api(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        super(bkCoreProperties, language);
    }

    protected <T> ApiResp<T> invokeGet(String apiUrl, ApiReq req, TypeReference<ApiResp<T>> typeReference) {
        try {
            String retStr = doHttpGet(apiUrl, req);
            return JsonUtil.fromJson(retStr, typeReference);
        } catch (Exception e) {
            LOG.error(apiUrl + " invoke fail", e);
            return buildFailResp(999, e.getMessage());
        }
    }

    protected <V> ApiResp<V> invokePost(String apiUrl, IReq req, TypeReference<ApiResp<V>> typeReference) {
        try {
            String retStr = doHttpPost(apiUrl, req);
            return JsonUtil.fromJson(retStr, typeReference);
        } catch (Exception e) {
            LOG.error(apiUrl + " invoke fail", e);
            return buildFailResp(999, e.getMessage());
        }
    }

    protected  <T> ApiResp<T> buildFailResp(int code, String message) {
        ApiResp<T> objectApiResp = new ApiResp<>();
        objectApiResp.setCode(code);
        objectApiResp.setMessage(message);
        return objectApiResp;
    }
}
