package com.example.springbootrabbitmq.receiver;


import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "MQ_TOPICTEST_PROVIDER2CONSUMER_2")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        Map msgMap = JSON.parseObject(msg, Map.class);
        System.out.println("收到来自队列MQ_TOPICTEST_PROVIDER2CONSUMER_2(topic.#)的消息  : " + msgMap);
    }
}
