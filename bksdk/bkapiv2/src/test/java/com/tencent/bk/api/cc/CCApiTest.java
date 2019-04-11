package com.tencent.bk.api.cc;

import com.google.common.collect.Maps;
import com.tencent.bk.api.BaseClientTest;
import com.tencent.bk.api.cc.model.*;
import com.tencent.bk.api.cc.req.AddHostToResourceReq;
import com.tencent.bk.api.cc.req.GetHostBaseInfoReq;
import com.tencent.bk.api.cc.req.SearchHostReq;
import com.tencent.bk.api.cc.req.SearchModuleReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.init.BkCoreProperties;
import com.tencent.bk.utils.json.JsonUtil;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest(classes = {CCApi.class, BkCoreProperties.class})
public class CCApiTest extends BaseClientTest {
    @Autowired
    private CCApi ccApi;

    @Test
    public void addHostToResource() {
        AddHostToResourceReq esbReq = ccApi.makeBaseReq(AddHostToResourceReq.class, userName);
        esbReq.setBkBizId(3);
        Map<String, AddHostToResourceReq.ImportHostInfo> map = Maps.newHashMap();
        AddHostToResourceReq.ImportHostInfo info = new AddHostToResourceReq.ImportHostInfo();
        info.setBkCloudId(0);
        info.setIp("10.223.27.107");
        map.put("2", info);
        esbReq.setHostInfoMap(map);
        ApiResp<Void> hostBaseInfo = ccApi.addHostToResource(esbReq);
        System.out.println(JsonUtil.toJson(hostBaseInfo));
    }

    @Test
    public void createBusiness() {
    }

    @Test
    public void createCustomQuery() {
    }

    @Test
    public void createModule() {
    }

    @Test
    public void createSet() {
    }

    @Test
    public void deleteBuiness() {
    }

    @Test
    public void deleteCustomQuery() {
    }

    @Test
    public void deleteHost() {
    }

    @Test
    public void deleteModule() {
    }

    @Test
    public void deleteSet() {
    }

    @Test
    public void getCustomQueryData() {
    }

    @Test
    public void getCustomQueryDetail() {
    }

    @Test
    public void getHostBaseInfo() {
        GetHostBaseInfoReq esbReq = ccApi.makeBaseReq(GetHostBaseInfoReq.class, userName);
        esbReq.setBkHostId(1);
        ApiResp<List<Property>> hostBaseInfo = ccApi.getHostBaseInfo(esbReq);
        System.out.println(JsonUtil.toJson(hostBaseInfo));
    }

    @Test
    public void searchBizInstTopo() {
    }

    @Test
    public void searchBusiness() {
    }

    @Test
    public void searchCustomQuery() {
    }

    @Test
    public void searchHost() {
        { // 按模块类型搜索IP
            SearchHostReq esbReq = ccApi.makeBaseReq(SearchHostReq.class, userName);
            Set<CustomQueryCondition> queryConditions = Sets.newHashSet();
            CustomQueryCondition customQueryCondition = new CustomQueryCondition();
            customQueryCondition.setBkObjId("module");
            customQueryCondition.setCondition(Lists.newArrayList(new Condition("bk_module_type", "$eq", "1")));
            queryConditions.add(customQueryCondition);
            esbReq.setCondition(queryConditions);
            ApiResp<CommonSearchDataList> listApiResp = ccApi.searchHost(esbReq);
            System.out.println(JsonUtil.toJson(listApiResp));
        }

        { // ip模糊搜索
            String fuzzyIp = "113"; //搜索包含xxx的IP
            SearchHostReq esbReq = ccApi.makeBaseReq(SearchHostReq.class, userName);
            Set<CustomQueryCondition> queryConditions = Sets.newHashSet();
            CustomQueryCondition customQueryCondition = new CustomQueryCondition();
            customQueryCondition.setBkObjId("host");
            queryConditions.add(customQueryCondition);
            esbReq.setCondition(queryConditions);
            esbReq.setIp(new IpCondition(Lists.newArrayList(fuzzyIp), 0, "bk_host_innerip"));
            ApiResp<CommonSearchDataList> listApiResp = ccApi.searchHost(esbReq);
            System.out.println(JsonUtil.toJson(listApiResp));
        }
    }

    @Test
    public void searchInstByObject() {
    }

    @Test
    public void searchModule() {
        SearchModuleReq searchModuleReq = ccApi.makeBaseReq(SearchModuleReq.class,"admin");
        ApiResp<CommonSearchDataList> commonSearchDataListApiResp = ccApi.searchModule(searchModuleReq);
        System.out.println(JsonUtil.toJson(commonSearchDataListApiResp));
    }

    @Test
    public void searchSet() {
    }

    @Test
    public void transferHostModule() {
    }

    @Test
    public void transferHostToFaultModule() {
    }

    @Test
    public void transferHostToIdleModule() {
    }

    @Test
    public void transferHostToResourceModule() {
    }

    @Test
    public void transferResourceHostToIdleModule() {
    }

    @Test
    public void updateBusiness() {
    }

    @Test
    public void updateCustomQuery() {
    }

    @Test
    public void updateHost() {
    }

    @Test
    public void updateModule() {
    }

    @Test
    public void updateSet() {
    }
}