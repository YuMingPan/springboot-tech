package com.example.springbootrabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * rabbitmq监听器，监听的队列名称 TestDirectQueue，与rabbitmq处理器搭配使用
 * 如果多台监听器绑定到同一个队列上，则会通过轮询的方式对消息进行消费，不存在重复消费
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver1 {

    /**
     * rabbitmq处理器，与rabbitmq监听器搭配使用
     */
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver1消费者收到消息  : " + testMessage.toString());
    }

}