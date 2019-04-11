package com.tencent.bk.core.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.core.BkEnum;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import com.tencent.bk.core.sdk.protocol.ESBResp;
import com.tencent.bk.core.sdk.protocol.IReq;
import com.tencent.bk.utils.json.JsonUtil;

public abstract class Api extends DefaultSDKClient {

    public Api(BkCoreProperties bkCoreProperties, BkEnum.Lang language) {
        super(bkCoreProperties, language);
    }

    protected  <T> ESBResp<T> invokeGet(String apiUrl, ESBReq req, TypeReference<ESBResp<T>> typeReference) {
        try {
            String retStr = doHttpGet(apiUrl, req);
            return JsonUtil.fromJson(retStr, typeReference);
        } catch (Exception e) {
            LOG.error(apiUrl + " invoke fail", e);
            return buildFailResp(998, e.getMessage());
        }
    }

    protected <V> ESBResp<V> invokePost(String apiUrl, IReq req, TypeReference<ESBResp<V>> typeReference) {
        try {
            String retStr = doHttpPost(apiUrl, req);
            return JsonUtil.fromJson(retStr, typeReference);
        } catch (Exception e) {
            LOG.error(apiUrl + " invoke fail", e);
            return buildFailResp(998, e.getMessage());
        }
    }

    protected  <T> ESBResp<T> buildFailResp(int code, String message) {
        ESBResp<T> resp = new ESBResp<>();
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }
}
