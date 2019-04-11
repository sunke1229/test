/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.init.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Web Mvc配置
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 配置HttpMessageConverter用于解析请求内容并转换用指定的jackson转换器转换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(Charset.forName("utf-8")));
        converters.add(createHttpMessageConverter());
        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.setSupportedMediaTypes(Lists.newArrayList(
                MediaType.APPLICATION_FORM_URLENCODED,
                MediaType.APPLICATION_JSON_UTF8
        ));
        converters.add(formHttpMessageConverter);
    }

    private AbstractHttpMessageConverter<Object> createHttpMessageConverter() {
        //JSON多余的空格缩进符的格式化可能影响性能以及数据量大小,所以输出时不做排版格式化
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).build();
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    /**
     * 配置针对请求判断应该属于哪种content-type
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypes = Maps.newHashMap();
        mediaTypes.put("json", MediaType.APPLICATION_JSON_UTF8);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        configurer.mediaTypes(mediaTypes);
    }


    /**
     * Jsp页面解析器
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views", ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 指定路径对应的要跳转到哪些jsp页面
     * PS: 这里定义是适合给那些页面上是固化的内容，不是需要模板替换的页面，可以减少再定义Controller，直接在这个类定义好，SpringMVC会帮助注册映射类
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/info/guide").setViewName("/info/guide");
        registry.addViewController("/info/contactUs").setViewName("/info/contactUs");
        registry.addViewController("/demo/backstage").setViewName("/demo/backstage");
        registry.addViewController("/demo/tables").setViewName("/demo/tables");
        registry.addViewController("/").setViewName("/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/**.html").addResourceLocations("/");
        registry.addResourceHandler("/**.htm").addResourceLocations("/");
    }
}