package com.haoshuai.app.controller.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean spaceFilter() {
        FilterRegistrationBean fitler = new FilterRegistrationBean();
        fitler.setFilter(new SpaceFilter());
        fitler.addUrlPatterns("/*");
        fitler.setName("SpaceFilter");
        fitler.setDispatcherTypes(DispatcherType.REQUEST);
        return fitler;
    }
}
