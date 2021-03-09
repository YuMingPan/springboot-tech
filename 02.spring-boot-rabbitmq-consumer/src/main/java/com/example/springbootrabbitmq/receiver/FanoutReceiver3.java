package com.example.springbootrabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "MQ_FANOUTTEST_PROVIDER2CONSUMER_3")
public class FanoutReceiver3 {

    @RabbitHandler
    public void process(String msg) {
        Map msgMap = JSON.parseObject(msg, Map.class);
        System.out.println("FanoutReceiver3 消费者收到消息  : " + msgMap);
    }

}