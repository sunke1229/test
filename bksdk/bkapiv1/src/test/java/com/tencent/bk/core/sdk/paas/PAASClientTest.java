/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.paas;

import com.tencent.bk.core.dto.login.BkUserDto;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.BaseClientTest;
import com.tencent.bk.core.sdk.paas.protocol.GetBatchUserReq;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import com.tencent.bk.core.sdk.protocol.ESBResp;
import com.tencent.bk.utils.json.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * 测试用例
 */
@SpringBootTest(classes = {PAASClient.class, BkCoreProperties.class})
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:test.properties")
public class PAASClientTest extends BaseClientTest {

    @Autowired
    private PAASClient paasClient;


    @Test
    public void getUserInfo() throws Exception {
        ESBReq esbReq = paasClient.makeBaseReq(ESBReq.class, userName);
        ESBResp<BkUserDto> resp = paasClient.getUserInfo(esbReq);
        System.out.println(JsonUtil.toJson(resp));
    }

    @Test
    public void getAllUserInfo() throws Exception {
        ESBReq esbReq = paasClient.makeBaseReq(ESBReq.class, userName);
        ESBResp<List<BkUserDto>> resp = paasClient.getAllUserInfo(esbReq);
        System.out.println(JsonUtil.toJson(resp));
    }

    @Test
    public void getBatchUser() throws Exception {
        GetBatchUserReq esbReq = paasClient.makeBaseReq(GetBatchUserReq.class, userName);
        esbReq.setUserNameList("admin,irwinsun");
        ESBResp<Map<String, BkUserDto>> resp = paasClient.getBatchUser(esbReq);
        System.out.println(JsonUtil.toJson(resp));
    }
}