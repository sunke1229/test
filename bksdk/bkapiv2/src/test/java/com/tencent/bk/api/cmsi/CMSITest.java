package com.tencent.bk.api.cmsi;

import com.tencent.bk.api.BaseClientTest;
import com.tencent.bk.api.cc.CCApi;
import com.tencent.bk.api.cmsi.req.SendMailReq;
import com.tencent.bk.api.cmsi.req.SendQyWxReq;
import com.tencent.bk.api.cmsi.req.SendSmsReq;
import com.tencent.bk.api.cmsi.req.SendWxReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.utils.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CMSIApi.class, BkCoreProperties.class})
public class CMSITest extends BaseClientTest {
    @Autowired
    private CMSIApi cmsiApi;

    @Test
    public void send() {
        SendMailReq req=cmsiApi.makeBaseReq(SendMailReq.class,"admin");
        req.setContent("test");
        req.setTitle("sssss");
        req.setReceiverAddresses("503289801@qq.com");

        ApiResp<Void> apiResp = cmsiApi.sendMail(req);
        System.out.println(JsonUtil.toJson(apiResp));
    }
}
