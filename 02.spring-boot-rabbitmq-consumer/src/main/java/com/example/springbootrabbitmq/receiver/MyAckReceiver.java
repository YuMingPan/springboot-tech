package com.example.springbootrabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 之前通过@RabbitListener和@RabbitHandler来处理数据
 * 现在通过实现ChannelAwareMessageListener来处理数据
 */
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            Map msgMap = JSON.parseObject(new String(message.getBody(), StandardCharsets.UTF_8), Map.class);
            System.out.println("message:" + message.toString());
            System.out.println("消息：" + msgMap);
            System.out.println("消费的主题消息来自：" + message.getMessageProperties().getConsumerQueue());
            // 第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值(传入值应该需在队列存在)的所有消息，一般false就行
            channel.basicAck(deliveryTag, false);
            // 第二个参数，true会重新放回队列，注释掉DirectReceiver1类和DirectReceiver2类查看效果
//            channel.basicReject(deliveryTag, true);
        } catch (Exception e) {
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }
    }
}