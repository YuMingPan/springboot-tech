package com.example.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanout型交换机配置，其他类型交换机类似
 * 发送消息的时候，发现交换机不存在，才创建，如果交换机不存在且没发送消息，consumer启动不成功
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue firstQueue() {
        // 这里只是设置队列名
        return new Queue("MQ_TOPICTEST_PROVIDER2CONSUMER_1");
    }

    @Bean
    public Queue secondQueue() {
        // 这里只是设置队列名
        return new Queue("MQ_TOPICTEST_PROVIDER2CONSUMER_2");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    // 将firstQueue和topicExchange绑定
    @Bean
    Binding bindingExchangeMessage() {
        // 通过 topic.man 可以分发到 queue1
        return BindingBuilder.bind(firstQueue()).to(exchange()).with("topic.1");
    }

    // 将secondQueue和topicExchange绑定
    @Bean
    Binding bindingExchangeMessage2() {
        // 通过 topic.# 可以分发到 queue2
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}