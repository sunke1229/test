package com.tencent.bk.api.login;

import com.tencent.bk.api.BaseClientTest;
import com.tencent.bk.api.login.model.BkUser;
import com.tencent.bk.api.login.req.GetBatchUserReq;
import com.tencent.bk.api.protocol.ApiReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.utils.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = {BKLoginApi.class, BkCoreProperties.class})
public class BKLoginApiTest extends BaseClientTest {

    @Autowired
    private BKLoginApi bkLoginApi;
    @Test
    public void getUserInfo() {
        ApiReq esbReq = bkLoginApi.makeBaseReqByWeb(ApiReq.class, request);
        ApiResp<BkUser> resp = bkLoginApi.getUserInfo(esbReq);
        System.out.println(JsonUtil.toJson(resp));
        ApiReq esbReq2 = bkLoginApi.makeBaseReq(ApiReq.class, userName);
        ApiResp<BkUser> resp2 = bkLoginApi.getUserInfo(esbReq2);
        System.out.println(JsonUtil.toJson(resp2));
    }

    @Test
    public void getAllUserInfo() {
        ApiReq esbReq = bkLoginApi.makeBaseReqByWeb(ApiReq.class, request);
        ApiResp<List<BkUser>> resp2 = bkLoginApi.getAllUserInfo(esbReq);
        System.out.println(JsonUtil.toJson(resp2));
    }

    @Test
    public void getBatchUser() {
        GetBatchUserReq esbReq = bkLoginApi.makeBaseReqByWeb(GetBatchUserReq.class, request);
        esbReq.setUserNameList("admin,jobdevelop");
        ApiResp<Map<String, BkUser>> resp2 = bkLoginApi.getBatchUser(esbReq);
        System.out.println(JsonUtil.toJson(resp2));
    }
}