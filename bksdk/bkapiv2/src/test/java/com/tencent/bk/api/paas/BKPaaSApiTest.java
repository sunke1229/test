package com.tencent.bk.api.paas;

import com.tencent.bk.api.BaseClientTest;
import com.tencent.bk.api.paas.model.CreateApp;
import com.tencent.bk.api.paas.model.GetAppInfo;
import com.tencent.bk.api.paas.req.*;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.utils.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {BKPaaSApi.class, BkCoreProperties.class})
public class BKPaaSApiTest extends BaseClientTest {

    @Autowired
    private BKPaaSApi bkPaaSApi;

    @Test
    public void createApp() {
        CreateAppReq createAppReq = bkPaaSApi.makeBaseReq(CreateAppReq.class, userName);
        createAppReq.setAppName("app4");
        createAppReq.setAppUrl(bkPaaSHost + "/o/ff");
        createAppReq.setAppTag("OpsTools");
        createAppReq.setHeight(720);
        createAppReq.setWidth(1280);
        createAppReq.setIntroduction("this is a app");
        createAppReq.setDeveloper("hello");
        ApiResp<CreateApp> app = bkPaaSApi.createApp(createAppReq);
        System.out.println(JsonUtil.toJson(app));

        {
            EditAppReq editAppReq = bkPaaSApi.makeBaseReq(EditAppReq.class, userName);
            editAppReq.setBkLightAppCode(app.getData().getAppCode());
            editAppReq.setAppName("light app" + System.currentTimeMillis());
            ApiResp<Void> voidApiResp = bkPaaSApi.editApp(editAppReq);
            System.out.println(JsonUtil.toJson(voidApiResp));
        }
        {
            DeleteAppReq deleteAppReq = bkPaaSApi.makeBaseReq(DeleteAppReq.class, userName);
            deleteAppReq.setBkLightAppCode(app.getData().getAppCode());
            deleteAppReq.setBkLightAppCode("bkjavademo_nr1p5");
            ApiResp<Void> voidApiResp = bkPaaSApi.deleteApp(deleteAppReq);
            System.out.println(JsonUtil.toJson(voidApiResp));
        }
    }


    @Test
    public void getAppInfo() {
        GetAppInfoReq getAppInfoReq = bkPaaSApi.makeBaseReq(GetAppInfoReq.class, "cmdbdevelop");
        //getAppInfoReq.setTargetAppCodes("");
        getAppInfoReq.setFields("introduction,creator,developer");
        ApiResp<List<GetAppInfo>> appInfo = bkPaaSApi.getAppInfo(getAppInfoReq);
        System.out.println(JsonUtil.toJson(appInfo));
    }

    @Test
    public void modifyAppLogo() {
        ModifyAppLogoReq getAppInfoReq = bkPaaSApi.makeBaseReq(ModifyAppLogoReq.class, userName);
        getAppInfoReq.setBkLightAppCode("bkjavademo");
        ApiResp<Void> appInfo = bkPaaSApi.modifyAppLogo(getAppInfoReq);

        System.out.println(JsonUtil.toJson(appInfo));
    }
}