/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.init.bean;

import com.tencent.examples.init.AppProperties;
import com.tencent.examples.service.DemoService;
import com.tencent.examples.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class ServiceBeanConfiguration {

    /**
     * 主要演示通过@Configuration来创建Bean对象，类似xml时代<bean id="xx" class="xxx"/>
     */
    @Bean
    public DemoService demoService(@Autowired AppProperties appConfig) {
        return new DemoServiceImpl(appConfig);
    }







}
