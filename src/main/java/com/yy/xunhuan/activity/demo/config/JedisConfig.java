package com.yy.xunhuan.activity.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2017/10/25.
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisPool jedisPool(){
        return new JedisPool(jedisPoolConfig(),"61.160.35.6");
    }
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setMaxWaitMillis(-1);
        jedisPoolConfig.setMaxIdle(20000);
        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setNumTestsPerEvictionRun(3);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1800000);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestWhileIdle(false);
        return jedisPoolConfig;
    }
    @Bean
    public Jedis myJedis(){
        return jedisPool().getResource();
    }
}
