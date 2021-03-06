package com.example.springbootrabbitmq.controller;


import com.alibaba.fastjson.JSON;
import com.example.springbootrabbitmq.utils.MessageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SendDirectMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  // 使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        Map msgMap = MessageUtil.getMsg("测试Direct交换机，路由键为TestDirectRouting");
        String msg = JSON.toJSONString(msgMap);
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", msg);
        return "ok";
    }
}
