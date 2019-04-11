/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.service.impl;

import com.tencent.examples.init.AppProperties;
import com.tencent.examples.service.DemoService;

/**
 * 虽然我们可以用@Service来自动注入，但是作为业务后台服务类，可能我们后续拆分出去独立部署，
 * 可能不会用Spring来作为IoC容器，有可能是自研的框架脱离了Spring，所以尽量减少对Spring注解的依赖
 *
 * 如何在SpringBoot中初始化这个服务类的代码见com.tencent.examples.init.bean.ServiceBeanInit
 * @see com.tencent.examples.init.bean.ServiceBeanConfiguration
 */
//@Service //我们可以用@Service来自动初始化这个类,这取决于你的项目
public class DemoServiceImpl implements DemoService {

    //    @Autowired  //我们可以用@Autowired来引入依赖,这取决于你的项目
    private AppProperties appConfig;

    public DemoServiceImpl(AppProperties appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public String getDemo() {
        return appConfig.getJustForDemo();
    }
}
