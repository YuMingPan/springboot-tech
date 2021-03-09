package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.utils.MessageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class Send2LonelyDirectExchangeController {

    private final RabbitTemplate rabbitTemplate;

    public Send2LonelyDirectExchangeController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/testMessageAck")
    public String TestMessageAck2() {
        Map msg = MessageUtil.getMsg("这条消息将会发送到一个Direct交换机，但是这个交换机没有绑定队列");
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", msg);
        return "ok";
    }
}
