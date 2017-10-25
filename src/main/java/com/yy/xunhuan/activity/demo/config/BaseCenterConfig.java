package com.yy.xunhuan.activity.demo.config;

import com.yy.cs.common.service.config.CenterConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/10/23.
 */

public abstract class BaseCenterConfig {
    @Value("${service.center.address}")
    protected String address;

    @Value("${service.application}")
    protected String application;

    @Value("${service.center.group}")
    protected String group;
    @Bean
    public CenterConfig centerConfig(){
        CenterConfig centerConfig=new CenterConfig(address);
        centerConfig.setApplication(application);
        return centerConfig;
    }
}
