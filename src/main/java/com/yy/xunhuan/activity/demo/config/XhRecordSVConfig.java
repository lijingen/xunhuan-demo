package com.yy.xunhuan.activity.demo.config;

import com.yy.cs.center.ReferenceFactory;
import com.yy.cs.common.service.util.Constants;
import com.yy.xunhuan.activity.demo.swift.XHRecordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/10/23.
 */
@Configuration
public class XhRecordSVConfig extends BaseCenterConfig{
    @Bean
    public ReferenceFactory<XHRecordService> xhRecordServiceFactory(){
        ReferenceFactory referenceFactory=new ReferenceFactory();
        referenceFactory.setGroup(group);
        referenceFactory.setCenterConfig(centerConfig());
        referenceFactory.setInterfaceName(XHRecordService.class.getName());
        referenceFactory.setProtocol(Constants.ServiceProtocolType.thrift);
        return referenceFactory;
    }
}
