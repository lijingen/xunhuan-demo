package com.yy.xunhuan.activity.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/24.
 */
@Configuration
public class RabbitMQConfig {

    @Value("${c.rabbitmq.addresses}")
    private String address;
    @Value("${c.rabbitmq.username}")
    private String userName;
    @Value("${c.rabbitmq.password}")
    private String password;
    @Resource
    private ChannelAwareMessageListener gameInfoMessageListener;
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(userName);
        connectionFactory.setAddresses(address);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        AmqpAdmin amqpAdmin = new RabbitAdmin(connectionFactory());
        return amqpAdmin;
    }
    @Bean
    public TopicExchange topicExchange(){
        TopicExchange topicExchange=new TopicExchange("xh_werwolf_stat");
        return topicExchange;
    }
    @Bean
    public Queue gameInfoQueue(){
        Queue queue=QueueBuilder.durable("xh.werwolf.game.queue3").withArgument("x-max-length",20000).build();
        queue.setAdminsThatShouldDeclare(amqpAdmin());
        return queue;
    }
    @Bean
    public Binding gameInfoBinding(){
        return BindingBuilder.bind(gameInfoQueue()).to(topicExchange()).with("xh_werwolf_stat_game_info");
    }
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer=new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setQueues(gameInfoQueue());
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setMessageListener(gameInfoMessageListener);
        simpleMessageListenerContainer.setConcurrentConsumers(30);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(40);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return simpleMessageListenerContainer;
    }
}
