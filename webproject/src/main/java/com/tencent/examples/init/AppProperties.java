/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.init;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 演示了如何用Spring的配置文件，以及只提供get方法保证只读
 * 读取来源可以是application.properties 及相应环境的配置文件
 * 或者开发者业务自定义的properties文件，例如本示例的resources下的bkjava.properties
 */
@Configuration
@Getter //lombok 会帮助生成getter方法
public class AppProperties {

    /**
     * 这个是从bkjava.properties配置文件中读取的一个配置项
     */
    @Value("${bk.business.demo}")
    private String justForDemo;
}
