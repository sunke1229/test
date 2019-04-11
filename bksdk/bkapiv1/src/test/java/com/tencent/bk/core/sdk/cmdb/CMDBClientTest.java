/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.bk.core.sdk.cmdb;

import com.tencent.bk.core.BkConsts;
import com.tencent.bk.core.dto.cmdb.ApplicationDto;
import com.tencent.bk.core.dto.cmdb.HostDto;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.core.sdk.BaseClientTest;
import com.tencent.bk.core.sdk.cmdb.protocol.AddPlatIdReq;
import com.tencent.bk.core.sdk.cmdb.protocol.CloneHostPropertyReq;
import com.tencent.bk.core.sdk.cmdb.protocol.GetAppByUserReq;
import com.tencent.bk.core.sdk.cmdb.protocol.GetAppHostListReq;
import com.tencent.bk.core.sdk.protocol.ESBResp;
import com.tencent.bk.utils.json.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 测试用例
 */
@SpringBootTest(classes = {CMDBClient.class, BkCoreProperties.class})
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:test.properties")
public class CMDBClientTest extends BaseClientTest {

    @Autowired
    private CMDBClient cmdbClient;

    private HttpServletRequest request = new MockHttpServletRequest();

    @Before
    public void setUp() {
        ((MockHttpServletRequest) request).setCookies(new Cookie(BkConsts.C_BK_TOKEN, bkToken));
    }


    @Test
    public void cloneHostProperty() {
        {
            CloneHostPropertyReq req = cmdbClient.makeBaseReqByWeb(CloneHostPropertyReq.class, request);
            req.setPlatName("test子网1");
            req.setPlatId(8);
            req.setApplicationId(3);
            req.setDestIp("1.1.1.1");
            req.setOriginIp("1.1.1.2");
            ESBResp<Void> longESBResp = cmdbClient.cloneHostProperty(req);
            System.out.println(longESBResp);
        }
        {
            CloneHostPropertyReq req = cmdbClient.makeBaseReq(CloneHostPropertyReq.class, userName);
            req.setPlatName("test子网2");
            req.setPlatId(8);
            req.setApplicationId(3);
            req.setDestIp("1.1.1.1");
            req.setOriginIp("1.1.1.2");
            ESBResp<Void> longESBResp = cmdbClient.cloneHostProperty(req);
            System.out.println(longESBResp);
        }
    }
    @Test
    public void addPlatId() {
        {
            AddPlatIdReq req = cmdbClient.makeBaseReqByWeb(AddPlatIdReq.class, request);
            req.setPlatName("test子网");
            ESBResp<Integer> longESBResp = cmdbClient.addPlatId(req);
            System.out.println(longESBResp);
        }
        { //通过用户名---后台任务，需要将当前app加到白名单
            AddPlatIdReq req = cmdbClient.makeBaseReq(AddPlatIdReq.class, userName);
            req.setPlatName("test子网2");
            ESBResp<Integer> longESBResp = cmdbClient.addPlatId(req);
            System.out.println(longESBResp);
        }
    }

    @Test
    public void getAppByUserTest(){
        GetAppByUserReq esbReq = cmdbClient.makeBaseReq(GetAppByUserReq.class,userName);
        ESBResp<List<ApplicationDto>> list =cmdbClient.getAppByUser(esbReq);
        System.out.println(JsonUtil.toJson(list));
    }

    @Test
    public void getAppHostList(){
        GetAppHostListReq esbReq = cmdbClient.makeBaseReq(GetAppHostListReq.class,userName);
        ESBResp<List<HostDto>> list =cmdbClient.getAppHostList(esbReq);
        System.out.println(JsonUtil.toJson(list));
    }

}