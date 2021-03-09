package com.example.springbootrabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 简便写法，就这？？？
 * 实际上rabbitmq都已经在服务器配置好了，我们只需要监听它并处理即可
 */
@Component
public class SimpleReceive {

    @RabbitListener(queues = "MQ_DIRECTTEST_PROVIDER2CONSUMER")
    public void receive(Message message, Channel channel) {
        String msg = "";
        try {
            // 1.确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 2.处理消息
            msg = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("SimpleReceive 收到消息：" + JSON.parseObject(msg, Map.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
