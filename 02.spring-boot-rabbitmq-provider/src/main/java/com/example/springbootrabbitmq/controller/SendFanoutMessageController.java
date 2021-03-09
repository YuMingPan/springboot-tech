package com.example.springbootrabbitmq.controller;


import com.alibaba.fastjson.JSON;
import com.example.springbootrabbitmq.utils.MessageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SendFanoutMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  // 使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendFanoutMessage")
    public String sendDirectMessage() {
        Map msgMap = MessageUtil.getMsg("测试Topic交换机，没有路由键");
        String msg = JSON.toJSONString(msgMap);
        // 将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("fanoutExchange", null, msg);
        return "ok";
    }
}
