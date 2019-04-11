/*
 * Copyright (c) 2017. Tencent BlueKing
 */

package com.tencent.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;


/**
 * 启动嵌入式的Tomcat并初始化Spring环境.
 * <p>
 * 全新的无任何spring的xml配置，
 * <p>
 * 1. 扫描当前package下的class设置自动注入的Bean<br/>
 * 2. 支持用@Bean标注的类配置Bean <br/>
 * 3. 根据classpath中的三方包Class以及application.properties条件配置三方包 <br/>
 * 4. 支持用@Configuration标注的类配置三方包.
 * </p>
 * <p>
 * 某些情况下可能仍然需要xml配置文件，可以用注释@ImportResource来引入Spring的配置文件
 * <p>
 * SpringBoot采用约定大于配置的风格，默认加载了大量自动配置加载类，比如DataSourceAutoConfiguration数据库配置，<br/>
 * 来简化开发者的配置，并在启动时自动创建数据库连接，但如果应用中确实不需要数据库，则会报错，可以在启动类增加注解：<br/>
 *
 * @ EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
 * <br/>来取消自动数据库配置。
 */
// 可以引入spring原来的工程的xml配置文件
//@ImportResource({"classpath:spring/*.xml"})

/*
    如果不想要数据库，则打开以下以避免加载默认数据库配置导致启动失败，比如微服务类前端接口网关系统，就不需要数据库，所有数据只向分布式后台服务接口
    获取，这种系统就不需要配置数据库了，那么就可以将下面两个AutoConfiguration配置项关掉。
  */
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

/* 指定开发者业务用的配置文件，找不到不报错，开发者可以全部业务用的配置放到application.properties */
@PropertySource(value = {"classpath:bkjava.properties"}, ignoreResourceNotFound = true)
@SpringBootApplication(scanBasePackages = {
        "com.tencent.bk",  //蓝鲸开发框架核心类
        "com.tencent.examples"  //示例类
})
@ServletComponentScan
public class BkWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BkWebApplication.class, args);
    }

}
