//package com.example.springbootrabbitmq.config;
//
//
//import com.example.springbootrabbitmq.receiver.MyAckReceiver;
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 这里只是配置了监听器容器，需要设置进去监听器(@RabbitListener)
// * 具体如何处理回调需要看myAckReceiver(@RabbitListener)中对应的处理(@RabbitHandler)
// **/
//@Configuration
//public class MessageListenerConfig {
//
//    @Autowired
//    private CachingConnectionFactory connectionFactory;
//    @Autowired
//    private MyAckReceiver myAckReceiver;// 消息接收处理类
//
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setConcurrentConsumers(1);
//        container.setMaxConcurrentConsumers(1);
//        // RabbitMQ默认是自动确认，这里改为手动确认消息
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        //设置一个队列
//        container.setQueueNames("MQ_DIRECTTEST_PROVIDER2CONSUMER");
//        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
////          container.setQueueNames("QName1","QName2","QName3");
//        //另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
////        container.setQueues(new Queue("QName1",true));
////        container.addQueues(new Queue("QName2",true));
////        container.addQueues(new Queue("QName3",true));
//        // 设置监听器
//        container.setMessageListener(myAckReceiver);
//        return container;
//    }
//}