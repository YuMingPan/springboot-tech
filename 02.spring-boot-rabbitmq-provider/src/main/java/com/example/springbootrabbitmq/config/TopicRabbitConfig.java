package com.example.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue firstQueue() {
        // 这里只是设置队列名
        return new Queue("queue1");
    }

    @Bean
    public Queue secondQueue() {
        // 这里只是设置队列名
        return new Queue("queue2");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    // 将firstQueue和topicExchange绑定
    @Bean
    Binding bindingExchangeMessage() {
        // 通过 topic.man 可以分发到 queue1
        return BindingBuilder.bind(firstQueue()).to(exchange()).with("topic.man");
    }

    // 将secondQueue和topicExchange绑定
    @Bean
    Binding bindingExchangeMessage2() {
        // 通过 topic.# 可以分发到 queue2
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}