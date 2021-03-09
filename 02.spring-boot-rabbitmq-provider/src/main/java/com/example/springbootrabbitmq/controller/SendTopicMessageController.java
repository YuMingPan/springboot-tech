package com.example.springbootrabbitmq.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootrabbitmq.utils.MessageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SendTopicMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  // 使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1() {
        Map msgMap = MessageUtil.getMsg("测试Topic交换机，消息路由键为topic.1");
        String msg = JSON.toJSONString(msgMap);
        rabbitTemplate.convertAndSend("topicExchange", "topic.1", msg);
        return "ok";
    }

    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2() {
        Map msgMap = MessageUtil.getMsg("测试Topic交换机，消息路由键为topic.2");
        String msg = JSON.toJSONString(msgMap);
        rabbitTemplate.convertAndSend("topicExchange", "topic.2", msg);
        return "ok";
    }
}
