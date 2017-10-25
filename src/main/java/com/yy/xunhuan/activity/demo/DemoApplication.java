package com.yy.xunhuan.activity.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017/10/23.
 */
@SpringBootApplication
@PropertySource("classpath:project.properties")
@MapperScan("com.yy.xunhuan.activity.demo.dao.gen.mapper")
public class DemoApplication {
    public static void main(String args[]){
        SpringApplication.run(DemoApplication.class);
    }
}
