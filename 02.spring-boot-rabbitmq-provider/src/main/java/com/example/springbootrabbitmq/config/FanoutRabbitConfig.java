package com.example.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic型交换机配置，其他类型交换机类似
 * 发送消息的时候，发现交换机不存在，才创建，如果交换机不存在且没发送消息，consumer启动不成功
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     *  创建三个队列 ：fanout_queue1  fanout_queue2  fanout_queue3
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */


    @Bean
    public Queue queueA() {
        return new Queue("MQ_FANOUTTEST_PROVIDER2CONSUMER_1");
    }

    @Bean
    public Queue queueB() {
        return new Queue("MQ_FANOUTTEST_PROVIDER2CONSUMER_2");
    }

    @Bean
    public Queue queueC() {
        return new Queue("MQ_FANOUTTEST_PROVIDER2CONSUMER_3");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }
}