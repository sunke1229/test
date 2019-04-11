package com.tencent.examples.demo.web.rest;

import com.tencent.bk.api.job.JobApi;
import com.tencent.bk.api.job.model.Job;
import com.tencent.bk.api.job.req.GetJobListReq;
import com.tencent.bk.api.paas.BKPaaSApi;
import com.tencent.bk.api.paas.model.GetAppInfo;
import com.tencent.bk.api.paas.req.GetAppInfoReq;
import com.tencent.bk.api.protocol.ApiResp;
import com.tencent.bk.core.BkConsts;
import com.tencent.bk.core.dto.cmdb.ApplicationDto;
import com.tencent.bk.core.dto.cmdb.HostDto;
import com.tencent.bk.core.dto.login.BkUserDto;
import com.tencent.bk.core.sdk.cmdb.CMDBClient;
import com.tencent.bk.core.sdk.cmdb.protocol.GetAppByUserReq;
import com.tencent.bk.core.sdk.cmdb.protocol.GetAppHostListReq;
import com.tencent.bk.core.sdk.paas.PAASClient;
import com.tencent.bk.core.sdk.paas.protocol.GetBatchUserReq;
import com.tencent.bk.core.sdk.protocol.ESBReq;
import com.tencent.bk.core.sdk.protocol.ESBResp;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;
import com.tencent.bk.utils.json.JsonUtil;
import com.tencent.bk.utils.string.StringUtil;
import com.tencent.examples.demo.model.*;
import com.tencent.examples.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController extends BaseController {

    @Autowired
    private CMDBClient cmdbClient;
    @Autowired
    private PAASClient paasClient;
    @Autowired
    private JobApi jobApi;
    @Autowired
    private BKPaaSApi bkPaaSApi;


    @RequestMapping("/user/getapp")
    public @ResponseBody
    String demo() {
        GetAppByUserReq getAppByUserReq = cmdbClient.makeBaseReqByWeb(GetAppByUserReq.class, request);
        ESBResp<List<ApplicationDto>> appByUser = cmdbClient.getAppByUser(getAppByUserReq);
        return JsonUtil.toJson(appByUser);
    }

    @RequestMapping("/user/chartc")
    public @ResponseBody
    String chartc() {
        GetAppByUserReq getAppByUserReq = cmdbClient.makeBaseReqByWeb(GetAppByUserReq.class, request);
        GetAppHostListReq getAppHostListReq = cmdbClient.makeBaseReqByWeb(GetAppHostListReq.class, request);
        ESBResp<List<ApplicationDto>> appByUser = cmdbClient.getAppByUser(getAppByUserReq);
        List<ApplicationDto> applist = appByUser.getData();
        List<ChartC> cs = new ArrayList<>();
        if(applist!=null && applist.size()>0){
            for (ApplicationDto applicationDto : applist) {
                ChartC chartC = new ChartC();
                getAppHostListReq.setApplicationId(applicationDto.getApplicationId());
                chartC.setCategory(applicationDto.getApplicationName());
                ESBResp<List<HostDto>> appHostList = cmdbClient.getAppHostList(getAppHostListReq);
                if (appHostList != null && appHostList.getData() != null)
                    chartC.setValue(appHostList.getData().size());
                cs.add(chartC);
            }
        }else{
            ChartC chartC = new ChartC();
            chartC.setCategory("无业务");
            chartC.setValue(0);
            cs.add(chartC);
        }
        return JsonUtil.toJson(cs);
    }

    @RequestMapping("/user/chartd")
    public @ResponseBody
    String chartd() {
        GetAppByUserReq getAppByUserReq = cmdbClient.makeBaseReqByWeb(GetAppByUserReq.class, request);
        GetAppHostListReq getAppHostListReq = cmdbClient.makeBaseReqByWeb(GetAppHostListReq.class, request);
        ESBResp<List<ApplicationDto>> appByUser = cmdbClient.getAppByUser(getAppByUserReq);
        List<ApplicationDto> applist = appByUser.getData();
        List<String> appnames = new LinkedList<>();
        List<Integer> counts = new LinkedList<>();
        ChartD chartD = new ChartD();
        if(applist!=null && applist.size()>0){
            for (ApplicationDto applicationDto : applist) {
                appnames.add(applicationDto.getApplicationName());
                getAppHostListReq.setApplicationId(applicationDto.getApplicationId());
                List<HostDto> data = cmdbClient.getAppHostList(getAppHostListReq).getData();
                counts.add(data !=null? data.size():0);
            }
        }
        chartD.setAppnames(appnames);
        chartD.setCounts(counts);
        User user=FilterUtil.getSessionAttribute(session, BkConsts.USER_SESSION, User.class);
        if(user!=null){
            chartD.setName(user.getChname() + "的业务");
        }
        return JsonUtil.toJson(chartD);
    }


    @RequestMapping("/user/getalluser")
    public @ResponseBody
    String getAllUsers(Integer limit, Integer offset, String search) {

        ESBReq esbReq = paasClient.makeBaseReqByWeb(ESBReq.class, request);
        ESBResp<List<BkUserDto>> allUserInfo = paasClient.getAllUserInfo(esbReq);

        GetBatchUserReq getBatchUserReq = paasClient.makeBaseReqByWeb(GetBatchUserReq.class, request);
        Integer total = 0;
        PageInfo<List<BkUserDto>> pageInfo = new PageInfo<>();
        if (StringUtil.isNotBlank(search)) {
            getBatchUserReq.setUserNameList(search);
            ESBResp<Map<String, BkUserDto>> batchUser = paasClient.getBatchUser(getBatchUserReq);
            Map<String, BkUserDto> map = batchUser.getData();

            if (map == null) {
                return null;
            }
            List<BkUserDto> values = new ArrayList<>(map.values());
            total = values.size();
            pageInfo.setRows(values);
        } else {
            if(allUserInfo.getData()!=null && allUserInfo.getData().size()>0){
                total = allUserInfo.getData().size();
                if (offset + limit > total) {
                    pageInfo.setRows(allUserInfo.getData().subList(offset, total));
                } else {
                    pageInfo.setRows(allUserInfo.getData().subList(offset, offset + limit));
                }
            }
        }
        pageInfo.setTotal(total);
        return JsonUtil.toJson(pageInfo);
    }


    @RequestMapping(value = "/user/joblist", method = RequestMethod.POST)
    @ResponseBody
    public String getJobList() {
        //获取用户下的业务列表
        ChartD chartD = getChartD();
        return JsonUtil.toJson(chartD);
    }

    @RequestMapping(value = "/user/userinfo")
    @ResponseBody
    public String userinfo() {
        ESBReq esbReq = paasClient.makeBaseReqByWeb(ESBReq.class, request);
        ESBResp<BkUserDto> userInfo = paasClient.getUserInfo(esbReq);
        return JsonUtil.toJson(userInfo);
    }

    @RequestMapping(value = "/user/joblistdetail")
    @ResponseBody
    public String getJobListDetail(Integer limit, Integer offset) {
        PageInfo<List<Job>> pageInfo = new PageInfo<>();
        List<Job> jobs = getChartD().getJobs();
        if(jobs!=null && jobs.size()>0){
            int total = jobs.size();
            if (offset + limit > total) {
                pageInfo.setRows(jobs.subList(offset, total));
            } else {
                pageInfo.setRows(jobs.subList(offset, offset + limit));
            }
            pageInfo.setTotal(total);
        }
        return JsonUtil.toJson(pageInfo);
    }


    //首页概述
    @RequestMapping(value = "/user/summary", method = RequestMethod.POST)
    @ResponseBody
    public String summary() {
        Summary summary = new Summary();

        GetAppByUserReq getAppByUserReq = cmdbClient.makeBaseReqByWeb(GetAppByUserReq.class, request);
        ESBResp<List<ApplicationDto>> appByUser = cmdbClient.getAppByUser(getAppByUserReq);
        List<ApplicationDto> applist = appByUser.getData();
        if(applist!=null){
            summary.setApp_count(applist.size());
        }

        ESBReq esbReq = paasClient.makeBaseReqByWeb(ESBReq.class, request);
        ESBResp<List<BkUserDto>> allUserInfo = paasClient.getAllUserInfo(esbReq);
        if(allUserInfo.getData()!=null){
            summary.setUser_count(allUserInfo.getData().size());
        }

        //GetAppInfoReq getAppInfoReq = bkPaaSApi.makeBaseReq(GetAppInfoReq.class, FilterUtil.getSessionAttribute(session, BkConsts.USER_SESSION, User.class).getUsername());
        GetAppInfoReq getAppInfoReq = bkPaaSApi.makeBaseReqByWeb(GetAppInfoReq.class,request);
        getAppInfoReq.setTargetAppCodes(null);
        getAppInfoReq.setFields("introduction,creator,developer");
        ApiResp<List<GetAppInfo>> appInfo = bkPaaSApi.getAppInfo(getAppInfoReq);
        if (appInfo.getData() != null) {
            summary.setLightapp_count(appInfo.getData().size());
        } else {
            summary.setLightapp_count(0);
        }

        summary.setJob_count(getChartD().getTotal());
        return JsonUtil.toJson(summary);
    }

    private ChartD getChartD() {
        //获取用户下的业务列表
        GetAppByUserReq getAppByUserReq = cmdbClient.makeBaseReqByWeb(GetAppByUserReq.class, request);
        ESBResp<List<ApplicationDto>> appByUser = cmdbClient.getAppByUser(getAppByUserReq);
        List<ApplicationDto> applist = appByUser.getData();
        //作业总数
        int sum = 0;
        List<String> appnames = new LinkedList<>();
        List<Integer> counts = new LinkedList<>();
        ChartD chartD = new ChartD();
        //查询每个业务下的作业数
        GetJobListReq getJobListReq = jobApi.makeBaseReqByWeb(GetJobListReq.class, request);

        List<Job> jobs = new ArrayList<>();
        //要查出作业总数 每个业务（名称）对应的作业数（数量）
        if(applist!=null){
            for (ApplicationDto applicationDto : applist) {
                int applicationId = applicationDto.getApplicationId();
                getJobListReq.setBkBizId(applicationId);
                ApiResp<List<Job>> jobList = jobApi.getJobList(getJobListReq);
                appnames.add(applicationDto.getApplicationName());
                if (jobList.getData() != null) {
                    counts.add(jobList.getData().size());
                    sum += jobList.getData().size();
                    jobs.addAll(jobList.getData());
                }
            }
        }
        chartD.setCounts(counts);
        chartD.setAppnames(appnames);
        chartD.setTotal(sum);
        chartD.setName("常用作用分布");
        chartD.setJobs(jobs);
        return chartD;
    }


}
